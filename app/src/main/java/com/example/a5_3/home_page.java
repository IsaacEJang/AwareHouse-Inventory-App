package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize CardViews
        CardView cardNotifications = findViewById(R.id.card_notifications_home_page);
        CardView cardInventory = findViewById(R.id.card_inventory_home_page);
        CardView cardCreateAccount = findViewById(R.id.card_manage_users_home_page);
        CardView cardLogout = findViewById(R.id.card_logout_home_page);

        // Set the OnClickListener for Notifications CardView
        cardNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, notifications.class);
                startActivity(intent);
            }
        });

        // Set the OnClickListener for Inventory CardView
        cardInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, inventory_dashboard.class);
                startActivity(intent);
            }
        });

        // Set the OnClickListener for Manage Users CardView
        cardCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, manage_users.class);
                startActivity(intent);
            }
        });

        // Set the OnClickListener for Logout CardView
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here you should handle the logout operation
                // For example, you might clear the user session or navigate to a login screen
                Intent intent = new Intent(home_page.this, login_screen.class);
                startActivity(intent);
                finish(); // Optionally finish the current activity
            }
        });
    }
}