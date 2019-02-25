package com.gcyh.mvp.mvp.presenter;

import com.gcyh.mvp.base.BasePresenter;
import com.gcyh.mvp.http.exception.ApiException;
import com.gcyh.mvp.http.response.Page;
import com.gcyh.mvp.http.retrofit.ApiCallback;
import com.gcyh.mvp.http.retrofit.ApiClient;
import com.gcyh.mvp.mvp.model.InfoItem;
import com.gcyh.mvp.mvp.view.InfoListView;
import com.gcyh.mvp.tools.RxUtil;

/**
 * Created by Administrator on 2017-11-28 0028.
 */

public class InfoListPresenter extends BasePresenter<InfoListView> {
    public InfoListPresenter(InfoListView view) {
        attachView(view);
    }
    public void getRecommendList(int currentPage,int pageSize,int categoryId){
        addSubscription(RxUtil.createHttpObservable(ApiClient.getInstance().getApiStores().getRecommendList(currentPage,pageSize,categoryId)), new ApiCallback<Page<InfoItem>>() {
            @Override
            public void onSuccess(Page<InfoItem> data) {
                mvpView.setData(data);

            }

            @Override
            public void onFailure(ApiException exception) {
                mvpView.setError(exception.getMessage());

            }

            @Override
            public void onFinish() {

            }
        });
    }

}
