package com.example.a5_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class delete_users extends AppCompatActivity {

    private CardView buttonBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_users);

        // Initialize the back home button
        buttonBackHome = findViewById(R.id.button_back_home_delete_users);

        // Set OnClickListener for the back home button
        buttonBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the home_page Activity
                Intent intent = new Intent(delete_users.this, home_page.class);
                startActivity(intent);
            }
        });
    }
}
