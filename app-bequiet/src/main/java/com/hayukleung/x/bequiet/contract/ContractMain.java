package com.hayukleung.x.bequiet.contract;

import com.hayukleung.x.base.model.BaseBean;
import com.hayukleung.x.base.presenter.RXMVPPresenter;
import com.hayukleung.x.mvp.lce.LCEView;

public interface ContractMain {

  public interface IViewMain extends LCEView<BaseBean, IPresenterMain> {
  }

  public abstract class IPresenterMain extends RXMVPPresenter<IViewMain> {
  }
}
