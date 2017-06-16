package com.ant.funsfilm.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ant.funsfilm.R;
import com.ant.funsfilm.bean.TvInfoEntity;
import com.ant.funsfilm.common.Constants;
import com.ant.funsfilm.presenter.Presenter;
import com.ant.funsfilm.ui.adapter.TvItemClickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/21.
 */

public class TvListActivity extends BaseActivity {
    @BindView(R.id.toolbarContainer)
    Toolbar toolbar;

    @BindView(R.id.tv_list)
    RecyclerView categoryDetailRecyclerView;

    private String[] movieStr = {"http://img5.mtime.cn/mg/2017/04/10/142604.31208891_270X405X4.jpg", "http://img5.mtime.cn/mt/2017/03/10/100416.61663220_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/04/08/124652.27542728_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/03/28/152940.49244572_100X150X4.jpg",
            "http://img5.mtime.cn/mt/2017/03/09/092409.50105858_100X150X4.jpg", "http://img5.mtime.cn/mt/2017/04/11/111227.60076107_100X150X4.jpg"};

    private String[] bannerDataStr = {"http://img5.mtime.cn/CMS/News/2017/04/12/120918.68633867_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120721.75468522_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120800.35757187_620X620.jpg", "http://img5.mtime.cn/CMS/News/2017/04/12/120824.98543025_620X620.jpg"};

    TvItemClickAdapter adapter;

    List<TvInfoEntity> datas;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tv_list;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void initVars() {
        categoryDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusBarUtil.setColor(TvListActivity.this, getResources().getColor(R.color.colorAccent), 0);
        toolbar.setTitle("热门电视");
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
        datas = new ArrayList<TvInfoEntity>();
        adapter = new TvItemClickAdapter(TvListActivity.this, datas);
        categoryDetailRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(TvListActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        new TVListTask().execute();
    }

    public class TVListTask extends AsyncTask<Integer, Integer, List<TvInfoEntity>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<TvInfoEntity> doInBackground(Integer... params) {

            List<TvInfoEntity> tvDatas = new ArrayList<TvInfoEntity>();

            try {
                Document doc = Jsoup.connect(Constants.TV_URL).get();

                Elements dayElements = doc.select("ul.whlist").select("li");
                Elements imgs = dayElements.select(".listdetail").select("[src]");
                Elements tvLinks = dayElements.select(".listname").select("a"); //"a[href]" //带有href属性的a元素
                for (int i = 0; i < tvLinks.size(); i++) {
                    Element element = tvLinks.get(i);
                    TvInfoEntity tvInfoEntity = new TvInfoEntity(TvInfoEntity.CLICK_ITEM_VIEW);
                    tvInfoEntity.setTvImage(imgs.get(i).attr("src"));
                    tvInfoEntity.setTvUrl(element.attr("href"));
                    tvInfoEntity.setName(element.text());
                    tvDatas.add(tvInfoEntity);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return tvDatas;
        }

        @Override
        protected void onPostExecute(List<TvInfoEntity> tvdatas) {
            super.onPostExecute(tvdatas);
            if(tvdatas != null){
                //adapter.addData(tvdatas);
                adapter.setNewData(tvdatas);
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }
    }
}
