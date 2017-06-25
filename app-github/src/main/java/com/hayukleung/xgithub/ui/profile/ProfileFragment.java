package com.hayukleung.xgithub.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hayukleung.x.base.di.HasComponent;
import com.hayukleung.x.base.di.module.XModuleActivity;
import com.hayukleung.x.base.ui.UIUtils;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.common.wrapper.XImage;
import com.hayukleung.xgithub.contract.ContractProfile;
import com.hayukleung.xgithub.di.component.ComponentProfile;
import com.hayukleung.xgithub.di.component.DaggerComponentProfile;
import com.hayukleung.xgithub.model.GitHub;
import com.hayukleung.xgithub.presenter.PresenterProfile;
import com.hayukleung.xgithub.ui.XBaseFragment;
import com.trello.rxlifecycle2.android.FragmentEvent;
import javax.inject.Inject;

/**
 * Profile
 */
public class ProfileFragment extends XBaseFragment<GitHub, ContractProfile.IPresenterProfile>
    implements ProfileView, HasComponent<ComponentProfile> {

  @Inject protected PresenterProfile mPresenterProfile;

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.icon) ImageView mIcon;
  @BindView(R.id.bg) ImageView mBg;
  @BindView(R.id.name) TextView mName;
  @BindView(R.id.layout_user) LinearLayout mLayoutUser;
  @BindView(R.id.header) RelativeLayout mHeader;
  @BindView(R.id.title) TextView mTitleView;
  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

  private GitHub mGitHub;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mPresenterProfile.attachView(this);
  }

  @Override public ComponentProfile getComponent() {
    return DaggerComponentProfile.builder()
        .xComponentApp(getBaseActivity().getComponentApp())
        .xModuleActivity(new XModuleActivity(getBaseActivity()))
        .build();
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, true, getResources().getColor(R.color.colorPrimary));
    if (null == mGitHub) {
      mPresenterProfile.request(getModuleAPI(), bindUntilEvent(FragmentEvent.PAUSE));
    } else {
      showContent(mGitHub);
    }
  }

  @Override protected int getContentView() {
    return R.layout.content_profile;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public void showContent(GitHub data) {
    super.showContent(data);

    mGitHub = data;
    XImage.load(getActivity(), data.getAvatar_url(), mIcon);
    mName.setText(data.getName());
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    // ViewGroup.MarginLayoutParams params =
    // (ViewGroup.MarginLayoutParams) mToolbar.getLayoutParams();
    // params.topMargin = getSystemBarConfig().getStatusBarHeight();
    // mToolbar.setLayoutParams(params);
    // } else {
    // ViewGroup.LayoutParams params = getStatusBar().getLayoutParams();
    // params.height = getSystemBarConfig().getStatusBarHeight();
    // getStatusBar().setLayoutParams(params);
    // }

    mToolbar.setVisibility(View.VISIBLE);
    ViewGroup.LayoutParams params = mToolbar.getLayoutParams();
    params.height += getAndroidBarConfig().getStatusBarHeight();
    mToolbar.setLayoutParams(params);
    mToolbar.setPadding(0, mToolbar.getPaddingTop() + getAndroidBarConfig().getStatusBarHeight(), 0,
        0);
    mLayoutUser.setPadding(0,
        mLayoutUser.getPaddingTop() + getAndroidBarConfig().getStatusBarHeight(), 0, 0);

    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    mRecyclerView.setAdapter(new ProfileAdapter());
  }

  @Override public void onDestroy() {
    mPresenterProfile.detachView();
    super.onDestroy();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @OnClick({}) void onClick(View view) {

  }
}
