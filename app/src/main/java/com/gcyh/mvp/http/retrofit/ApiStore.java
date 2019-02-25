package com.gcyh.mvp.http.retrofit;

import com.gcyh.mvp.http.response.HttpResponse;
import com.gcyh.mvp.http.response.Page;
import com.gcyh.mvp.mvp.model.InfoItem;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/26.
 */

public interface ApiStore {
    //获取分类资讯
    @GET("/api/v1/information/recommend/get")
    Observable<HttpResponse<Page<InfoItem>>> getRecommendList(
            @Query("currentPage") int currentPage,
            @Query("pageSize") int pageSize,
            @Query("categoryId") int categoryId);


}