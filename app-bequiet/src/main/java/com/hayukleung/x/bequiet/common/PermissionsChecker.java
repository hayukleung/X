package com.hayukleung.x.bequiet.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

public class PermissionsChecker {

  /**
   * true: 没有权限
   */
  public static boolean lacksPermissions(Context context, String... permissions) {
    for (String permission : permissions) {
      if (lacksPermission(context, permission)) {
        return true;
      }
    }
    return false;
  }

  /**
   * true: 没有权限
   */
  private static boolean lacksPermission(Context context, String permission) {
    return ContextCompat.checkSelfPermission(context, permission)
        == PackageManager.PERMISSION_DENIED;
  }
}