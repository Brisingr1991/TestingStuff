package com.publish.shahar91.testingstuff.sunshine;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.publish.shahar91.testingstuff.R;

public class DetailActivity extends AppCompatActivity {
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private TextView weatherTv;
    private String shareText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForecastIntent());
        return true;
    }

    private Intent createShareForecastIntent() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(shareText + FORECAST_SHARE_HASHTAG)
                .getIntent();
        return shareIntent;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_share) {
//            String mimeType = "text/plain";
//            String title = "make a choice";
//            ShareCompat.IntentBuilder.from(this)
//                    .setChooserTitle(title)
//                    .setType(mimeType)
//                    .setText(shareText)
//                    .startChooser();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        weatherTv = (TextView) findViewById(R.id.weatherTv);

        Intent weather = getIntent();

        if (weather != null) {
            if (weather.hasExtra(Intent.EXTRA_TEXT)) {
                shareText = weather.getStringExtra(Intent.EXTRA_TEXT);
                weatherTv.setText(shareText);
            }
        }
    }
}
