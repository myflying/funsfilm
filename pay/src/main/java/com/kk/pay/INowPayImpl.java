package com.kk.pay;

import android.app.Activity;

import com.ipaynow.plugin.api.IpaynowPlugin;
import com.ipaynow.plugin.utils.PreSignMessageUtil;

import java.math.BigDecimal;

/**
 * Created by zhangkai on 2017/3/27.
 */

public class INowPayImpl extends IPayImpl {
    private IpaynowPlugin mIpaynowplugin;

    //微信支付
    private PreSignMessageUtil  preSign = new PreSignMessageUtil();;
    private String type;
    public INowPayImpl(Activity context, String type) {
        super(context);
        this.type = type;
        if (mIpaynowplugin == null) {
            mIpaynowplugin = IpaynowPlugin.getInstance().init(context);// 1.插件初始化
            mIpaynowplugin.unCkeckEnvironment();
        }
    }


    @Override
    public void pay(OrderInfo orderInfo, IPayCallback iPayCallback) {
        if (orderInfo.getPayInfo() == null) {
            return;
        }
        uOrderInfo = orderInfo;
        uiPayCallback = iPayCallback;

        PayInfo payInfo = orderInfo.getPayInfo();
        preSign.appId =get(payInfo.getChannelId(), payInfo.getPartnerid());
        preSign.mhtOrderNo = orderInfo.getOrder_sn();
        preSign.notifyUrl = get(payInfo.getNotify_url() + "", "");
        preSign.mhtOrderStartTime = payInfo.getStarttime();
        String wx_sign = payInfo.getWx_sign();
        String preSignStr = preSign.generatePreSignMessage();
        String mhtSignature = preSignStr + "&mhtSignature=" + wx_sign
                + "&mhtSignType=MD5";
        mIpaynowplugin.setCallResultActivity(mContext).pay(mhtSignature);
    }

    private void prePayMessage(float money, String name) {
        preSign.appId = "{appid}";

        preSign.mhtCharset = "UTF-8";
        preSign.mhtCurrencyType = "156";
        // 支付金额
        BigDecimal bd = new BigDecimal(money+"0");
        preSign.mhtOrderAmt = Integer.toString(bd.multiply(new BigDecimal(100)).intValue());;
        preSign.mhtOrderDetail = name;
        preSign.mhtOrderName = name;
        preSign.mhtOrderNo = "{orderid}";
        preSign.payChannelType = type;

        preSign.mhtOrderStartTime = "{starttime}";

        preSign.mhtOrderTimeOut = "10000";
        preSign.mhtOrderType = "01";
        preSign.notifyUrl = "{notify_url}";
        preSign.mhtReserved = "nowpay";
    }

    @Override
    public Object befor(Object... obj) {
        prePayMessage(Float.parseFloat(obj[0] + ""), obj[1] + "");
        return preSign.generatePreSignMessage();
    }

}
