package com.hayukleung.xgithub.di.component;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.di.component.XComponentActivity;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.xgithub.di.module.ModuleAPI;
import com.hayukleung.xgithub.ui.profile.ProfileFragment;
import dagger.Component;

/**
 * XGitHub
 * com.hayukleung.xgithub.di.component
 * ComponentMain.java
 *
 * by hayukleung
 * at 2017-04-02 17:38
 */
@PerActivity @Component(dependencies = XComponentApp.class, modules = {
    XModuleActivity.class, ModuleAPI.class
}) public interface ComponentProfile extends XComponentActivity {

  void inject(ProfileFragment profileFragment);
}
