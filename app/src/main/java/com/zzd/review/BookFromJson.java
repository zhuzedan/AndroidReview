package com.zzd.review;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class BookFromJson {
    public static List<BookInfo> getBooks (InputStream is) throws IOException {
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        String json = new String(buffer,"utf-8");
        Gson gson = new Gson();
        Type listType = new TypeToken<List<BookInfo>>(){
        }.getType();
        List<BookInfo> bookInfos = gson.fromJson(json,listType);
        return bookInfos;
    }
}
