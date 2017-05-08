package com.hayukleung.x.demo.ui.sub;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.hayukleung.x.base.di.HasComponent;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.base.ui.UIUtils;
import com.hayukleung.x.demo.R;
import com.hayukleung.x.demo.contract.ContractSub;
import com.hayukleung.x.demo.di.component.ComponentSub;
import com.hayukleung.x.demo.di.component.DaggerComponentSub;
import com.hayukleung.x.demo.di.module.ModuleSub;
import com.hayukleung.x.demo.model.Sub;
import com.hayukleung.x.demo.presenter.PresenterSub;
import com.hayukleung.x.demo.ui.DemoBaseFragment;
import javax.inject.Inject;

public class SubFragment extends DemoBaseFragment<Sub, ContractSub.IPresenterSub>
    implements SubView, HasComponent<ComponentSub> {

  @Inject protected PresenterSub mPresenterSub;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mPresenterSub.attachView(this);
  }

  @Override public ComponentSub getComponent() {
    return DaggerComponentSub.builder()
        .xComponentApp(getBaseActivity().getComponentApp())
        .xModuleActivity(new XModuleActivity(getBaseActivity()))
        .moduleSub(new ModuleSub(this))
        .build();
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, true, getResources().getColor(R.color.colorPrimary));
  }

  @Override protected int getContentView() {
    return R.layout.content_sub;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Toolbar toolbar = getToolbar();
    toolbar.setBackgroundColor(Color.WHITE);
    toolbar.setVisibility(View.VISIBLE);

    UIUtils.setCenterTitle(getActivity(), toolbar, "sub")
        .setTextColor(getActivity().getResources().getColor(android.R.color.black));

    // mPresenterProfile.request(getGitHubApiModule(), bindUntilEvent(FragmentEvent.PAUSE));
    // mPresenterProfile.queryCategory(getActivity());
  }

  @Override public void onDestroy() {
    mPresenterSub.detachView();
    super.onDestroy();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }
}
