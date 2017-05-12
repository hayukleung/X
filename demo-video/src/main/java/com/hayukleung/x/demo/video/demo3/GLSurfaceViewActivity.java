package com.hayukleung.x.demo.video.demo3;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * X
 * com.hayukleung.x.demo.video.demo3
 * GLSurfaceViewActivity.java
 *
 * by hayukleung
 * at 2017-05-12 19:24
 */

public class GLSurfaceViewActivity extends AppCompatActivity {

  private GLSurfaceView mGLSurfaceView;
  private VideoRender mRender;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mGLSurfaceView = new GLSurfaceView(this);
    // use opengl es 2.0
    mGLSurfaceView.setEGLContextClientVersion(2);
    setContentView(mGLSurfaceView);

    mRender = new VideoRender(this);
    mGLSurfaceView.setRenderer(mRender);
  }
}
