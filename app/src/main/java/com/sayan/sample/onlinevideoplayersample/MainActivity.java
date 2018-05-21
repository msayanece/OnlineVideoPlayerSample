package com.sayan.sample.onlinevideoplayersample;

import android.content.pm.ActivityInfo;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        String thumbUrl = "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
        String path1 = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
        String path2 = "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        String url = path1;
        useJZVideoPlayer(url, thumbUrl);
    }


    private void useJZVideoPlayer(String url, String thumbUrl) {
        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "Video");
        Glide.with(this)
                .load(thumbUrl)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(jzVideoPlayerStandard.thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}
