package com.ant.funsfilm.api;

import android.support.annotation.IntRange;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2017/4/7.
 */

public interface MovieService {

    // 获取最新电影
    @GET("/html/gndy/dyzz/list_23_{index}.html")
    Observable<ResponseBody> getNewMovieList(@Query("index") @IntRange(from = 1, to = 131) int index);

}
