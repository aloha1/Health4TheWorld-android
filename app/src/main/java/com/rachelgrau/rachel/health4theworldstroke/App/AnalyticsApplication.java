package com.rachelgrau.rachel.health4theworldstroke.App;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.rachelgrau.rachel.health4theworldstroke.R;

/**
 * Created by Amit on 1/21/2018.
 */
public class AnalyticsApplication extends Application{
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;
    @Override
    public void onCreate() {
        super.onCreate();

        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracking);
        }

        return sTracker;
    }
}
