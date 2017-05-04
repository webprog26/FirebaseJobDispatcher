package com.androiddeveloper.webprog26.firebasejobdispatcher.threads;

import com.androiddeveloper.webprog26.firebasejobdispatcher.callbacks.OnUploadFinishedCallback;

import java.util.concurrent.TimeUnit;

/**
 * This {@link Thread} does all the hard work
 */

public class UploadThread extends Thread {

    //Callback instance
    private final OnUploadFinishedCallback onUploadFinishedCallback;

    public UploadThread(OnUploadFinishedCallback onUploadFinishedCallback) {
        this.onUploadFinishedCallback = onUploadFinishedCallback;
    }

    @Override
    public void run() {
        super.run();
        try {
            //some hard work is going on here
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
        getUploadFinishedCallback().onUploadFinished("Runs in thread " + Thread.currentThread().getName());
    }

    public OnUploadFinishedCallback getUploadFinishedCallback() {
        return onUploadFinishedCallback;
    }
}
