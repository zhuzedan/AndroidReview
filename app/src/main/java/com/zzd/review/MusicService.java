package com.zzd.review;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mp;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        // 初始化音乐资源
        try {
            mp = new MediaPlayer();
            mp = MediaPlayer.create(MusicService.this, R.raw.a);
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // 开始播放音乐
        if (null != mp) {
            mp.start();
        }
    }

    @Override
    public void onDestroy() {
        // 服务停止时停止播放音乐并释放资源
        if(null!=mp) {
            mp.stop();
            mp.release();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
