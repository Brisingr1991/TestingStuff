package com.publish.shahar91.testingstuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.publish.shahar91.testingstuff.didyoufeelit.DidYouFeelIt;
import com.publish.shahar91.testingstuff.githubRepo.RepoMainActivity;
import com.publish.shahar91.testingstuff.miwok.Miwok;
import com.publish.shahar91.testingstuff.miwokTabs.miwok.MiwokTabs;
import com.publish.shahar91.testingstuff.newActivity.NewActivityMain;
import com.publish.shahar91.testingstuff.petsApp.CatalogActivity;
import com.publish.shahar91.testingstuff.quake.EarthquakeActivity;
import com.publish.shahar91.testingstuff.recyclerView.RecyclerMainActivity;
import com.publish.shahar91.testingstuff.soonami.Soonami;
import com.publish.shahar91.testingstuff.sunshine.SunMainActivity;
import com.publish.shahar91.testingstuff.toys.ToyMainActivity;

public class MainActivity extends AppCompatActivity {
    Intent openAct;
    ListView listVw;
    String[] activities = {"Just Java (Android Tutorial - Udacity)",
            "Court Counter (Android Tutorial - Udacity)", "Miwok (Android Tutorial - Udacity)",
            "MusicPlayer (Testing MediaPlayer object)", "miwokTabs",
            "Quake Report (Android Tutorial - Udacity)",
            "Soonami - Test app", "Did you feel it - Test app",
            "Pets (Android Tutorial - Udacity)",
            "Sunshine (Android Tutorial - Udacity)",
            "ToyBox (Android Tutorial - Udacity)",
            "Github Repo Search (Android Tutorial - Udacity)",
            "RecyclerViews (Android Tutorial - Udacity)",
            "NewActivityMain (Android Tutorial - Udacity)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_splash);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.account) {
            Intent accountIntent = new Intent(this, Account.class);
            startActivity(accountIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
            case 5:
                openAct = new Intent(MainActivity.this, EarthquakeActivity.class);
                startActivity(openAct);
                break;
            case 6:
                openAct = new Intent(MainActivity.this, Soonami.class);
                startActivity(openAct);
                break;
            case 7:
                openAct = new Intent(MainActivity.this, DidYouFeelIt.class);
                startActivity(openAct);
                break;
            case 8:
                openAct = new Intent(MainActivity.this, CatalogActivity.class);
                startActivity(openAct);
                break;
            case 9:
                openAct = new Intent(MainActivity.this, SunMainActivity.class);
                startActivity(openAct);
                break;
            case 10:
                openAct = new Intent(MainActivity.this, ToyMainActivity.class);
                startActivity(openAct);
                break;
            case 11:
                openAct = new Intent(MainActivity.this, RepoMainActivity.class);
                startActivity(openAct);
                break;
            case 12:
                openAct = new Intent(MainActivity.this, RecyclerMainActivity.class);
                startActivity(openAct);
                break;
            case 13:
                openAct = new Intent(MainActivity.this, NewActivityMain.class);
                startActivity(openAct);
                break;

        }
    }
}
