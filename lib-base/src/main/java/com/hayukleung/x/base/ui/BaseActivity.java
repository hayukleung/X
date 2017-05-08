package com.hayukleung.x.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.hayukleung.x.base.AppBase;
import com.hayukleung.x.base.common.wrapper.XLog;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class BaseActivity extends RxAppCompatActivity {

  private static final String TAG = "Activity";

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    XLog.d(String.format("%s.%s", TAG, "onCreate()"));
    super.onCreate(savedInstanceState);
    getComponentApp().inject(this);
  }

  @Override protected void onStart() {
    XLog.d(String.format("%s.%s", TAG, "onStart()"));
    super.onStart();
  }

  @Override protected void onResume() {
    XLog.d(String.format("%s.%s", TAG, "onResume()"));
    super.onResume();
  }

  @Override protected void onPause() {
    XLog.d(String.format("%s.%s", TAG, "onPause()"));
    super.onPause();
  }

  @Override protected void onStop() {
    XLog.d(String.format("%s.%s", TAG, "onStop()"));
    super.onStop();
  }

  @Override protected void onDestroy() {
    XLog.d(String.format("%s.%s", TAG, "onDestroy()"));
    super.onDestroy();
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   * @return
   */
  public XComponentApp getComponentApp() {
    return ((AppBase) getApplicationContext()).getAppComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   *
   * @return
   */
  protected XModuleActivity getModuleActivity() {
    return new XModuleActivity(this);
  }
}
