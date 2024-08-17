package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class successful_create_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_create_account);

        // Initialize the continue button using its ID
        Button continueButton = findViewById(R.id.button_continue_create_account_successful);

        // Set an OnClickListener for the continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start Home_Page activity
                Intent intent = new Intent(successful_create_account.this, home_page.class);
                startActivity(intent); // Start the Home_Page activity
            }
        });
    }
}
