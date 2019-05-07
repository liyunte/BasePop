package com.lyt.pop;

import android.view.Gravity;
import android.view.ViewGroup;

public class PopConfig {
    private boolean mIsBgDarken=true;//是否开启背景变暗
    private float mDarkenDegree=0.5f;//背景变暗程度： 0-1  值越小越暗
    private boolean mIsClickOtherDismiss=false;//是否触摸外部取消popupwindow
    private int mX ;//x轴偏移量
    private int mY ;//y轴偏移量
    private int mWidth= ViewGroup.LayoutParams.WRAP_CONTENT;//pop宽高
    private int mHeight= ViewGroup.LayoutParams.WRAP_CONTENT;//pop宽高
    private int gravity = Gravity.CENTER;
    public static int ANIM_TRANSLATE_BOTTOM_TO_TOP = R.style.BasePopTranslateTopAnim;//从下往上平移进入动画
    public static int ANIM_TRANSLATE_TOP_TO_BOTTOM = R.style.BasePopTranslateBottomAnim;//从上往下平移进入动画
    public static int ANIM_TRANSLATE_RIGHT_TO_LEFT = R.style.BasePopTranslateLeftAnim;//从右往左平移进入动画
    public static int ANIM_TRANSLATE_LEFT_TO_RIGHT = R.style.BasePopTranslateRightAnim;//从左往右平移进入动画
    public static int ANIM_SCALE_RIGHT_TOP = R.style.BasePopScaleRightTopAnim;//右上角缩放进场动画（缩放中心点在右上角）
    public static int ANIM_SCALE_RIGHT_BOTTOM = R.style.BasePopScaleRightBottomAnim;//右下角缩放进场动画（缩放中心点在右下角）
    public static int ANIM_SCALE_LEFT_TOP = R.style.BasePopScaleLeftTopAnim;//左上角缩放进场动画（缩放中心点在左上角）
    public static int ANIM_SCALE_LEFT_BOTTOM = R.style.BasePopScaleLeftBottomAnim;//左下角缩放进场动画 （缩放中心点在左下角）
    private int style=-1;

    public int getStyle() {
        return style;
    }

    public PopConfig setStyle(int style) {
        this.style = style;
        return this;
    }

    public PopConfig setNotBgDarken(){
        this.mIsBgDarken = false;
        return this;
    }
    public PopConfig setClickOtherDismiss(){
        this.mIsClickOtherDismiss = true;
        return this;
    }
    public PopConfig setOffX(int offX){
        this.mX = offX;
        return this;
    }
    public PopConfig setOffY(int offY){
        this.mY = offY;
        return this;
    }
    public PopConfig setWidth(int width){
        this.mWidth = width;
        return this;
    }
    public PopConfig setGravity(int gravity){
        this.gravity = gravity;
        return this;
    }
    public PopConfig setHeight(int height){
        this.mHeight = height;
        return this;
    }
    public PopConfig setDarkenDegree(float darkenDegree){
        mDarkenDegree = darkenDegree;
        return this;
    }
    public float getDarkenDegree() {
        return mDarkenDegree;
    }

    public boolean ismIsBgDarken() {
        return mIsBgDarken;
    }

    public boolean ismIsClickOtherDismiss() {
        return mIsClickOtherDismiss;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }
    public int getGravity(){
        return gravity;
    }
}
