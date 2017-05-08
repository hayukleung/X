package com.hayukleung.x.base.di.module;

import com.hayukleung.x.base.di.PerActivity;
import com.hayukleung.x.base.ui.BaseActivity;
import dagger.Module;
import dagger.Provides;

/**
 * BaseActivity Module
 */
@Module public class XModuleActivity {

  private final BaseActivity mBaseActivity;

  public XModuleActivity(BaseActivity baseActivity) {
    mBaseActivity = baseActivity;
  }

  @Provides @PerActivity BaseActivity providesActivity() {
    return mBaseActivity;
  }
}
