package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class unrestricted_create_account extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private EditText phoneNumberInput;
    private CheckBox messagePermissionCheckbox;
    private user_database dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unrestricted_create_account);

        // Initialize database helper
        dbHelper = new user_database(this);

        // Initialize UI components
        firstNameInput = findViewById(R.id.first_name_input);
        lastNameInput = findViewById(R.id.last_name_input);
        emailInput = findViewById(R.id.input_email_login_screen);
        passwordInput = findViewById(R.id.password_input);
        confirmPasswordInput = findViewById(R.id.confirm_password_input);
        phoneNumberInput = findViewById(R.id.phone_number_input);
        messagePermissionCheckbox = findViewById(R.id.message_permission_checkbox);

        // Initialize the home button
        ImageButton homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the home_page Activity
                Intent intent = new Intent(unrestricted_create_account.this, home_page.class);
                startActivity(intent);
            }
        });

        // Initialize the sign-up button
        Button signUpButton = findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String firstName = firstNameInput.getText().toString().trim();
                String lastName = lastNameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String confirmPassword = confirmPasswordInput.getText().toString().trim();
                String phoneNumber = phoneNumberInput.getText().toString().trim();
                boolean hasMessagePermission = messagePermissionCheckbox.isChecked();

                // Validate and insert user
                if (validateInput(firstName, lastName, email, password, confirmPassword)) {
                    boolean isInserted = dbHelper.insertUser(email, password, firstName, lastName);
                    if (isInserted) {
                        Toast.makeText(unrestricted_create_account.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(unrestricted_create_account.this, successful_create_account.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(unrestricted_create_account.this, "Failed to create account. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validateInput(String firstName, String lastName, String email, String password, String confirmPassword) {
        // Basic validation checks
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
