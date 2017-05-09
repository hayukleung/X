package com.hayukleung.x.base.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.hayukleung.x.base.common.wrapper.XLog;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseFragment extends RxFragment {

  private static final String TAG = "Fragment";

  public boolean onBackPressed() {
    return false;
  }

  protected BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  @Override public void onAttach(Activity activity) {
    XLog.e(String.format("%s.%s", TAG, "onAttach()"));
    super.onAttach(activity);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    XLog.e(String.format("%s.%s", TAG, "onCreate()"));
    super.onCreate(savedInstanceState);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    XLog.e(String.format("%s.%s", TAG, "onViewCreated()"));
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onStart() {
    XLog.e(String.format("%s.%s", TAG, "onStart()"));
    super.onStart();
  }

  @Override public void onResume() {
    XLog.e(String.format("%s.%s", TAG, "onResume()"));
    super.onResume();
  }

  @Override public void onPause() {
    XLog.e(String.format("%s.%s", TAG, "onPause()"));
    super.onPause();
  }

  @Override public void onStop() {
    XLog.e(String.format("%s.%s", TAG, "onStop()"));
    super.onStop();
  }

  @Override public void onDestroyView() {
    XLog.e(String.format("%s.%s", TAG, "onDestroyView()"));
    super.onDestroyView();
  }

  @Override public void onDestroy() {
    XLog.e(String.format("%s.%s", TAG, "onDestroy()"));
    super.onDestroy();
  }

  @Override public void onDetach() {
    XLog.e(String.format("%s.%s", TAG, "onDetach()"));
    super.onDetach();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    XLog.e(String.format("%s.%s", TAG, "onActivityCreated()"));
    super.onActivityCreated(savedInstanceState);
  }
}
