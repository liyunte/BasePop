package com.lyt.pop;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;


public class BasePop extends PopupWindow implements PopupWindow.OnDismissListener {
    private OnInitViewListener mListener;
    private PopConfig mConfig;

    public BasePop(View contentView, PopConfig config, OnInitViewListener listener) {
        super(contentView, config.getWidth(), config.getHeight(), false);
        mConfig = config;
        setOutsideTouchable(config.ismIsClickOtherDismiss());//设置外部是否可以触摸
        mListener = listener;
        init();
    }

    private void init() {
        if (mConfig.getStyle() != -1) {
            setAnimationStyle(mConfig.getStyle());
        }
        setBackgroundDrawable(new BitmapDrawable());
        if (mListener != null) {
            mListener.onInitView(getContentView());
        }
    }

    public void show() {
        if (mConfig.ismIsBgDarken()) {
            startDarken();
        }
        showAtLocation(getContentView(), mConfig.getGravity(), mConfig.getX(), mConfig.getY());
    }

    @Override
    public void showAsDropDown(View anchor) {
        if (mConfig.ismIsBgDarken()) {
            startDarken();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        showAsDropDown(anchor, mConfig.getX(), mConfig.getY());
    }


    /**
     * 开始背景变暗
     */
    protected void startDarken() {
        if (getContentView().getContext() instanceof Activity) {
            Activity activity = (Activity) getContentView().getContext();
            final Window window = activity.getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.alpha = mConfig.getDarkenDegree();
            window.setAttributes(params);
        }
    }

    /**
     * 停止背景变暗
     */
    protected void stopDarken() {
        if (getContentView().getContext() instanceof Activity) {
            Activity activity = (Activity) getContentView().getContext();
            final Window window = activity.getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.alpha = 1f;
            window.setAttributes(params);
        }
    }


    /**
     * 关闭
     */
    @Override
    public void dismiss() {
        if (mConfig.ismIsBgDarken()) {
            stopDarken();
        }
        super.dismiss();
    }

    /**
     * popwindow退出监听
     */
    @Override
    public void onDismiss() {
        if (mListener != null) {
            mListener.onDismiss();
        }
    }

    /**
     * 当activity或fragment处于onStop状态时，应调用此方法
     */
    public void onStop(){
        if (isShowing()) {
            dismiss();
        }
    }

    /**
     * 释放 当activity或fragment处于onDistroy状态时,应调用次方法
     */
    public void onDistroy() {
        onStop();
        if (mListener != null) {
            mListener = null;
        }
        if (mConfig != null) {
            mConfig = null;
        }
    }

}
