package com.ant.funsfilm.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ant.funsfilm.R;
import com.ant.funsfilm.bean.MovieInfoEntity;
import com.ant.funsfilm.presenter.Presenter;
import com.ant.funsfilm.ui.adapter.ItemClickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/21.
 */

public class CategoryDetailActivity extends BaseActivity {
    @BindView(R.id.toolbarContainer)
    Toolbar toolbar;

    @BindView(R.id.category_detail_list)
    RecyclerView categoryDetailRecyclerView;

    private String[] movieStr = {"http://img5.mtime.cn/mg/2017/04/10/142604.31208891_270X405X4.jpg", "http://img5.mtime.cn/mt/2017/03/10/100416.61663220_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/04/08/124652.27542728_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/03/28/152940.49244572_100X150X4.jpg",
            "http://img5.mtime.cn/mt/2017/03/09/092409.50105858_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/04/11/111227.60076107_100X150X4.jpg"};

    private String[] bannerDataStr = {"http://img5.mtime.cn/CMS/News/2017/04/12/120918.68633867_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120721.75468522_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120800.35757187_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120824.98543025_620X620.jpg"};

    ItemClickAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_categoty_detail;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    protected void initVars() {
        categoryDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusBarUtil.setColor(CategoryDetailActivity.this, getResources().getColor(R.color.colorAccent), 0);
        toolbar.setTitle("热门电影");
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
        List<MovieInfoEntity> datas = new ArrayList<MovieInfoEntity>();

        for (int i = 0; i < movieStr.length; i++) {
            MovieInfoEntity movieInfoEntity = new MovieInfoEntity(MovieInfoEntity.CLICK_ITEM_VIEW);
            movieInfoEntity.setName("电影名称" + (i + 1));
            movieInfoEntity.setUrl(movieStr[i]);
            datas.add(movieInfoEntity);
        }

        adapter = new ItemClickAdapter(this, datas);
        categoryDetailRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(CategoryDetailActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
