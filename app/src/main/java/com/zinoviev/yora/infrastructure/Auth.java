package com.zinoviev.yora.infrastructure;

import android.content.Context;

public class Auth {

    private final Context mContext;
    private User mUser;

    public Auth(Context context) {
        mContext = context;
        mUser = new User();
    }

    public Context getContext() {
        return mContext;
    }

    public User getUser() {
        return mUser;
    }
}
