package com.hayukleung.x.demo.di.component;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.demo.di.module.ModuleSub;
import com.hayukleung.x.demo.ui.sub.SubFragment;
import dagger.Component;

@PerActivity @Component(dependencies = XComponentApp.class, modules = {
    XModuleActivity.class, ModuleSub.class
}) public interface ComponentSub {

  void inject(SubFragment subFragment);
}
