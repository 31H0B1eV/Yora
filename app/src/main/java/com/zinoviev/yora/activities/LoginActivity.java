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
    private static final int REQUEST_EXTERNAL_LOGIN = 3;

    private Button mLoginBtn;
    private Button mRegisterBtn;
    private Button mFacebookLoginBtn;
    private Button mGoogleLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mLoginBtn = (Button) findViewById(R.id.activity_login_login);
        mRegisterBtn = (Button) findViewById(R.id.activity_login_register);
        mFacebookLoginBtn = (Button) findViewById(R.id.activity_login_facebook);
        mGoogleLoginBtn = (Button) findViewById(R.id.activity_login_google);

        if (mLoginBtn != null) {
            mLoginBtn.setOnClickListener(this);
        }

        mRegisterBtn.setOnClickListener(this);
        mFacebookLoginBtn.setOnClickListener(this);
        mGoogleLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        } else if (v == mRegisterBtn) {
            startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_REGISTER);
        } else if (v == mFacebookLoginBtn) {
            doExternalLogin("Facebook");
        } else if (v == mGoogleLoginBtn) {
            doExternalLogin("Google");
        }
    }

    private void doExternalLogin(String externalService) {
        Intent mIntent = new Intent(this, ExternalLoginActivity.class);
        mIntent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, externalService);
        startActivityForResult(mIntent, REQUEST_EXTERNAL_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        if (requestCode == REQUEST_NARROW_LOGIN ||
            requestCode == REQUEST_REGISTER ||
            requestCode == REQUEST_EXTERNAL_LOGIN)
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
