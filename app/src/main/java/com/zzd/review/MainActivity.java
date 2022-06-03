package com.zzd.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<BookInfo> mBookInfos;
    private ListView mListView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init
        mListView = findViewById(R.id.lv);

        InputStream inputStream = getResources().openRawResource(R.raw.book);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            mBookInfos = BookFromJson.getBooks(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //initevent
        myAdapter = new MyAdapter(this,mBookInfos);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookInfo bookInfo = mBookInfos.get(position);
                String name = bookInfo.getName();
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("items",bookInfo);
                startActivity(intent);
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
            }
        });
    }


}
/*
 * 1界面写出来  20
 * 2将数据呈现出来 json解析and adapter  30
 * 3通信跳转 点击进入详情页，并有数据  listview的点击事件  15
 * 4service 跳转到详情页面需要播放音乐 10
 * 5sqlite 收藏按钮点击后将图书信息保存到表中（创建book数据库 建表 拿到contentvalue存进去 存储成功弹出toast）25
 * */