package com.hayukleung.x.base.common;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * RecyclerView 相关方法
 */
public class RecyclerViewUtils {

  /**
   * 获取RecyclerView垂直方向移动的距离
   *
   * @param recyclerView RecyclerView
   * @return 距离px
   */
  public static int getRecyclerViewScrollY(RecyclerView recyclerView) {
    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    int position = layoutManager.findFirstVisibleItemPosition();
    View firstVisibleChildView = layoutManager.findViewByPosition(position);
    int itemHeight = firstVisibleChildView.getHeight();
    return (position) * itemHeight - firstVisibleChildView.getTop();
  }

  public static void stopRefresh(SwipeRefreshLayout refreshLayout) {
    if (refreshLayout != null && refreshLayout.isRefreshing()) {
      refreshLayout.setRefreshing(false);
    }
  }
}
