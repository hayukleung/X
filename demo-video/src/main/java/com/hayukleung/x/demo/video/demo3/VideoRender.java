package com.hayukleung.x.demo.video.demo3;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.hayukleung.x.demo.video.R;
import java.io.IOException;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES11Ext.GL_TEXTURE_EXTERNAL_OES;
import static android.opengl.GLES20.GL_CLAMP_TO_EDGE;
import static android.opengl.GLES20.GL_LINEAR;
import static android.opengl.GLES20.GL_TEXTURE_2D;
import static android.opengl.GLES20.GL_TEXTURE_MAG_FILTER;
import static android.opengl.GLES20.GL_TEXTURE_MIN_FILTER;
import static android.opengl.GLES20.GL_TEXTURE_WRAP_S;
import static android.opengl.GLES20.GL_TEXTURE_WRAP_T;

/**
 * TODO
 */
public class VideoRender implements GLSurfaceView.Renderer {

  private Context mContext;

  private MediaPlayer mMediaPlayer;
  private SurfaceTexture mSurfaceTexture;

  private boolean mUpdateTexture;

  private float[] mSTMatrix;
  private int[] mTextureID;

  public VideoRender(Context context) {
    mContext = context;
  }

  @Override public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    initProgram();

    initSurfaceTexture();

    mediaPlay();
  }

  @Override public void onSurfaceChanged(GL10 gl, int width, int height) {

  }

  @Override public void onDrawFrame(GL10 gl) {
    updateTexture();
    draw();
  }

  private void updateTexture() {
    synchronized (this) {
      if (mUpdateTexture) {
        mSurfaceTexture.updateTexImage();
        mSurfaceTexture.getTransformMatrix(mSTMatrix);
        mUpdateTexture = false;
      }
    }
  }

  private void draw() {

  }

  private void initProgram() {
  }

  private void initSurfaceTexture() {
    GLES20.glGenTextures(1, mTextureID, 0);
    GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, mTextureID[0]);
    GLES20.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    GLES20.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    GLES20.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    GLES20.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

    mSurfaceTexture = new SurfaceTexture(mTextureID[0]);
    mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
      @Override public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
          mUpdateTexture = true;
        }
      }
    });
  }

  private void mediaPlay() {
    mMediaPlayer = new MediaPlayer();
    mMediaPlayer.setSurface(new Surface(mSurfaceTexture));
    String uri = "android.resource://" + mContext.getPackageName() + "/" + R.raw.android_kitkat;
    try {
      mMediaPlayer.setDataSource(mContext, Uri.parse(uri));
      mMediaPlayer.prepare();
    } catch (IOException e) {
      e.printStackTrace();
    }
    mMediaPlayer.start();
  }
}
