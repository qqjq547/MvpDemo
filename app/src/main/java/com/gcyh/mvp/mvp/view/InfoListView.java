package com.gcyh.mvp.mvp.view;

import com.gcyh.mvp.http.response.Page;
import com.gcyh.mvp.mvp.model.InfoItem;

/**
 * Created by Administrator on 2017-11-28 0028.
 */

public interface InfoListView {
    void setData(Page<InfoItem> data);
    void setError(String msg);


}
