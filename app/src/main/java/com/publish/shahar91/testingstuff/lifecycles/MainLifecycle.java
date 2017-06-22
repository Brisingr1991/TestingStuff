package com.publish.shahar91.testingstuff.lifecycles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

import java.util.ArrayList;

public class MainLifecycle extends AppCompatActivity {
    private static final String TAG = MainLifecycle.class.getSimpleName();

    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "key";

    /* Constant values for the names of each respective lifecycle callback */
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    private static ArrayList<String> mLifecycleCallbacks = new ArrayList<>();

    private TextView mLifecycleDisplay;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, mLifecycleDisplay.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lifecycle);

        mLifecycleDisplay = (TextView) findViewById(R.id.tv_lifecycle_events_display);

        for (int i = mLifecycleCallbacks.size() - 1; i >= 0; i--) {
            mLifecycleDisplay.append(mLifecycleCallbacks.get(i) + "\n");
        }

        mLifecycleCallbacks.clear();

        logAndAppend(ON_CREATE);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                logAndAppend(savedInstanceState.getString(LIFECYCLE_CALLBACKS_TEXT_KEY));
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLifecycleCallbacks.add(0, ON_STOP);
        logAndAppend(ON_STOP);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleCallbacks.add(0, ON_DESTROY);
        logAndAppend(ON_DESTROY);

    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);

    }

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);

        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }
}
