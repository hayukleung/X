package com.hayukleung.x.mvp.lce;

import android.support.annotation.UiThread;
import com.hayukleung.x.mvp.MVPPresenter;
import com.hayukleung.x.mvp.MVPView;

/**
 * mvp view with functions:
 * loading - content - error and empty
 *
 * @param <M>
 * @param <P>
 */
public interface LCEView<M, P extends MVPPresenter> extends MVPView<P> {

  @UiThread public void showLoading();

  @UiThread public void dismissLoading();

  @UiThread public void showContent(M data);

  @UiThread public void showError(Throwable e);

  @UiThread public void showEmpty();
}
