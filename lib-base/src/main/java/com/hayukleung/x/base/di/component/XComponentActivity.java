package com.hayukleung.x.base.di.component;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.base.ui.BaseActivity;
import dagger.Component;

@PerActivity @Component(dependencies = XComponentApp.class, modules = {
    XModuleActivity.class
}) public interface XComponentActivity {

  BaseActivity getBaseActivity();
}
