package com.androiddeveloper.webprog26.firebasejobdispatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddeveloper.webprog26.firebasejobdispatcher.app.JobApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_start_upload)
    Button mBtnStartUpload;

    //initializing Sheduler instance
    private Sheduler mSheduler = new Sheduler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnStartUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSheduler().sheduleJob(UploaderJob.createUploadJob(JobApp.getJobDispatcher()));
            }
        });
    }

    private Sheduler getSheduler() {
        return mSheduler;
    }
}
