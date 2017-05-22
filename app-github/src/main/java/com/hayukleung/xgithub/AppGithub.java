package com.hayukleung.xgithub;

import com.hayukleung.x.base.AppX;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * AppGithub.java
 *
 * by hayukleung
 * at 2017-03-31 09:25
 */

public class AppGithub extends AppX {

  @Override protected String getLogTag() {
    return AppGithub.class.getSimpleName();
  }

  @Override protected boolean isDebug() {
    return BuildConfig.DEBUG;
  }
}
