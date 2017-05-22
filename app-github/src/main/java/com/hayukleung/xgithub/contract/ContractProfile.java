package com.hayukleung.xgithub.contract;

import com.hayukleung.x.base.presenter.RXMVPPresenter;
import com.hayukleung.x.mvp.lce.LCEView;
import com.hayukleung.xgithub.model.GitHub;

/**
 * XGitHub
 * com.hayukleung.xgithub.contract
 * ContractMain.java
 *
 * by hayukleung
 * at 2017-04-06 11:30
 */

public interface ContractProfile {

  public interface IViewProfile extends LCEView<GitHub, IPresenterProfile> {

  }

  public abstract class IPresenterProfile extends RXMVPPresenter<IViewProfile> {

  }
}
