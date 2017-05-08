package com.hayukleung.x.demo.dagger2.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;

public class DemoActivity extends AppCompatActivity {

  // step 1
  @Inject protected Something mSomething;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // step 4
    DaggerDemoComponent.builder().build().inject(this);

    // step 5
    mSomething.doSomething(this);
  }
}
