package com.zzd.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    private TextView mName,mPublish,mPrice;
    private BookInfo mBookInfo;
    private Button back,add;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myHelper = new MyHelper(this);
        mName = findViewById(R.id.name);
        mPublish = findViewById(R.id.publish);
        mPrice = findViewById(R.id.price);
        back = findViewById(R.id.btn_back);
        add = findViewById(R.id.btn_add);

        final Intent intent = getIntent();
        //service
        Intent intent2 = new Intent(this,MusicService.class);
        startService(intent2);
        //data
        mBookInfo = (BookInfo) intent.getSerializableExtra("items");
        if (mBookInfo != null) {
            mName.setText(mBookInfo.getName());
            mPublish.setText(mBookInfo.getPublish());
            mPrice.setText(mBookInfo.getPrice());
        }
        //click back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //click add
        add.setOnClickListener(new View.OnClickListener() {
            private String name;
            private String publish;
            private String price;
            private SQLiteDatabase db;
            private ContentValues values;
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                publish = mPublish.getText().toString();
                price = mPrice.getText().toString();
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("name",name);
                values.put("publish",publish);
                values.put("price",price);
                db.insert("book",null,values);
                Toast.makeText(DetailsActivity.this,"信息已添加",Toast.LENGTH_LONG).show();
                db.close();
            }
        });
    }
}