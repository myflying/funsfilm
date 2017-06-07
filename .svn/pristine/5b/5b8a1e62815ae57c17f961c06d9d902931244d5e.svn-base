package com.ant.funsfilm.model;

import android.content.Context;

import com.ant.funsfilm.api.MovieService;
import com.ant.funsfilm.base.BaseModel;
import com.ant.funsfilm.base.IBaseRequestCallBack;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by admin on 2017/4/7.
 */

public class MovieModelImp extends BaseModel implements MovieModel<ResponseBody> {

    private Context context;
    private MovieService movieService;
    private CompositeSubscription mCompositeSubscription;

    public MovieModelImp(Context context) {
        this.context = context;
        movieService = mRetrofit.create(MovieService.class);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void getNewMovieList(int index, final IBaseRequestCallBack<ResponseBody> iBaseRequestCallBack) {
        mCompositeSubscription.add(movieService.getNewMovieList(index)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        //onStart它总是在 subscribe 所发生的线程被调用 ,如果你的subscribe不是主线程，则会出错，则需要指定线程;
                        iBaseRequestCallBack.beforeRequest();
                    }

                    @Override
                    public void onCompleted() {
                        //回调接口：请求已完成，可以隐藏progress
                        iBaseRequestCallBack.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //回调接口：请求异常
                        iBaseRequestCallBack.requestError(e);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //回调接口：请求成功，获取实体类对象
                        iBaseRequestCallBack.requestSuccess(responseBody);
                    }
                }));
    }
}
