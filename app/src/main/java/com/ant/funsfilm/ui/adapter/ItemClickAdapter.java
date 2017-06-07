package com.ant.funsfilm.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.ant.funsfilm.R;
import com.ant.funsfilm.bean.MovieInfoEntity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;

import java.util.List;

public class ItemClickAdapter extends BaseMultiItemQuickAdapter<MovieInfoEntity, BaseViewHolder> implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    private Context mContext;

    public ItemClickAdapter(Context mContext, List<MovieInfoEntity> data) {
        super(data);
        this.mContext = mContext;
        addItemType(MovieInfoEntity.CLICK_ITEM_VIEW, R.layout.movie_info_item);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MovieInfoEntity item) {

    }

    @Override
    public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(mContext, "childView click", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Logger.d("嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次");
        Toast.makeText(mContext, "嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次", Toast.LENGTH_SHORT).show();
    }
}