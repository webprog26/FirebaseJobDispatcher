package com.androiddeveloper.webprog26.firebasejobdispatcher.service;

import android.util.Log;

import com.androiddeveloper.webprog26.firebasejobdispatcher.UploaderJob;
import com.androiddeveloper.webprog26.firebasejobdispatcher.callbacks.OnUploadFinishedCallback;
import com.androiddeveloper.webprog26.firebasejobdispatcher.threads.UploadThread;
import com.firebase.jobdispatcher.JobParameters;

/**
 * Created by webpr on 04.05.2017.
 */

public class AppJobService extends com.firebase.jobdispatcher.JobService {

    private static final String TAG = "JobService_TAG";

    @Override
    public boolean onStartJob(final JobParameters job) {
        Log.i(TAG, "onStartJob()");
        //check the job TAG to run the job, that we currently need
        switch (job.getTag()){
            case UploaderJob.UPLOAD_JOB_TAG:
                Log.i(TAG, "Received njob with the tag: " + job.getTag());
                //starting new UploadThread than does all the hard work
                new UploadThread(new OnUploadFinishedCallback() {
                    @Override
                    public void onUploadFinished(String s) {
                        Log.i(TAG, "onUploadFinished(): " + s);
                        //let the framework know that job is finished and should not be repeated
                        jobFinished(job, false);
                    }
                }).start();
                //let the framework know that we have uncompleted job
                return true;
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}
