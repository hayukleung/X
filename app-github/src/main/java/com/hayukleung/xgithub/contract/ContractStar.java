package com.hayukleung.xgithub.contract;

import com.hayukleung.x.base.presenter.RXMVPPresenter;
import com.hayukleung.x.mvp.lce.LCEView;
import com.hayukleung.xgithub.model.Stub;

/**
 * XGitHub
 * com.hayukleung.xgithub.contract
 * ContractMain.java
 *
 * by hayukleung
 * at 2017-04-06 11:30
 */

public interface ContractStar {

  public interface IViewStar extends LCEView<Stub, IPresenterStar> {

  }

  public abstract class IPresenterStar extends RXMVPPresenter<IViewStar> {

  }
}
