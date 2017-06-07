package com.kk.pay;

import android.app.Activity;


import com.kk.pay.other.LoadingDialog;
import com.kk.pay.other.ToastUtil;
import com.kk.securityhttp.domain.GoagalInfo;
import com.kk.securityhttp.domain.ResultInfo;
import com.kk.securityhttp.net.contains.HttpConfig;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Created by zhangkai on 2017/3/17.
 */

public class I1PayAbs extends IPayAbs {
    private IPayEngin payEngin;
    private LoadingDialog loadingDialog;

    public I1PayAbs(Activity context, IPayImpl iPayImpl) {
        super(context, iPayImpl);

        payEngin = new PayEngin();
        loadingDialog = new LoadingDialog(mContext);
    }

    public I1PayAbs(Activity context, IPayImpl aliPayImpl, IPayImpl wxiPayImpl) {
        super(context, aliPayImpl, wxiPayImpl);

        payEngin = new PayEngin();
        loadingDialog = new LoadingDialog(mContext);
    }

    @Override
    public void alipay(OrderParamsInfo orderParamsInfo, IPayCallback callback) {
        if (aliPayImpl == null) {
            ToastUtil.toast2(mContext, "支付宝通道已关闭");
            return;
        }
        pay(aliPayImpl, orderParamsInfo, callback);
    }

    @Override
    public void wxpay(OrderParamsInfo orderParamsInfo, IPayCallback callback) {
        if (wxiPayImpl == null) {
            ToastUtil.toast2(mContext, "微信支付通道已关闭");
            return;
        }
        pay(wxiPayImpl, orderParamsInfo, callback);
    }

    private void pay(final IPayImpl iPayImpl,final OrderParamsInfo orderParamsInfo,final IPayCallback callback) {
        loadingDialog.show("请稍后...");
        String md5signstr = iPayImpl.befor(Debug ? Debug_Price: orderParamsInfo.getPrice() + "", orderParamsInfo.getName()) + "";
        orderParamsInfo.setMd5signstr(md5signstr);

        payEngin.pay(orderParamsInfo).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ResultInfo<OrderInfo>>() {
            @Override
            public void call(ResultInfo<OrderInfo> resultInfo) {
                loadingDialog.dismiss();

                OrderInfo orderInfo = null;
                String order_sn = System.currentTimeMillis() + "_" + GoagalInfo.get().uuid;
                if (resultInfo.code == HttpConfig.STATUS_OK) {
                    if (resultInfo.data != null && resultInfo.data.getOrder_sn() != null) {
                        orderInfo = resultInfo.data;
                    }
                }
                if(orderInfo == null){
                    orderInfo = new OrderInfo(Integer.parseInt(orderParamsInfo.getGoods_id()), orderParamsInfo.getPrice(),
                            orderParamsInfo.getName(), order_sn, orderParamsInfo.getPayway_name(), null);
                } else {
                    orderInfo.setPayway(orderParamsInfo.getPayway_name());
                    orderInfo.setViptype(Integer.parseInt(orderParamsInfo.getGoods_id()));
                    orderInfo.setName(orderParamsInfo.getName());
                }
                orderInfo.setMoney(Debug ? Debug_Price: orderInfo.getMoney());
                iPayImpl.pay(orderInfo, callback);
            }
        });
    }
}