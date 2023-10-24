package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class Firestore {
    private FirebaseFirestore firestore;
    Cars cars = new Cars();

    public Firestore() {
        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance();
    }

    public void addCar(Context context,int ID, String name, String model, String year, FirestoreCallback callback) {
        Map<String, Object> car = new HashMap<>();
        car.put("ID", ID);
        car.put("Name", name);
        car.put("Model", model);
        car.put("Years", year);

        firestore.collection("cars").add(car)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Handle success and call the onSuccess callback
                        callback.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle failure and call the onFailure callback
                        callback.onFailure(e.getMessage());
                    }
                });
    }

    public void readCar(int carID, FirestoreCallback callback) {
        firestore.collection("cars")
                .whereEqualTo("ID", carID) // Query for cars with the same ID
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        // Car with the same ID already exists
                        callback.onFailure("Car with the same ID already exists");
                    } else {
                        // Car with the same ID doesn't exist, you can add it
                        callback.onSuccess();
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle the failure
                    callback.onFailure(e.getMessage());
                });
    }
}
