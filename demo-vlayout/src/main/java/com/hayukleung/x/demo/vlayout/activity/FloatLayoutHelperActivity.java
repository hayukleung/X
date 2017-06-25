package com.hayukleung.x.demo.vlayout.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.hayukleung.x.demo.vlayout.R;
import com.hayukleung.x.demo.vlayout.adapter.DelegateRecyclerAdapter;
import com.hayukleung.x.demo.vlayout.adapter.FloatAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.recycler) public class FloatLayoutHelperActivity extends Activity {
  @ViewById RecyclerView recycler;

  @AfterViews void afterviews() {
    VirtualLayoutManager manager = new VirtualLayoutManager(this);
    recycler.setLayoutManager(manager);
    DelegateAdapter adapter = new DelegateAdapter(manager, true);
    adapter.addAdapter(new FloatAdapter(this, new FloatLayoutHelper()));
    adapter.addAdapter(new DelegateRecyclerAdapter(this, new LinearLayoutHelper()));
    recycler.setAdapter(adapter);
  }
}
