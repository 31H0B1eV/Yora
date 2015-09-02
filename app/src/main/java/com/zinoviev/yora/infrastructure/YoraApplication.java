package com.zinoviev.yora.infrastructure;

import android.app.Application;

public class YoraApplication extends Application {

    private Auth mAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        mAuth = new Auth(this);
    }

    public Auth getAuth() {
        return mAuth;
    }
}
