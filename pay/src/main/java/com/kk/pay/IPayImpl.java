package com.kk.pay;

import android.app.Activity;

/**
 * Created by zhangkai on 2017/3/17.
 */

public abstract class IPayImpl {

    public static OrderInfo uOrderInfo;
    public static IPayCallback uiPayCallback;
    public static String appid;
    protected Activity mContext;



    public IPayImpl(Activity context) {
        this.mContext = context;
    }

    public abstract void pay(OrderInfo orderInfo, IPayCallback iPayCallback);

    public Object befor(Object... obj) {
        return null;
    }

    public Object after(Object... obj) {
        return null;
    }

    protected String get(String cStr, String dStr){
        return cStr == null || cStr.isEmpty() ? dStr : cStr;
    }
}
