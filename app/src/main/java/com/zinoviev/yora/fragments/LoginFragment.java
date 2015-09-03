package com.zinoviev.yora.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zinoviev.yora.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private Button mLoginBtn;
    private YoraCallbacks mCallbacks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginBtn = (Button) mView.findViewById(R.id.fragment_login_login_btn);
        mLoginBtn.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            mApplication.getAuth().getUser().setIsLoggedIn(true);
            mCallbacks.onLoggedIn();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (YoraCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mCallbacks = null;
    }

    public interface YoraCallbacks {
        void onLoggedIn();
    }
}
