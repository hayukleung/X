package com.hayukleung.xgithub.ui;

import com.hayukleung.x.base.model.BaseBean;
import com.hayukleung.x.base.presenter.RXMVPPresenter;
import com.hayukleung.x.base.ui.XFragment;
import com.hayukleung.xgithub.di.module.ModuleAPI;
import javax.inject.Inject;

public abstract class XBaseFragment<M extends BaseBean, P extends RXMVPPresenter>
    extends XFragment<M, P> {

  // @Inject 告诉 Dagger 说 mGitHubApi 需要依赖注入
  // 于是 Dagger 就会构造一个 GitHubApi 的实例并满足它
  @Inject ModuleAPI mModuleAPI;

  public ModuleAPI getModuleAPI() {
    return mModuleAPI;
  }
}
