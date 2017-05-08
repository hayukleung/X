package com.hayukleung.x.demo.ui;

import com.hayukleung.x.base.ui.XActivity;
import com.hayukleung.x.demo.di.module.ModuleDemoAPI;
import javax.inject.Inject;

public class DemoBaseActivity extends XActivity {

  @Inject public ModuleDemoAPI mModuleDemoAPI;
}
