package com.ant.funsfilm.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ant.funsfilm.R;
import com.ant.funsfilm.bean.MovieInfoEntity;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class HeaderAndFooterAdapter extends BaseQuickAdapter<MovieInfoEntity, BaseViewHolder> {

    private Context mContext;

    private ImageView movieIv;

    public HeaderAndFooterAdapter(Context context, List<MovieInfoEntity> datas) {
        super(R.layout.movie_info_item, datas);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MovieInfoEntity movieInfoEntity) {
        baseViewHolder.setText(R.id.movie_name_tv, movieInfoEntity.getName());
        movieIv = (ImageView) baseViewHolder.getConvertView().findViewById(R.id.movie_iv);
        Glide.with(mContext).load(movieInfoEntity.getUrl()).into(movieIv);
    }

}