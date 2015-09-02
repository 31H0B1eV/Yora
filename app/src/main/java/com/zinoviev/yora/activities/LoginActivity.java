package com.zinoviev.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zinoviev.yora.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {
        mApplication.getAuth().getUser().setIsLoggedIn(true);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
