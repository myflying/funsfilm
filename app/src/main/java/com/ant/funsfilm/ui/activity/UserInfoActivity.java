package com.ant.funsfilm.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ant.funsfilm.R;
import com.ant.funsfilm.presenter.Presenter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/20.
 */

public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.toolbarContainer)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    protected void initVars() {

        StatusBarUtil.setColor(UserInfoActivity.this, getResources().getColor(R.color.colorAccent), 0);
        toolbar.setTitle("个人信息");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_icon);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
