package com.zzd.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<BookInfo> mBookInfos;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MyAdapter(Context context,List<BookInfo> bookInfos) {
        this.mBookInfos = bookInfos;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mBookInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return  mBookInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //创建视图控件
        convertView = mLayoutInflater.inflate(R.layout.item,parent,false);

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_publish = convertView.findViewById(R.id.tv_publish);
        TextView tv_price = convertView.findViewById(R.id.tv_price);
        //为控件提供数据
        BookInfo bookInfo = mBookInfos.get(position);
        tv_name.setText("图书名："+bookInfo.getName());
        tv_publish.setText("出版社："+bookInfo.getPublish());
        tv_price.setText("价格："+bookInfo.getPrice());

        return convertView;
    }
}
