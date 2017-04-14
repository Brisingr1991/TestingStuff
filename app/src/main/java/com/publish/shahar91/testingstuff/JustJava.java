package com.publish.shahar91.testingstuff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class JustJava extends AppCompatActivity {
    int quantity = 2;
    CheckBox hasWhippedCream, hasChocolate;
    EditText nameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_java);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hasWhippedCream = (CheckBox) findViewById(R.id.creamCbox);
        hasChocolate = (CheckBox) findViewById(R.id.chocolatCbox);
        nameEt = (EditText) findViewById(R.id.nameEt);
    }


    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_subject, nameEt.getText()));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary() {
        boolean addWhippedCream = hasWhippedCream.isChecked();
        boolean addChocolate = hasChocolate.isChecked();

        String message = getString(R.string.order_summary_name, nameEt.getText()) +
                "\n" + getString(R.string.order_cream, hasWhippedCream.isChecked()) +
                "\n" + getString(R.string.order_chocolate, hasChocolate.isChecked()) +
                "\n" + getString(R.string.order_quantity, quantity) +
                "\n" + getString(R.string.order_total, NumberFormat.
                getCurrencyInstance().format(calcPrice(addWhippedCream, addChocolate))) +
                "\n" + getString(R.string.order_thank_you);
        return message;
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants chocolate topping
     * @return total price
     */
    private int calcPrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityTv);
        quantityTextView.setText("" + number);
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You can't have more then 100 cups!", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
        } else {
            Toast.makeText(this, "You can't have less then 1 cup!", Toast.LENGTH_SHORT).show();

        }
        display(quantity);
    }

}