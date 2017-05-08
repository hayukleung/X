package com.hayukleung.x.demo;

import com.hayukleung.x.base.*;
import com.hayukleung.x.base.BuildConfig;

public class App extends AppX {

  @Override protected String getLogTag() {
    return "demo";
  }

  @Override protected boolean isDebug() {
    return BuildConfig.DEBUG;
  }
}
