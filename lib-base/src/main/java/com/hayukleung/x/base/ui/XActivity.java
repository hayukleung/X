package com.hayukleung.x.base.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHelper;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hayukleung.x.base.R;
import com.hayukleung.x.base.common.wrapper.XLog;
import java.util.ArrayList;
import java.util.List;

public class XActivity extends BaseActivity {

  public static final String FRAGMENT_NAME = "fragment_name";
  private static final String FRAGMENT_RECORD = "fragment_record";
  protected Unbinder mUnbinder;
  private String mFragmentName;
  private ArrayList<Integer> mFragmentRecord = new ArrayList<>();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    Intent intent = getIntent();
    mFragmentName = intent.getStringExtra(FRAGMENT_NAME);
    if (mFragmentName == null) {
      try {
        ActivityInfo info =
            getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        Bundle metaData = info.metaData;
        if (metaData != null) mFragmentName = metaData.getString("fragment");
      } catch (PackageManager.NameNotFoundException ignored) {
      }
    }

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_x);
    mUnbinder = ButterKnife.bind(this);

    BaseFragment fragment =
        (BaseFragment) getSupportFragmentManager().findFragmentByTag(getFragmentTag());
    if (savedInstanceState == null) {
      if (fragment == null) {
        fragment = newFragment();
      }
      if (fragment != null) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.content, fragment, getFragmentTag())
            .commit();
      }
    }

    getComponentApp().inject(this);
  }

  @Override protected void onDestroy() {
    if (null != mUnbinder) {
      mUnbinder.unbind();
    }
    super.onDestroy();
  }

  protected String getFragmentTag() {
    return getFragmentName();
  }

  protected final BaseFragment newFragment() {
    if (TextUtils.isEmpty(getFragmentName())) {
      return null;
    }
    return (BaseFragment) Fragment.instantiate(this, getFragmentName(), getIntent().getExtras());
  }

  protected String getFragmentName() {
    return mFragmentName;
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putIntegerArrayList(FRAGMENT_RECORD, mFragmentRecord);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    mFragmentRecord = savedInstanceState.getIntegerArrayList(FRAGMENT_RECORD);
  }

  public void setFragmentRecord(Fragment fragment) {
    Fragment node = fragment;
    while (node != null) {
      int index = FragmentHelper.getIndex(node);
      if (index < 0) {
        throw new IllegalStateException("Fragment is out of FragmentManager: " + node);
      }
      mFragmentRecord.add(0, index);
      node = node.getParentFragment();
    }
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    FragmentHelper.noteStateNotSaved(this);
    List<Fragment> active = FragmentHelper.getActive(this);
    Fragment fragment = null;
    for (Integer index : mFragmentRecord) {
      if (active != null && index >= 0 && index < active.size()) {
        fragment = active.get(index);
        if (fragment == null) {
          XLog.e("Activity result no fragment exists for index: 0x" + Integer.toHexString(index));
        } else {
          active = FragmentHelper.getChildActive(fragment);
        }
      }
    }
    mFragmentRecord.clear();
    if (fragment == null) {
      super.onActivityResult(requestCode, resultCode, data);
    } else {
      fragment.onActivityResult(requestCode, resultCode, data);
    }
  }

  @Override public void onBackPressed() {
    BaseFragment fragment = getFragment();
    if (fragment == null || !fragment.onBackPressed()) {
      super.onBackPressed();
    }
  }

  /**
   * @return Find fragment by tag with {@link #getFragmentTag()}
   */
  protected final BaseFragment getFragment() {
    return (BaseFragment) getSupportFragmentManager().findFragmentByTag(getFragmentTag());
  }

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, BaseFragment fragment) {
    final FragmentTransaction fragmentTransaction =
        this.getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }
}
