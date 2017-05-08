package com.hayukleung.x.demo.dagger2.demo2;

import dagger.Module;
import dagger.Provides;

// step 3
@Module public class DemoModule {

  private final String mContent;

  public DemoModule(String content) {
    mContent = content;
  }

  @Provides String provideContent() {
    return mContent;
  }
}
