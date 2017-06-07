package com.ant.funsfilm.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.ant.funsfilm.R;
import com.ant.funsfilm.presenter.Presenter;
import com.ant.funsfilm.ui.fragment.LoginFragment;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/19.
 */

public class LoginActivity extends BaseActivity {

    public interface BackListener {
        void backView();
    }

    private BackListener backListener;

    private boolean isInterception = false;

    @BindView(R.id.toolbarContainer)
    Toolbar toolbar;

    public BackListener getBackListener() {
        return backListener;
    }

    public void setBackListener(BackListener backListener) {
        this.backListener = backListener;
    }

    public boolean isInterception() {
        return isInterception;
    }

    public void setInterception(boolean isInterception) {
        this.isInterception = isInterception;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    protected void initVars() {
        StatusBarUtil.setColor(LoginActivity.this, getResources().getColor(R.color.colorAccent), 0);
        toolbar.setTitle("用户登录");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_icon);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInterception()) {
                    if (backListener != null) {
                        backListener.backView();
                    }
                }else{
                    finish();
                }
            }
        });
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isInterception()) {
                if (backListener != null) {
                    backListener.backView();
                    return false;
                }
            }else{
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
