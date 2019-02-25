package com.gcyh.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gcyh.mvp.R;
import com.gcyh.mvp.base.BaseActivity;
import com.gcyh.mvp.base.MvpActivity;
import com.gcyh.mvp.http.response.Page;
import com.gcyh.mvp.mvp.model.InfoItem;
import com.gcyh.mvp.mvp.presenter.InfoListPresenter;
import com.gcyh.mvp.mvp.view.InfoListView;

public class MainActivity extends MvpActivity<InfoListPresenter> implements InfoListView {

    @Override
    protected InfoListPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewAndData() {

    }

    @Override
    public void setData(Page<InfoItem> data) {

    }

    @Override
    public void setError(String msg) {

    }
}
