package com.androiddeveloper.webprog26.firebasejobdispatcher.callbacks;

/**
 * Will be called from separate Thread
 which does all the hard work */

public interface OnUploadFinishedCallback {

    /**
     * Called from separate {@link Thread} when hard work has been finished
     * @param s {@link String} could be any Java Object
     */
    public void onUploadFinished(String s);
}
