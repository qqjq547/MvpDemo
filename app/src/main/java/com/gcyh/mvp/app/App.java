package com.gcyh.mvp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.gcyh.mvp.mvp.model.MyObjectBox;
import com.gcyh.mvp.tools.PrefUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.ArrayList;

import io.objectbox.BoxStore;

public class App extends Application {
        private static App instance;
        private ArrayList<Activity> activityList = new ArrayList<Activity>();
        private BoxStore boxStore;

        static {
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
                @Override
                public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                    layout.setPrimaryColorsId(android.R.color.white);//全局设置主题颜色
                    return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
                }
            });
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
                @Override
                public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                    //指定为经典Footer，默认是 BallPulseFooter
                    return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
                }
            });
        }

        @Override
        public void onCreate() {
            super.onCreate();
            instance = this;
            PrefUtil.init(this);
            boxStore = MyObjectBox.builder().androidContext(this).build();
        }
    public static App getInstance(){
        return instance;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    
    public void addActivity(Activity a) {
        activityList.add(a);
    }

    public void removeActivity(Activity a) {
        activityList.remove(a);
    }

    public Activity lastActivity() {
            if (activityList.size()>0) {
                return activityList.get(activityList.size() - 1);
            }else {
                return null;
            }
    }
    public void forceLogin() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        activityList.clear();
//        App.getInstance().getBoxStore().boxFor(UserInfo.class).removeAll();
//        String adConfig=PrefUtil.getInstance().getString(PrefUtil.ADVER_MESSAGE,"");
//        PrefUtil.getInstance().clean();
//        PrefUtil.getInstance().setBoolean(PrefUtil.FIRSTOPEN, false);
//        PrefUtil.getInstance().setString(PrefUtil.ADVER_MESSAGE,adConfig);
//        if (lastActivity()!=null&&lastActivity() instanceof LoginActivity){
//            return;
//        }
//        Intent in=new Intent(this ,LoginActivity.class);
//        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(in);
    }
    public void finishActivity() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        activityList.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
    public BoxStore getBoxStore() {
        return boxStore;
    }


}
