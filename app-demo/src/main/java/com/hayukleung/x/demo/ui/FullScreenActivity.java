package com.hayukleung.x.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class FullScreenActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    super.onCreate(savedInstanceState);
  }
}