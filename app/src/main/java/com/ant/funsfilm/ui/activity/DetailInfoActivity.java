package com.ant.funsfilm.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ant.funsfilm.R;
import com.ant.funsfilm.presenter.Presenter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/20.
 */

public class DetailInfoActivity extends BaseActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail_info;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    protected void initVars() {
        StatusBarUtil.setColor(DetailInfoActivity.this, getResources().getColor(R.color.colorAccent), 0);
        //collapsingToolbar.setTitle("用户信息");

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
