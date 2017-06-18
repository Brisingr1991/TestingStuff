package com.publish.shahar91.testingstuff.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;
import com.publish.shahar91.testingstuff.sunshine.data.SunshinePreferences;
import com.publish.shahar91.testingstuff.sunshine.utilities.ForecastAdapter;
import com.publish.shahar91.testingstuff.sunshine.utilities.NetworkUtils;
import com.publish.shahar91.testingstuff.sunshine.utilities.OpenWeatherJsonUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;

public class SunMainActivity extends AppCompatActivity {

    private TextView sun_errorTv;
    private ProgressBar sun_progressBar;
    private RecyclerView mRecyclerView;
    private ForecastAdapter mForecastAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sun_forecast_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_forecast);
        sun_errorTv = (TextView) findViewById(R.id.sun_errorTv);
        sun_progressBar = (ProgressBar) findViewById(R.id.sun_progressBar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mForecastAdapter = new ForecastAdapter();

        mRecyclerView.setAdapter(mForecastAdapter);

        LoadWeatherData();
    }

    private void showWeatherDataView() {
        sun_errorTv.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        sun_errorTv.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);

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
                mForecastAdapter.setWeatherData(null);
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
                mForecastAdapter.setWeatherData(weatherData);

            } else {
                showErrorMessage();
            }
        }
    }
}
