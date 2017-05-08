package com.hayukleung.x.demo.dagger2.demo2;

import dagger.Component;

@Component(modules = { DemoModule.class }) public interface DemoComponent {

  // step 4
  void inject(DemoActivity demoActivity);
}
