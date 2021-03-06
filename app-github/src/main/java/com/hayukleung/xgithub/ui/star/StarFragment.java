package com.hayukleung.xgithub.ui.star;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.hayukleung.x.base.ui.UIUtils;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.common.RecyclerViewUtils;
import com.hayukleung.xgithub.contract.ContractStar.IPresenterStar;
import com.hayukleung.xgithub.model.Stub;
import com.hayukleung.xgithub.ui.XBaseFragment;
import com.hayukleung.xgithub.widget.srl.ShyaringanSwipeRefreshLayout;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.star
 * StarFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:52
 */

public class StarFragment extends XBaseFragment<Stub, IPresenterStar> implements StarView {

  @BindView(R.id.swipe_refresh_layout) ShyaringanSwipeRefreshLayout mShyaringanSwipeRefreshLayout;
  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  @BindView(R.id.toolbar) Toolbar mToolbar;

  private StarAdapter mStarAdapter;

  private int mLatestAlpha = 0;
  private int mScrolledY = 0;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, 0 != mLatestAlpha,
        getResources().getColor(R.color.colorPrimary));
  }

  @Override protected int getContentView() {
    return R.layout.content_star;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
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
    mToolbar.setBackgroundColor(Color.argb(mLatestAlpha, 255, 255, 255));

    // CustomProgressDrawable drawable = new CustomProgressDrawable(getActivity(), mSwipeRefreshLayout);
    // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moments_refresh_icon);
    // drawable.setBitmap(bitmap);
    // mSwipeRefreshLayout.setProgressView(drawable);
    mShyaringanSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    // mSwipeRefreshLayout.setProgressViewEndTarget(false, Screen.getInstance(getActivity()).dp2px(120));
    mShyaringanSwipeRefreshLayout.setOnRefreshListener(
        new ShyaringanSwipeRefreshLayout.OnRefreshListener() {
          @Override public void onRefresh() {
          }
        });

    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    mStarAdapter = new StarAdapter();
    mRecyclerView.setAdapter(mStarAdapter);
    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        mScrolledY += dy;
        int scrollY = RecyclerViewUtils.getRecyclerViewScrollY(mRecyclerView);
        int toolbarHeight = mToolbar.getHeight();
        int alpha =
            0 == toolbarHeight ? mLatestAlpha : (int) ((float) scrollY / toolbarHeight * 255);
        if (alpha > 255) alpha = 255;
        if (alpha < 0) alpha = 0;
        if (mScrolledY > mStarAdapter.getStarHeaderHeight(getActivity()) - mToolbar.getHeight()) {
          alpha = 255;
        }
        if (alpha == 0) {
          UIUtils.requestStatusBarLight(StarFragment.this, false,
              ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        } else {
          UIUtils.requestStatusBarLight(StarFragment.this, true,
              ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        }
        mToolbar.setBackgroundColor(Color.argb(alpha, 255, 255, 255));
        mLatestAlpha = alpha;
      }
    });
  }

  @OnClick({ R.id.stop }) public void onClick() {
    mShyaringanSwipeRefreshLayout.setRefreshing(false);
  }
}
