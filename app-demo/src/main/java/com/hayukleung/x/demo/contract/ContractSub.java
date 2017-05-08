package com.hayukleung.x.demo.contract;

import com.hayukleung.x.base.presenter.RXMVPPresenter;
import com.hayukleung.x.demo.model.Sub;
import com.hayukleung.x.mvp.lce.LCEView;

public interface ContractSub {

  public interface IViewSub extends LCEView<Sub, IPresenterSub> {
  }

  public abstract class IPresenterSub extends RXMVPPresenter<IViewSub> {
  }
}
