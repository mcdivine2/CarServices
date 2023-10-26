package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.navigation.NavigationView;

public class UserProfile extends AppCompatActivity {
    ImageView btnHome, btnUserProfile, btnHamburgerMenu;
    NavigationView navigationView;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        btnHome = findViewById(R.id.btnHome);
        btnUserProfile = findViewById(R.id.btnUserProfile);
        btnHamburgerMenu = findViewById(R.id.btnHamburgerMenu);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, DashBoard.class);
                startActivity(intent);
            }
        });
        btnUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, UserProfile.class);
                startActivity(intent);
            }
        });
        btnHamburgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
            }
        });

    }
}