package com.hayukleung.x.demo.ui;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class FullScreenActivity extends DemoBaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    super.onCreate(savedInstanceState);
  }
}