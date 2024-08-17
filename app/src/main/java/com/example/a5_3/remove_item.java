package com.example.a5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class remove_item extends AppCompatActivity {

    private EditText itemNameInput, quantityInput;
    private CheckBox checkBoxRows1_9, checkBoxRows10_19, checkBoxRows20_29, checkBoxRows30_39;
    private InventoryDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);

        // Initialize your database helper
        dbHelper = new InventoryDbHelper(this);

        // Initialize the input fields and checkboxes
        itemNameInput = findViewById(R.id.input_item_name);
        quantityInput = findViewById(R.id.input_quantity);
        checkBoxRows1_9 = findViewById(R.id.check_box_rows_1_9_remove_item);
        checkBoxRows10_19 = findViewById(R.id.check_box_rows_10_19_remove_item);
        checkBoxRows20_29 = findViewById(R.id.check_box_rows_20_29_remove_item);
        checkBoxRows30_39 = findViewById(R.id.check_box_rows_30_39_remove_item);

        // Initialize the remove items button
        Button removeItemsButton = findViewById(R.id.button_remove_items);
        removeItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem();
            }
        });
        ImageButton returnButton = findViewById(R.id.button_return_remove_items);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(remove_item.this, inventory_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void removeItem() {
        String itemName = itemNameInput.getText().toString().trim();
        if (itemName.isEmpty() || quantityInput.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter Item Name, Location, and Quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantity = Integer.parseInt(quantityInput.getText().toString().trim());
        String location = getLocationFromCheckbox(); // Implement this based on your checkbox logic

        dbHelper.removeItem(itemName, location, quantity);

        // Show a toast message
        Toast.makeText(this, "Items have been removed", Toast.LENGTH_SHORT).show();

        // Navigate back to the Inventory Dashboard
        Intent intent = new Intent(this, inventory_dashboard.class);
        startActivity(intent);
    }

    private String getLocationFromCheckbox() {
        StringBuilder locationBuilder = new StringBuilder();
        if (checkBoxRows1_9.isChecked()) locationBuilder.append("Rows 1-9, ");
        if (checkBoxRows10_19.isChecked()) locationBuilder.append("Rows 10-19, ");
        if (checkBoxRows20_29.isChecked()) locationBuilder.append("Rows 20-29, ");
        if (checkBoxRows30_39.isChecked()) locationBuilder.append("Rows 30-39");
        return locationBuilder.toString().trim();
    }
}
