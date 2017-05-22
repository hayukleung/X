package com.hayukleung.x.demo.video.demo4;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hayukleung.x.demo.video.R;

public abstract class BaseActivity extends AppCompatActivity {

  private AlertDialog dialog;

  public TextView showDialog() {

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setCancelable(false);
    View view = View.inflate(this, R.layout.dialog_loading, null);
    builder.setView(view);
    ProgressBar pbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
    TextView tvHint = (TextView) view.findViewById(R.id.tv_hint);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      pbLoading.setIndeterminateTintList(
          ContextCompat.getColorStateList(this, R.color.color_dialog));
    }
    tvHint.setText("视频编译中");

    dismissDialog();

    dialog = builder.create();
    dialog.show();

    return tvHint;
  }

  public void dismissDialog() {

    try {
      if (null != dialog) {
        dialog.dismiss();
        dialog = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
