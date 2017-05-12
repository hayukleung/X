package com.hayukleung.x.demo.video.demo1;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;
import com.hayukleung.x.demo.video.R;

/**
 * X
 * com.hayukleung.x.demo.video.demo1
 * VideoViewActivity.java
 *
 * by hayukleung
 * at 2017-05-12 17:10
 */

public class VideoViewActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video_view);

    VideoView videoView = (VideoView) findViewById(R.id.video_view);
    String uri = "android.resource://" + getPackageName() + "/" + R.raw.android_kitkat;
    videoView.setVideoURI(Uri.parse(uri));
    videoView.start();
  }
}
