package com.hayukleung.x.demo.vlayout;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.hayukleung.x.demo.vlayout.activity.ColumnLayoutHelperActivity_;
import com.hayukleung.x.demo.vlayout.activity.DelegateActivity_;
import com.hayukleung.x.demo.vlayout.activity.FixLayoutActivity_;
import com.hayukleung.x.demo.vlayout.activity.FloatLayoutHelperActivity_;
import com.hayukleung.x.demo.vlayout.activity.GridLayoutHelpActivity_;
import com.hayukleung.x.demo.vlayout.activity.OnePlusNLayoutHelperActivity_;
import com.hayukleung.x.demo.vlayout.activity.ScrollFixLayoutActivity_;
import com.hayukleung.x.demo.vlayout.activity.SingleLayoutHelperActivity_;
import com.hayukleung.x.demo.vlayout.activity.StaggeredGridLayoutHelperActivity_;
import com.hayukleung.x.demo.vlayout.activity.StickyLayoutActivity_;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main) public class MainActivity extends AppCompatActivity {

  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.linearlayouthelper:
        DelegateActivity_.intent(this).start();
        break;
      case R.id.gridlayouthelper:
        GridLayoutHelpActivity_.intent(this).start();
        break;
      case R.id.staggeredgridlayouthelper:
        StaggeredGridLayoutHelperActivity_.intent(this).start();
        break;
      case R.id.fixlayouthelper:
        FixLayoutActivity_.intent(this).start();
        break;
      case R.id.scrollfixlayouthelper:
        ScrollFixLayoutActivity_.intent(this).start();
        break;
      case R.id.columnlayouthelper:
        ColumnLayoutHelperActivity_.intent(this).start();
        break;
      case R.id.singlelayouthelper:
        SingleLayoutHelperActivity_.intent(this).start();
        break;
      case R.id.oneplusnlayouthelper:
        OnePlusNLayoutHelperActivity_.intent(this).start();
        break;
      case R.id.floatlayouthelper:
        FloatLayoutHelperActivity_.intent(this).start();
        break;
      case R.id.stickylayouthelper:
        StickyLayoutActivity_.intent(this).start();
    }
  }
}
