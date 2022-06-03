package com.zzd.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView name,publish,price;
    private BookInfo mBookInfo;
    private Button back,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.name);
        publish = findViewById(R.id.publish);
        price = findViewById(R.id.price);
        back = findViewById(R.id.btn_back);
        add = findViewById(R.id.btn_add);

        final Intent intent = getIntent();
        mBookInfo = (BookInfo) intent.getSerializableExtra("items");
        if (mBookInfo != null) {
            name.setText(mBookInfo.getName());
            publish.setText(mBookInfo.getPublish());
            price.setText(mBookInfo.getPrice());
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}