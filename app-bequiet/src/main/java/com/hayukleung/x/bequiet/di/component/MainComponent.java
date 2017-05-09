package com.hayukleung.x.bequiet.di.component;

import com.hayukleung.x.bequiet.di.module.MainModule;
import com.hayukleung.x.bequiet.ui.main.MainFragment;
import dagger.Component;

@Component(modules = { MainModule.class }) public interface MainComponent {

  // step 4
  void inject(MainFragment mainFragment);
}
