package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class manage_users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_users);

        // Initialize the Add User button
        CardView addButton = findViewById(R.id.button_add_user_manger_users);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the unrestricted_create_account Activity
                Intent intent = new Intent(manage_users.this, unrestricted_create_account.class);
                startActivity(intent);
            }
        });

        // Initialize the Back Home button
        CardView homeButton = findViewById(R.id.button_back_home_manage_users);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the home_page Activity
                Intent intent = new Intent(manage_users.this, home_page.class);
                startActivity(intent);
            }
        });

        // Initialize the Delete User button
        CardView deleteButton = findViewById(R.id.button_delete_user_manger_users);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the delete_users Activity
                Intent intent = new Intent(manage_users.this, delete_users.class);
                startActivity(intent);
            }
        });
    }
}
