package com.kk.pay;

import android.os.Environment;

import com.kk.securityhttp.domain.ResultInfo;
import com.kk.securityhttp.engin.BaseEngin;
import com.kk.securityhttp.engin.HttpCoreEngin;

import rx.Observable;

/**
 * Created by zhangkai on 2017/2/20.
 */

public class PayEngin implements IPayEngin {

    @Override
    public Observable<ResultInfo<OrderInfo>> pay(OrderParamsInfo orderParamsInfo) {
        return HttpCoreEngin.get().rxpost(orderParamsInfo.getPay_url(), OrderInfo.class, orderParamsInfo.getParams(),
                true,
                true, true);
    }
}
