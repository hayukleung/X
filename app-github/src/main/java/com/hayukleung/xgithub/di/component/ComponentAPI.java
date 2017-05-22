package com.hayukleung.xgithub.di.component;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.di.component.XComponentActivity;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.base.ui.BaseActivity;
import com.hayukleung.xgithub.di.module.ModuleAPI;
import dagger.Component;

/**
 * XGitHub
 * com.hayukleung.xgithub.di.component
 * UserComponent.java
 *
 * by hayukleung
 * at 2017-03-31 16:31
 */
@PerActivity @Component(dependencies = XComponentApp.class, modules = {
    XModuleActivity.class, ModuleAPI.class
}) public interface ComponentAPI extends XComponentActivity {

  void inject(BaseActivity baseActivity);
}
