package com.hayukleung.x.demo.model;

import android.content.Context;
import android.widget.Toast;
import javax.inject.Inject;

public class Something {

  private String mContent;

  // step 2
  @Inject public Something(String content) {
    mContent = content;
  }

  public void doSomething(Context context) {
    Toast.makeText(context.getApplicationContext(), mContent, Toast.LENGTH_SHORT).show();
  }
}
