package com.publish.shahar91.testingstuff.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;
import com.publish.shahar91.testingstuff.sunshine.data.SunshinePreferences;
import com.publish.shahar91.testingstuff.sunshine.utilities.NetworkUtils;
import com.publish.shahar91.testingstuff.sunshine.utilities.OpenWeatherJsonUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;

public class SunMainActivity extends AppCompatActivity {

    TextView weatherTv;
    TextView sun_errorTv;
    ProgressBar sun_progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sun_forecast_activity);

        weatherTv = (TextView) findViewById(R.id.weather_data);
        sun_errorTv = (TextView) findViewById(R.id.sun_errorTv);
        sun_progressBar = (ProgressBar) findViewById(R.id.sun_progressBar);

        LoadWeatherData();
    }

    private void showWeatherDataView() {
        sun_errorTv.setVisibility(View.INVISIBLE);
        weatherTv.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        sun_errorTv.setVisibility(View.VISIBLE);
        weatherTv.setVisibility(View.INVISIBLE);

    }

    private void LoadWeatherData() {
        showWeatherDataView();
        String location = SunshinePreferences.getPreferredWeatherLocation(this);
        new SunQueryTask().execute(location);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                weatherTv.setText("");
                LoadWeatherData();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forecast, menu);
        return true;
    }

    public class SunQueryTask extends AsyncTask<String, Void, String[]> {

        @Override
        protected void onPreExecute() {
            sun_progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String[] doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            String location = params[0];
            URL weatherRequestUrl = NetworkUtils.buildUrl(location);

            try {
                String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

                String[] simpleJsonWeatherData = OpenWeatherJsonUtils
                        .getSimpleWeatherStringsFromJson(SunMainActivity.this, jsonWeatherResponse);
                return simpleJsonWeatherData;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] weatherData) {
            sun_progressBar.setVisibility(View.INVISIBLE);
            if (weatherData != null) {

                /*
                 * Iterate through the array and append the Strings to the TextView. The reason why we add
                 * the "\n\n\n" after the String is to give visual separation between each String in the
                 * TextView. Later, we'll learn about a better way to display lists of data.
                 */
                for (String weatherString : weatherData) {
                    weatherTv.append((weatherString) + "\n\n\n");
                }
            } else {
                showErrorMessage();
            }
        }
    }
}
