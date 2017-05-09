package com.hayukleung.x.bequiet.di.module;

import com.hayukleung.x.bequiet.ui.main.MainView;
import dagger.Module;
import dagger.Provides;

// step 3
@Module public class MainModule {

  private final MainView mMainView;

  public MainModule(MainView mainView) {
    mMainView = mainView;
  }

  @Provides MainView provideMainView() {
    return mMainView;
  }
}
