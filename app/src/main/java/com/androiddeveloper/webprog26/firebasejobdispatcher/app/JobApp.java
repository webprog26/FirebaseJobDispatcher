package com.androiddeveloper.webprog26.firebasejobdispatcher.app;

import android.app.Application;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;

/**
 * Application class to receive single static reference to FirebaseJobDispatcher
 */

public class JobApp extends Application {

    private static FirebaseJobDispatcher mJobDispatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        mJobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
    }

    public static FirebaseJobDispatcher getJobDispatcher(){
        return mJobDispatcher;
    }
}
