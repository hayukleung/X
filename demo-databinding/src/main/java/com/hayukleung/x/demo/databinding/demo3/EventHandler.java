package com.hayukleung.x.demo.databinding.demo3;

import android.content.Context;
import android.widget.Toast;

public class EventHandler {

    private Context mContext;

    public EventHandler(Context context) {
        mContext = context;
    }

    public void onClickDemo3(Param param) {
        Toast.makeText(mContext, param.getText(), Toast.LENGTH_SHORT).show();
    }
}

