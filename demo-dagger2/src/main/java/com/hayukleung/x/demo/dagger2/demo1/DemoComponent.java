package com.hayukleung.x.demo.dagger2.demo1;

import dagger.Component;

@Component public interface DemoComponent {

  // step 3
  void inject(DemoActivity demoActivity);
}
