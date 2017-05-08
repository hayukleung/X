package com.hayukleung.x.demo.ui.welcome;

import android.os.Bundle;
import com.hayukleung.x.base.ui.Activities;
import com.hayukleung.x.demo.ui.FullScreenActivity;
import com.hayukleung.x.demo.ui.sub.SubFragment;

/**
 * X
 * com.hayukleung.x.demo.ui.welcome
 * WelcomeActivity.java
 *
 * by hayukleung
 * at 2017-05-08 14:06
 */

public class WelcomeActivity extends FullScreenActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Activities.startActivity(this, SubFragment.class);
  }
}
