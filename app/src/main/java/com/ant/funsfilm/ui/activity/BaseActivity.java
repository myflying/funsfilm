package com.ant.funsfilm.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ant.funsfilm.presenter.Presenter;

import butterknife.ButterKnife;

/**
 * Created by admin on 2017/4/8.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;
    protected Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        context = this;
        ButterKnife.bind(this);
        initVars();
        initViews();
        initData(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (presenter == null && getPresenter() != null) {
            presenter = getPresenter();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(presenter != null){
            presenter.destroy();
        }
    }

    public Context getContext() {
        return context;
    }

    protected abstract int getLayoutId();

    protected abstract Presenter getPresenter();

    protected abstract void initVars();

    protected abstract void initViews();

    protected abstract void initData(Bundle savedInstanceState);
}
