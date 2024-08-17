package com.example.a5_3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class inventory_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_dashboard);

        setupHomeButton();
        setupAddDataButton();
        setupRemoveDataButton();
        updateInventoryDisplay();
    }

    private void updateInventoryDisplay() {
        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        Cursor cursor = dbHelper.getAllItems();

        if (cursor.moveToFirst()) {
            do {
                String itemName = cursor.getString(cursor.getColumnIndex("item_name"));
                String location = cursor.getString(cursor.getColumnIndex("location"));
                int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));

                // Update UI based on itemName, location, and quantity
                // For example, if location is "Rows 1 - 9", update the corresponding TextView
                // This is a simplified example. You'll need to tailor it to your specific UI requirements.
                if ("Rows 1 - 9".equals(location)) {
                    TextView metricTextView = findViewById(R.id.metric_1_rows_1_9);
                    metricTextView.setText(String.valueOf(quantity));
                }
                // Repeat for other locations and metrics
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    private void setupHomeButton() {
        ImageButton homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to home page
                Intent intent = new Intent(inventory_dashboard.this, home_page.class);
                startActivity(intent);
            }
        });
    }

    private void setupAddDataButton() {
        Button addButton = findViewById(R.id.button_add_items);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to feature unavailable page
                Intent intent = new Intent(inventory_dashboard.this, add_item.class);
                startActivity(intent);
            }
        });
    }

    private void setupRemoveDataButton() {
        Button removeButton = findViewById(R.id.button_remove_items);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to feature unavailable page
                Intent intent = new Intent(inventory_dashboard.this, remove_item.class);
                startActivity(intent);
            }
        });
    }
}
