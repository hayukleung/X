package com.hayukleung.x.demo.di.module;

import com.hayukleung.x.demo.contract.ContractSub;
import dagger.Module;
import dagger.Provides;

@Module public class ModuleSub {

  private final ContractSub.IViewSub mIViewSub;

  public ModuleSub(ContractSub.IViewSub iViewSub) {
    mIViewSub = iViewSub;
  }

  @Provides ContractSub.IViewSub provideIViewSub() {
    return mIViewSub;
  }
}