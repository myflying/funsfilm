package com.ant.funsfilm.presenter;

import android.content.Context;

import com.ant.funsfilm.base.BasePresenterImp;
import com.ant.funsfilm.model.MovieModelImp;
import com.ant.funsfilm.view.MovieView;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2017/4/7.
 */

public class MoviePresenterImp extends BasePresenterImp<MovieView, ResponseBody> implements MoviePresenter{

    private Context context = null;
    private MovieModelImp movieModelImp = null;

    public MoviePresenterImp(MovieView view, Context context) {
        super(view);
        this.context = context;
        this.movieModelImp = new MovieModelImp(context);
    }

    @Override
    public void getNewMovieList(int index) {
        movieModelImp.getNewMovieList(index,this);
    }
}
