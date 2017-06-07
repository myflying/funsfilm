package com.ant.funsfilm.ui.fragment;

import android.content.Intent;

import com.ant.funsfilm.R;
import com.ant.funsfilm.ui.activity.LoginActivity;

import butterknife.OnClick;

/**
 * Created by admin on 2017/4/19.
 */

public class MyInfoFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_my_info;
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

    @OnClick(R.id.login_layout)
    public void login() {
        Intent intent = new Intent(getBaseActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.collect_layout)
    public void collectInfo() {

    }
}
