package com.example.a5_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class notifications extends AppCompatActivity {

    private CheckBox smsCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        setupHomeButton();
        setupSendButton();
        smsCheckbox = findViewById(R.id.checkbox_sms_messages);
    }

    private void setupHomeButton() {
        ImageButton homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notifications.this, home_page.class);
                startActivity(intent);
            }
        });
    }

    private void setupSendButton() {
        Button sendButton = findViewById(R.id.send_Button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (smsCheckbox.isChecked()) {
                    sendSmsNotifications();
                } else {
                    Toast.makeText(notifications.this, "Please check SMS box", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(notifications.this, home_page.class);
                startActivity(intent);
            }
        });
    }

    private void sendSmsNotifications() {
        // Placeholder for sending SMS notifications
        Toast.makeText(this, "You will now get SMS updates", Toast.LENGTH_SHORT).show();
        // Implement actual SMS sending logic here

    }
}
