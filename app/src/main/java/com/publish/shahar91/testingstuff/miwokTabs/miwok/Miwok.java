package com.publish.shahar91.testingstuff.miwokTabs.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

/**
 * Created by Christiano on 8/04/2017.
 */

public class Miwok extends AppCompatActivity {
    TextView numbers, family, phrases, colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miwok);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAct = new Intent(Miwok.this, NumbersFragment.class);
                startActivity(openAct);
            }
        });

        family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAct = new Intent(Miwok.this, FamilyFragment.class);
                startActivity(openAct);
            }
        });

        phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAct = new Intent(Miwok.this, PhrasesFragment.class);
                startActivity(openAct);
            }
        });

        colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAct = new Intent(Miwok.this, ColorsFragment.class);
                startActivity(openAct);
            }
        });
    }


    public void openNumbersList(View view) {
        Intent openAct = new Intent(Miwok.this, NumbersFragment.class);
        startActivity(openAct);
    }
}
