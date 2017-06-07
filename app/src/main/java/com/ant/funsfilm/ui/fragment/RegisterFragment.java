package com.ant.funsfilm.ui.fragment;

import com.ant.funsfilm.R;
import com.ant.funsfilm.ui.activity.LoginActivity;

/**
 * Created by admin on 2017/4/20.
 */

public class RegisterFragment extends BaseFragment implements LoginActivity.BackListener{

    @Override
    protected int getContentView() {
        return R.layout.fragment_register;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(getBaseActivity() instanceof LoginActivity) {
            ((LoginActivity) getBaseActivity()).setBackListener(null);
            ((LoginActivity) getBaseActivity()).setInterception(false);
        }
    }

    @Override
    public void initVars() {

    }

    @Override
    public void initViews() {
        ((LoginActivity) getBaseActivity()).setBackListener(this);
        ((LoginActivity) getBaseActivity()).setInterception(true);
    }

    @Override
    public void loadData() {

    }

    @Override
    protected void initFragmentConfig() {

    }

    @Override
    public void backView() {
        getFragmentManager().popBackStack();
    }
}
