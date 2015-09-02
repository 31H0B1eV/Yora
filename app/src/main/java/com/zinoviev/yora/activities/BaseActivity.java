package com.zinoviev.yora.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zinoviev.yora.infrastructure.YoraApplication;

public abstract class BaseActivity extends AppCompatActivity {

    protected YoraApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication = (YoraApplication) getApplication();
    }
}
