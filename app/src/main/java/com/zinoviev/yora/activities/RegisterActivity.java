package com.zinoviev.yora.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.zinoviev.yora.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText mUserName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mRegisterBtn;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        mUserName = (EditText) findViewById(R.id.activity_register_userName);
        mEmail = (EditText) findViewById(R.id.activity_register_email);
        mPassword = (EditText) findViewById(R.id.activity_register_password);
        mRegisterBtn = (Button) findViewById(R.id.activity_register_registerBtn);
        mProgressBar = (ProgressBar) findViewById(R.id.activity_register_progressBar);

        mRegisterBtn.setOnClickListener(this);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterBtn) {
            mApplication.getAuth().getUser().setIsLoggedIn(true);

            setResult(RESULT_OK);
            finish();
        }
    }
}
