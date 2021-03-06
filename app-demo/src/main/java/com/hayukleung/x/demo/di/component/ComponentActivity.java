package com.hayukleung.x.demo.di.component;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.di.component.XComponentActivity;
import com.hayukleung.x.base.di.component.XComponentApp;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.demo.di.module.ModuleDemoAPI;
import dagger.Component;

@PerActivity @Component(dependencies = XComponentApp.class, modules = {
    XModuleActivity.class, ModuleDemoAPI.class
}) public interface ComponentActivity extends XComponentActivity {
}
