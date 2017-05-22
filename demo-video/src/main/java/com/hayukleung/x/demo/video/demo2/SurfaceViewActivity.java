package com.hayukleung.x.demo.video.demo2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.hayukleung.x.demo.video.R;
import java.io.IOException;

/**
 * X
 * com.hayukleung.x.demo.video.demo2
 * SurfaceViewActivity.java
 *
 * by hayukleung
 * at 2017-05-12 19:18
 */

public class SurfaceViewActivity extends AppCompatActivity {

  private SurfaceView mSurfaceView;
  private MediaPlayer mMediaPlayer;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_demo_2);
    mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);

    mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {

      @Override public void surfaceCreated(SurfaceHolder holder) {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setSurface(holder.getSurface());
        mMediaPlayer.setLooping(true);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.android_kitkat;
        try {
          mMediaPlayer.setDataSource(SurfaceViewActivity.this, Uri.parse(uri));
          mMediaPlayer.prepare();
        } catch (IOException e) {
          e.printStackTrace();
        }
        mMediaPlayer.start();
      }

      @Override
      public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

      }

      @Override public void surfaceDestroyed(SurfaceHolder holder) {

      }
    });
  }

  @Override protected void onPause() {
    if (null != mMediaPlayer && mMediaPlayer.isPlaying()) {
      mMediaPlayer.stop();
      mMediaPlayer.release();
      mMediaPlayer = null;
    }
    super.onPause();
  }
}
