package com.example.myapplication;

public interface FirestoreCallback {
    void onSuccess();
    void onFailure(String error);
}
