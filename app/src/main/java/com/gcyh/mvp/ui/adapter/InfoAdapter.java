package com.gcyh.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gcyh.mvp.mvp.model.InfoItem;
import com.gcyh.mvp.tools.glide.GlideImgManager;
import com.gcyh.mvp.R;

import java.util.List;

public class InfoAdapter extends BaseQuickAdapter<InfoItem,BaseViewHolder> {

    String keyWord;
    public InfoAdapter(@Nullable List<InfoItem> data) {
        super(R.layout.item_info,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InfoItem item) {

    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
        notifyDataSetChanged();
    }
}
