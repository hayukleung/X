package com.hayukleung.x.bequiet.ui.welcome;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import com.hayukleung.x.base.ui.Activities;
import com.hayukleung.x.bequiet.common.PermissionsChecker;
import com.hayukleung.x.bequiet.ui.XBaseActivity;
import com.hayukleung.x.bequiet.ui.main.MainFragment;

/**
 * 欢迎
 */
public class WelcomeActivity extends XBaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    super.onCreate(savedInstanceState);
  }

  @Override protected void onResume() {
    super.onResume();

    if (PermissionsChecker.lacksPermissions(this, Manifest.permission.RECORD_AUDIO)) {
      // 缺少麦克风权限
      Dialogs.requestPermission(this, "麦克风录音权限");
    } else {
      Activities.startActivity(this, MainFragment.class);
      finish();
    }
  }
}
