package com.hayukleung.xgithub.ui.trending;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.hayukleung.x.base.ui.UIUtils;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.ui.XBaseFragment;

/**
 * XGitHub
 * com.hayukleung.xgithub.view
 * TrendingFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:51
 */

public class TrendingFragment extends XBaseFragment {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, true);
  }

  @Override protected int getContentView() {
    return R.layout.content_trending;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }
}
