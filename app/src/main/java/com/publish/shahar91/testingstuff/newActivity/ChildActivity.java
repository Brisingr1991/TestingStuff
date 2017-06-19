package com.publish.shahar91.testingstuff.newActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

public class ChildActivity extends AppCompatActivity {
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        display = (TextView) findViewById(R.id.tv_display);

        Intent newIntent = getIntent();
        if (newIntent.hasExtra(Intent.EXTRA_TEXT)) {
            display.setText(newIntent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
