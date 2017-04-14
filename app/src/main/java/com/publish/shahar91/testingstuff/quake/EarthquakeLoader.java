package com.publish.shahar91.testingstuff.quake;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Christiano on 14/04/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    String urlCall;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        urlCall = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {


//        if (urlCall.isEmpty()) {
//            return null;
//        }
        return QueryUtils.fetchEarthquakeData(urlCall);
    }

}
