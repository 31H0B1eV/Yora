package com.zinoviev.yora.activities;

import android.content.Intent;
import android.os.Bundle;

public abstract class BaseAuthenticatedActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!mApplication.getAuth().getUser().isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        onYoraCreate(savedInstanceState);
    }

    /**
     * Method called only if User.mIsLoggedIn == false
     * @param savedInstanceState is application instanceState
     */
    protected abstract void onYoraCreate(Bundle savedInstanceState);
}
