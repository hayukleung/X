package com.hayukleung.x.base.common.wrapper;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * 日志工具
 */
public class XLog {

  /**
   * 日志工具初始化
   *
   * @param tag 标签
   * @param debug 是否调试模式
   */
  public static void init(String tag, boolean debug) {
    Logger
        // default PRETTYLOGGER or use just init()
        .init(tag)
        // default 2
        .methodCount(3)
        // default shown
        .hideThreadInfo()
        // default LogLevel.FULL
        .logLevel(debug ? LogLevel.FULL : LogLevel.NONE)
        // default 0
        .methodOffset(2);
    // default AndroidLogAdapter
    // .logAdapter();
  }

  public static void i(String message) {
    i(message, "");
  }

  public static void i(String message, Object... args) {
    Logger.i(message, args);
  }

  public static void d(String message) {
    d(message, "");
  }

  public static void d(String message, Object... args) {
    Logger.d(message, args);
  }

  public static void w(String message) {
    w(message, "");
  }

  public static void w(String message, Object... args) {
    Logger.w(message, args);
  }

  public static void e(String message) {
    e(message, "");
  }

  public static void e(String message, Object... args) {
    Logger.e(message, args);
  }

  public static void e(Throwable throwable) {
    e(throwable, "");
  }

  public static void e(Throwable throwable, String message) {
    e(throwable, message, "");
  }

  public static void e(Throwable throwable, String message, Object... args) {
    Logger.e(throwable, message, args);
  }
}
