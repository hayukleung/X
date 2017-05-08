package com.hayukleung.x.demo.dagger2.demo1;

import android.content.Context;
import android.widget.Toast;
import javax.inject.Inject;

public class Something {

  // step 2
  @Inject public Something() {
  }

  public void doSomething(Context context) {
    Toast.makeText(context.getApplicationContext(), "do something 1 ...", Toast.LENGTH_SHORT).show();
  }
}
