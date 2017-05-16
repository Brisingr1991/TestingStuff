package com.publish.shahar91.testingstuff.quake;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquakes = getItem(position);

        TextView magnitude = (TextView) convertView.findViewById(R.id.magTv);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(earthquakes.getMagnitude());
        magnitude.setText(output);

        //Set the proper background color on the magnitude circle
        //Fetch the background from the TextView, which is a GradientDrawable
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        //Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquakes.getMagnitude());

        //Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = earthquakes.getLocation();

        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "near the";
            primaryLocation = originalLocation;
        }

        TextView offsetTv = (TextView) convertView.findViewById(R.id.offsetLocTv);
        offsetTv.setText(locationOffset);

        TextView primLocTv = (TextView) convertView.findViewById(R.id.primLocTv);
        primLocTv.setText(primaryLocation);

        Date dateObject = new Date(earthquakes.getTimeMilliseconds());

        TextView date = (TextView) convertView.findViewById(R.id.dateTv);
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);

        TextView time = (TextView) convertView.findViewById(R.id.timeTv);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);
        return convertView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;

        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
