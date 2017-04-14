package com.publish.shahar91.testingstuff.quake;

/**
 * Created by Christiano on 11/04/2017.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long timeMilliseconds;
    private String urlQuake;

    public Earthquake(double magnitude, String location, long timeMilliseconds, String urlQuake) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeMilliseconds = timeMilliseconds;
        this.urlQuake = urlQuake;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeMilliseconds() {
        return timeMilliseconds;
    }

    public String geturlQuake() {
        return urlQuake;
    }
}
