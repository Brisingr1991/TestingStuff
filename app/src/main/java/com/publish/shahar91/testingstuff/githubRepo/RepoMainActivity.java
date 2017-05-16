package com.publish.shahar91.testingstuff.githubRepo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.publish.shahar91.testingstuff.R;
import com.publish.shahar91.testingstuff.githubRepo.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class RepoMainActivity extends AppCompatActivity {
    EditText mSearchBoxEditText;
    TextView mUrlDisplayTextView, mSearhResultsTextview, mErrorMessageTextView;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_main_activity);

        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mSearhResultsTextview = (TextView) findViewById(R.id.tv_github_search_results_json);
        mErrorMessageTextView = (TextView) findViewById(R.id.tv_error_message_display);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_loading_indicator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.repo_main, menu);
        return true;
    }

    private void makeGithubSearchQuery() {
        URL githubSearchUrl = NetworkUtils.buildUrl(mSearchBoxEditText.getText().toString());
        mUrlDisplayTextView.setText(githubSearchUrl.toString());

        new GithubQueryTask().execute(githubSearchUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                makeGithubSearchQuery();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showJsonDataView() {
        mSearhResultsTextview.setVisibility(View.VISIBLE);
        mErrorMessageTextView.setVisibility(View.INVISIBLE);
        //show the data and hide the error
    }

    public void showErrorMessage() {
        mSearhResultsTextview.setVisibility(View.INVISIBLE);
        mErrorMessageTextView.setVisibility(View.VISIBLE);
        //show the error and hide the data
    }

    public class GithubQueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];

            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String githubSearchResults) {
            mProgressBar.setVisibility(View.INVISIBLE);
            if (githubSearchResults != null && !githubSearchResults.equals("")) {
                showJsonDataView();
                mSearhResultsTextview.setText(githubSearchResults);
            } else {
                showErrorMessage();
            }
        }
    }
}
