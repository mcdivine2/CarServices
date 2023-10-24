package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
    EditText txtCarName, txtCarModel, txtCarYear, txtCarID;
    Button btnAddCars, btnTerminate;

    Firestore firestore = new Firestore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCars();
        setIntegerInputFilter(txtCarYear);
        setIntegerInputFilter(txtCarID);

        btnTerminate = findViewById(R.id.btnTerminate);

        // Add a click listener to the Terminate button
        btnTerminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminateApp();
            }
        });
    }

    public void addCars() {
        btnAddCars = findViewById(R.id.btnAddCars);
        txtCarID = findViewById(R.id.txtCarID);
        txtCarName = findViewById(R.id.txtCarName);
        txtCarModel = findViewById(R.id.txtCarModel);
        txtCarYear = findViewById(R.id.txtCarYear);

        btnAddCars.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Cars car = new Cars();

                String carIDText = txtCarID.getText().toString(); // Get the text from the EditText
                String carName = txtCarName.getText().toString();
                String carModel = txtCarModel.getText().toString();
                String carYear = txtCarYear.getText().toString();

                // Check if any of the input fields are empty
                if (carIDText.isEmpty() || carName.isEmpty() || carModel.isEmpty() || carYear.isEmpty()) {
                    showToast("Please fill in all fields.");
                } else {
                    firestore.readCar(Integer.parseInt(carIDText), new FirestoreCallback() {
                        @Override
                        public void onSuccess() {
                            // Car doesn't exist with the same ID, proceed with adding it
                            firestore.addCar(MainActivity.this, Integer.parseInt(carIDText), carName, carModel, carYear, new FirestoreCallback() {
                                @Override
                                public void onSuccess() {
                                    showToast("Car added successfully");
                                }

                                @Override
                                public void onFailure(String errorMessage) {
                                    showToast("Error adding car: " + errorMessage);
                                }
                            });
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            // Car with the same ID already exists, show an error message
                            showToast(errorMessage);
                        }
                    });
                }

                car.setCar(Integer.parseInt(carIDText), carName, carModel, carYear);
                String carDetails = car.getCar();
                System.out.println(carDetails);  // Use the correct "System.out" method
            }
        });
    }

    // Function to enforce integer input
    private void setIntegerInputFilter(EditText editText) {
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i))) {
                        // Display a Toast message when non-integer characters are entered
                        showToast("Only integers are allowed");
                        return "";
                    }
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[] { filter });
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    private void terminateApp() {
        finish(); // Terminate the current activity and exit the app.
    }
}
