package com.publish.shahar91.testingstuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.publish.shahar91.testingstuff.miwok.Miwok;
import com.publish.shahar91.testingstuff.miwokTabs.miwok.MiwokTabs;

public class MainActivity extends AppCompatActivity {
    Intent openAct;
    ListView listVw;
    String[] activities = {"Just Java (Android Tutorial - Udacity)",
            "Court Counter (Android Tutorial - Udacity)", "Miwok (Android Tutorial - Udacity)",
            "MusicPlayer (Testing MediaPlayer object)", "miwokTabs"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listVw = (ListView) findViewById(R.id.listLv);

        listVw.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, activities));

        listVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long l) {
                openActivity(id);
            }
        });

    }

    public void openActivity(int id) {
        switch (id) {
            case 0:
                openAct = new Intent(MainActivity.this, JustJava.class);
//                openAct.putExtra(SOMEZING, some_value);
                startActivity(openAct);
                break;
            case 1:
                openAct = new Intent(MainActivity.this, CourtCounter.class);
//                openAct.putExtra(SOMEZING, some_value);
                startActivity(openAct);
                break;
            case 2:
                openAct = new Intent(MainActivity.this, Miwok.class);
                startActivity(openAct);
                break;
            case 3:
                openAct = new Intent(MainActivity.this, MusicPlayer.class);
                startActivity(openAct);
                break;
            case 4:
                openAct = new Intent(MainActivity.this, MiwokTabs.class);
                startActivity(openAct);
                break;

        }
    }
}
