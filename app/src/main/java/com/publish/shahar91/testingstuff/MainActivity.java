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
import android.widget.Toast;

import com.publish.shahar91.testingstuff.didyoufeelit.DidYouFeelIt;
import com.publish.shahar91.testingstuff.githubRepo.RepoMainActivity;
import com.publish.shahar91.testingstuff.intents.MainIntentActivity;
import com.publish.shahar91.testingstuff.lifecycles.MainLifecycle;
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
            "NewActivityMain (Android Tutorial - Udacity)",
            "Intents (Explicit, Implicit) (Android Tutorial - Udacity)",
            "Lifecycles (Android Tutorial - Udacity)"};

    Class[] mClassess = {JustJava.class, CourtCounter.class, Miwok.class,
            MusicPlayer.class, MiwokTabs.class, EarthquakeActivity.class,
            Soonami.class, DidYouFeelIt.class, CatalogActivity.class,
            SunMainActivity.class, ToyMainActivity.class,
            RepoMainActivity.class, RecyclerMainActivity.class,
            NewActivityMain.class, MainIntentActivity.class, MainLifecycle.class};


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
                openAct = new Intent(MainActivity.this, mClassess[id]);
                startActivity(openAct);
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
}
