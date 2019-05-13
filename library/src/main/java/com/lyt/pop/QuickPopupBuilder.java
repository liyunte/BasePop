package com.lyt.pop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuickPopupBuilder {
    private LayoutInflater inflater;
    private View mContentView;
    private PopConfig mConfig;
    private OnInitViewListener mListener;

    private QuickPopupBuilder(Context context){
        inflater = LayoutInflater.from(context);
    }
    public static QuickPopupBuilder with(@NonNull Context context){
        if (context==null){
            throw new NullPointerException("context is not Null");
        }
        return new QuickPopupBuilder(context);
    }
    public QuickPopupBuilder setContentView(int resLayout){
        this.mContentView = inflater.inflate(resLayout,null);
        inflater = null;
        return this;
    }
    public QuickPopupBuilder setContentView(@NonNull View contentView){
        if (contentView==null){
            throw new NullPointerException("contentView is not Null");
        }
        this.mContentView = contentView;
        inflater = null;
        return this;
    }
   public QuickPopupBuilder setPopConfig(@NonNull PopConfig config){
       if (config==null){
           throw new NullPointerException("config is not Null");
       }
       mConfig = config;
        return this;
   }
    public QuickPopupBuilder setOnInitViewListener(@NonNull OnInitViewListener listener){
        if (listener==null){
            throw new NullPointerException("listener is not Null");
        }
        this.mListener = listener;
        return this;
    }

    public BasePop build(){
        if (mContentView==null){
            throw new NullPointerException("mContentView is not Null");
        }
        if (mConfig==null){
            mConfig = new PopConfig();
        }
        if (!mConfig.ismIsClickOtherDismiss()){
            mConfig.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            mConfig.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        }
        return new BasePop(mContentView,mConfig,mListener);
    }

}
