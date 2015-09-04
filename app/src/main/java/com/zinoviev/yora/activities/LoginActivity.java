package com.zinoviev.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zinoviev.yora.R;
import com.zinoviev.yora.fragments.LoginFragment;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.YoraCallbacks {

    private static final int REQUEST_NARROW_LOGIN = 1;
    private static final int REQUEST_REGISTER = 2;

    private Button mLoginBtn;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mLoginBtn = (Button) findViewById(R.id.activity_login_login);
        mRegisterBtn = (Button) findViewById(R.id.activity_login_register);

        if (mLoginBtn != null) {
            mLoginBtn.setOnClickListener(this);
        }

        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        } else if (v == mRegisterBtn) {
            startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_REGISTER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        if (requestCode == REQUEST_NARROW_LOGIN ||
            requestCode == REQUEST_REGISTER)
            finishLogin();
    }

    private void finishLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoggedIn() {
        finishLogin();
    }
}
