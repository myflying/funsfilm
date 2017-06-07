package com.kk.pay.other;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kk.pay.R;


/**
 * Created by zhangkai on 2017/2/21.
 */

public class LoadingDialog extends Dialog {

    ImageView ivCircle;
    TextView tvMsg;

    public LoadingDialog(Context context) {
        super(context, R.style.customDialog);
        View view = LayoutInflater.from(context).inflate(
                getLayoutID(), null);
        ivCircle = (ImageView)view.findViewById(R.id.iv_circle);
        tvMsg= (TextView)view.findViewById(R.id.tv_msg);
        this.setContentView(view);
        this.setCancelable(true);
    }

    public void show(String msg) {
        super.show();
        ivCircle.startAnimation(AnimationUtil.rotaAnimation());
        tvMsg.setText(msg);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        ivCircle.clearAnimation();
    }

    public int getLayoutID() {
        return R.layout.dialog_loading;
    }
}
