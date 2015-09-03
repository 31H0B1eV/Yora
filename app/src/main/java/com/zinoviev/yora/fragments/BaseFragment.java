package com.zinoviev.yora.fragments;

import android.app.Fragment;
import android.os.Bundle;

import com.zinoviev.yora.infrastructure.YoraApplication;

public abstract class BaseFragment extends Fragment {

    protected YoraApplication mApplication;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication = (YoraApplication) getActivity().getApplication();
    }
}
