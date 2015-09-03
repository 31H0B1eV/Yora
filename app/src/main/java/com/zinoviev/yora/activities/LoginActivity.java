package com.zinoviev.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zinoviev.yora.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mLoginBtn = (Button) findViewById(R.id.activity_login_login);
        if (mLoginBtn != null) {
            mLoginBtn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            startActivity(new Intent(this, LoginNarrowActivity.class));
        }
    }
}
