package com.androiddeveloper.webprog26.firebasejobdispatcher;

import android.content.Context;

import com.androiddeveloper.webprog26.firebasejobdispatcher.app.JobApp;
import com.firebase.jobdispatcher.Job;

/**
 * This class will shedule our jobs with {@link com.firebase.jobdispatcher.FirebaseJobDispatcher}
 */

public class Sheduler {

    /**
     * Shedules {@link Job} with {@link com.firebase.jobdispatcher.FirebaseJobDispatcher}
     * @param job {@link Job}
     */
    public void sheduleJob(Job job){
        JobApp.getJobDispatcher().schedule(job);
    }
}
