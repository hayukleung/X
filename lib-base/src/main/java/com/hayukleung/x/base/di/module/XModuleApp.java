package com.hayukleung.x.base.di.module;

import com.hayukleung.x.base.AppBase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

// @Module: Modules 类里面的方法专门提供依赖
// 所以我们定义一个类用@Module注解
// 这样Dagger在构造类的实例的时候就知道从哪里去找到需要的依赖
@Module public class XModuleApp {

  private final AppBase mAppBase;

  public XModuleApp(AppBase appBase) {
    mAppBase = appBase;
  }

  // 在 modules 中我们定义的方法是用这个注解
  // 以此来告诉 Dagger 我们想要构造对象并提供这些依赖
  @Provides @Singleton public AppBase provideApp() {
    return mAppBase;
  }
}
