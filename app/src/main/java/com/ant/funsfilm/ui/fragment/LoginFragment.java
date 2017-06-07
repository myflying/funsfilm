package com.ant.funsfilm.ui.fragment;

import com.ant.funsfilm.R;

import butterknife.OnClick;

/**
 * Created by admin on 2017/4/20.
 */

public class LoginFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_login;
    }

    @Override
    public void initVars() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void initFragmentConfig() {

    }

    @OnClick(R.id.to_register_tv)
    public void register() {
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, new RegisterFragment())
                .commit();
    }
}
