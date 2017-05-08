package com.hayukleung.x.base;

import com.hayukleung.x.base.common.wrapper.XLog;

/**
 * X
 * com.hayukleung.x.base
 * AppX.java
 *
 * by hayukleung
 * at 2017-05-08 12:15
 */

public abstract class AppX extends AppBase {

  protected abstract String getLogTag();
  protected abstract boolean isDebug();

  @Override public void onCreate() {
    super.onCreate();
    XLog.init(getLogTag(), isDebug());
  }
}
