package com.ant.funsfilm.ui.fragment;

import android.content.Intent;

import com.ant.funsfilm.R;
import com.ant.funsfilm.ui.activity.CategoryDetailActivity;
import com.ant.funsfilm.ui.activity.TvListActivity;

import butterknife.OnClick;

/**
 * Created by admin on 2017/4/18.
 */

public class CategoryFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_category;
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

    @OnClick(R.id.movie_btn)
    public void movie(){
        Intent intent = new Intent(getBaseActivity(), CategoryDetailActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_btn)
    public void tv(){
        Intent intent = new Intent(getBaseActivity(), TvListActivity.class);
        startActivity(intent);
    }
}
