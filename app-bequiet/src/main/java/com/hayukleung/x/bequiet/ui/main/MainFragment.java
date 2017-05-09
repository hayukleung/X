package com.hayukleung.x.bequiet.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.hayukleung.x.base.di.HasComponent;
import com.hayukleung.x.base.model.BaseBean;
import com.hayukleung.x.base.ui.TranslucentStatusCompat;
import com.hayukleung.x.base.ui.UIUtils;
import com.hayukleung.x.bequiet.R;
import com.hayukleung.x.bequiet.contract.ContractMain;
import com.hayukleung.x.bequiet.di.component.DaggerMainComponent;
import com.hayukleung.x.bequiet.di.component.MainComponent;
import com.hayukleung.x.bequiet.di.module.MainModule;
import com.hayukleung.x.bequiet.presenter.MainPresenter;
import com.hayukleung.x.bequiet.ui.XBaseFragment;
import com.hayukleung.x.bequiet.ui.welcome.Dialogs;
import com.hayukleung.x.bequiet.widget.ShyaringanView;
import java.util.Locale;
import javax.inject.Inject;

public class MainFragment extends XBaseFragment<BaseBean, ContractMain.IPresenterMain>
    implements MainView, HasComponent<MainComponent> {

  @Inject protected MainPresenter mDecibelRecorder;
  @BindView(R.id.decibel) TextView mDecibel;
  @BindView(R.id.shyaringan) ShyaringanView mShyaringanView;
  private boolean mRunning = true;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TranslucentStatusCompat.requestTranslucentStatus(getActivity());
    UIUtils.requestStatusBarLight(this, false);
    getComponent().inject(this);
  }

  @Override public void onResume() {
    super.onResume();

    if (mRunning) {
      mDecibelRecorder.on();
    }
  }

  @Override public void onPause() {
    if (null != mDecibelRecorder) {
      mRunning = mDecibelRecorder.isRunning();
      mDecibelRecorder.off();
    }
    // TODO mFan.stop();
    super.onPause();
  }

  @Override protected int getContentView() {
    return R.layout.content_main;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public MainComponent getComponent() {
    return DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
  }

  @Override public void onRequestPermission() {
    getHandler().sendAction(new Runnable() {
      @Override public void run() {
        // 缺少麦克风权限
        Dialogs.requestPermission(getActivity(), "麦克风录音权限");
      }
    });
  }

  @Override public void onStarted() {
    getHandler().sendAction(new Runnable() {
      @Override public void run() {
        // TODO mFan.start(mDecibelRecorder);
      }
    });
  }

  @Override public void onRunning(final double decibel, double mean) {
    getHandler().sendAction(new Runnable() {
      @Override public void run() {
        String content = String.format(Locale.CHINA, "%.2f dB", decibel);
        mDecibel.setText(content);
        mShyaringanView.setDeltaAngle((int) (Math.pow(decibel, 3) / 25000f));
      }
    });
  }

  @Override public void onStopping(double decibel, double mean) {
    getHandler().sendAction(new Runnable() {
      @Override public void run() {
        String content = "STOPPING";
        mDecibel.setText(content);
      }
    });
  }

  @Override public void onStopped() {
    getHandler().sendAction(new Runnable() {
      @Override public void run() {
        String content = "OFF";
        mDecibel.setText(content);
        // TODO mFan.stop();
      }
    });
  }
}