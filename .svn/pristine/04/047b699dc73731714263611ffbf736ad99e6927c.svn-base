package com.ant.funsfilm;

import android.app.Application;
import android.content.Context;

import com.ant.funsfilm.util.AppContextUtil;

/**
 * Created by admin on 2017/4/7.
 */

public class App extends Application {

    public static Context applicationContext;

    public static Context getContext() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppContextUtil.init(this);
        applicationContext = this;
    }
}
