package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login_screen extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private user_database dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        dbHelper = new user_database(this);
        inputEmail = findViewById(R.id.input_email_login_screen);
        inputPassword = findViewById(R.id.input_password_login_screen);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check if email and password are correct
                if (dbHelper.checkUser(email, password)) {
                    // Credentials are correct, navigate to the Home_Page activity
                    Intent intent = new Intent(login_screen.this, home_page.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Credentials are incorrect, display an error message
                    Toast.makeText(login_screen.this, "Invalid email or password.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Initialize the sign-up button using its ID
        Button signUpButton = findViewById(R.id.restricted_sign_up_button);

        // Set an OnClickListener for the sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start restricted_create_account activity
                Intent intent = new Intent(login_screen.this, restricted_create_account.class);
                startActivity(intent); // Start the restricted_create_account activity
            }
        });
    }
}
