package com.hayukleung.x.bequiet.ui.main;

import android.support.annotation.WorkerThread;
import com.hayukleung.x.bequiet.contract.ContractMain;

public interface MainView extends ContractMain.IViewMain {

  /**
   * 请求权限
   */
  @WorkerThread void onRequestPermission();

  /**
   * 开始检测
   */
  @WorkerThread void onStarted();

  /**
   * 获取分贝值
   *
   * @param decibel decibel = 10 * lg(mean)
   * @param mean mean = 10 ^ (decibel / 10)
   */
  @WorkerThread void onRunning(double decibel, double mean);

  /**
   * 阻尼停止中
   *
   * @param decibel
   * @param mean
   */
  @WorkerThread void onStopping(double decibel, double mean);

  /**
   * 监测停止
   */
  @WorkerThread void onStopped();
}
