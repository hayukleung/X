package com.hayukleung.x.demo.databinding.demo2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * X
 * com.hayukleung.x.demo.databinding.demo2
 * EventHandler.java
 * <p>
 * by hayukleung
 * at 2017-06-27 21:09
 */

public class EventHandler {

    private Context mContext;

    public EventHandler(Context context) {
        mContext = context;
    }

    public void onClickDemo2(View view) {
        Toast.makeText(mContext, "demo 2 event", Toast.LENGTH_SHORT).show();
    }
}

