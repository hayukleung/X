package com.hayukleung.x.bequiet;

import com.hayukleung.x.base.AppX;

/**
 * X
 * com.hayukleung.x.bequiet
 * AppBequiet.java
 *
 * by hayukleung
 * at 2017-05-09 19:55
 */

public class AppBequiet extends AppX {

  @Override protected String getLogTag() {
    return "bequiet";
  }

  @Override protected boolean isDebug() {
    return true;
  }
}
