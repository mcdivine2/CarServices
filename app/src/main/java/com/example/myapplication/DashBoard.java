package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.navigation.NavigationView;
import com.example.myapplication.NavigationMenuController;

public class DashBoard extends AppCompatActivity {
    ImageView btnUserProfile, btnHamburgerMenu;
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
        btnHamburgerMenu = findViewById(R.id.btnHamburgerMenu);
        btnAddCar = findViewById(R.id.btnAddCar);
        btnHamburgerMenu.setOnClickListener(new View.OnClickListener() {
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


    private void openHomeActivity() {
        Intent intent = new Intent(DashBoard.this, DashBoard.class); // Replace DashBoard with the actual name of your home activity.
        startActivity(intent);
    }
    private void openCarPrice() {
        Intent intent = new Intent(DashBoard.this, CarPrice.class); // Replace DashBoard with the actual name of your home activity.
        startActivity(intent);
    }

}