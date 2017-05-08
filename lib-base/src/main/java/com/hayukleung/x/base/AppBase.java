package com.hayukleung.x.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import com.hayukleung.x.base.di.component.DaggerXComponentApp;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleApp;

public class AppBase extends MultiDexApplication {

  private XComponentApp mXComponentApp;

  public static AppBase getInstance(Context context) {
    return (AppBase) context.getApplicationContext();
  }

  public XComponentApp getAppComponent() {
    if (null == mXComponentApp) {
      initComponent();
    }
    return mXComponentApp;
  }

  private void initComponent() {
    mXComponentApp = DaggerXComponentApp.builder().xModuleApp(new XModuleApp(this)).build();
  }

  @Override public void onCreate() {
    super.onCreate();
    initComponent();
  }
}
