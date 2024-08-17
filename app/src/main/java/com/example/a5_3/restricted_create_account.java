package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class restricted_create_account extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private user_database dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restricted_create_account);

        dbHelper = new user_database(this);
        firstNameInput = findViewById(R.id.first_name_input);
        lastNameInput = findViewById(R.id.last_name_input);
        emailInput = findViewById(R.id.input_email_login_screen);
        passwordInput = findViewById(R.id.password_input);
        confirmPasswordInput = findViewById(R.id.confirm_password_input);

        Button signUpButton = findViewById(R.id.button_sign_up_restricted_create_account);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameInput.getText().toString();
                String lastName = lastNameInput.getText().toString();
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                String confirmPassword = confirmPasswordInput.getText().toString();

                if (validateInput(firstName, lastName, email, password, confirmPassword)) {
                    boolean isInserted = dbHelper.insertUser(email, password, firstName, lastName);
                    if (isInserted) {
                        Toast.makeText(restricted_create_account.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(restricted_create_account.this, successful_create_account.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(restricted_create_account.this, "Failed to create account. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ImageButton returnButton = findViewById(R.id.button_return_restricted_create_account);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(restricted_create_account.this, login_screen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean validateInput(String firstName, String lastName, String email, String password, String confirmPassword) {
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
