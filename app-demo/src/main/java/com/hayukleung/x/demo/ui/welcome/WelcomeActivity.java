package com.hayukleung.x.demo.ui.welcome;

import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hayukleung.x.base.ui.Activities;
import com.hayukleung.x.demo.R;
import com.hayukleung.x.demo.ui.FullScreenActivity;
import com.hayukleung.x.demo.ui.sub.SubFragment;

/**
 * 欢迎页
 */
public class WelcomeActivity extends FullScreenActivity {

  @BindView(R.id.go) Button mGo;

  private Unbinder mUnbinder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);

    mUnbinder = ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    if (null != mUnbinder) {
      mUnbinder.unbind();
    }
    super.onDestroy();
  }

  @OnClick(R.id.go) public void onViewClicked() {
    Activities.startActivity(this, SubFragment.class);
  }
}
