package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity {
    ImageView btnUserProfile, btnHamburger;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button btnAddCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btnUserProfile = findViewById(R.id.btnUserProfile);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        btnHamburger = findViewById(R.id.btnHambergerMenu);
        btnAddCar = findViewById(R.id.btnAddCar);
        btnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
            }
        });

        btnUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, UserProfile.class);
                startActivity(intent);
            }
        });

        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
