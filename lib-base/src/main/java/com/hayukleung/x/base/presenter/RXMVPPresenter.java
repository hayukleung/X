package com.hayukleung.x.base.presenter;

import com.hayukleung.x.mvp.lce.LCEPresenter;
import com.hayukleung.x.mvp.lce.LCEView;

public class RXMVPPresenter<V extends LCEView> extends LCEPresenter<V> {

  // protected CompositeDisposable mCompositeDisposable;

  @Override public void attachView(V view) {
    super.attachView(view);
    // mCompositeDisposable = new CompositeDisposable();
  }

  @Override public void detachView() {
    super.detachView();
    // mCompositeDisposable.clear();
    // mCompositeDisposable = null;
  }
}
