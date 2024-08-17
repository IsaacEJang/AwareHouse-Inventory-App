package com.example.a5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class add_item extends AppCompatActivity {

    private EditText itemNameInput, quantityInput;
    private InventoryDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        dbHelper = new InventoryDbHelper(this);
        itemNameInput = findViewById(R.id.input_item_name);
        quantityInput = findViewById(R.id.input_quantity);
        Button addButton = findViewById(R.id.button_add_item);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        ImageButton returnButton = findViewById(R.id.button_return_add_items);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_item.this, inventory_dashboard.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void addItem() {
        String itemName = itemNameInput.getText().toString().trim();
        // Ensure that the quantity input is not empty to avoid NumberFormatException
        if (itemName.isEmpty() || quantityInput.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter Item Name, Location, and Quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantity = Integer.parseInt(quantityInput.getText().toString().trim());
        String location = getLocationFromCheckbox(); // Implement this based on your checkbox logic

        dbHelper.addItem(itemName, location, quantity);

        // Show a toast message
        Toast.makeText(this, "Items have been added", Toast.LENGTH_SHORT).show();

        // Navigate back to the Inventory Dashboard
        Intent intent = new Intent(this, inventory_dashboard.class);
        startActivity(intent);
        finish(); // Optional: if you want to remove this activity from the back stack
    }



    private String getLocationFromCheckbox() {
        // Implement logic to determine location based on checked checkboxes
        return "Location"; // Placeholder
    }
}
