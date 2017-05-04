package com.androiddeveloper.webprog26.firebasejobdispatcher;

import com.androiddeveloper.webprog26.firebasejobdispatcher.service.AppJobService;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

/**
 * Simple class to create {@link Job}
 */

public class UploaderJob {

    //Tag to recognize this Job in AppJobService
    public static final String UPLOAD_JOB_TAG = "upload_job";

    //Job executing interval
    private static final int ONE_MINUTE = 60;

    /**
     *
     * @param jobDispatcher {@link FirebaseJobDispatcher}
     * @return {@link Job}
     */
    public static Job createUploadJob(FirebaseJobDispatcher jobDispatcher){
        return jobDispatcher.newJobBuilder()
                .setLifetime(Lifetime.FOREVER)
                .setService(AppJobService.class)
                .setRecurring(false)
                .setTag(UPLOAD_JOB_TAG)
                .setTrigger(Trigger.executionWindow(ONE_MINUTE / 2, ONE_MINUTE))
                .setConstraints(Constraint.ON_UNMETERED_NETWORK)
                .build();
    }
}
