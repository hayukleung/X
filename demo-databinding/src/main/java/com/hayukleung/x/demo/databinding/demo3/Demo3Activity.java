package com.hayukleung.x.demo.databinding.demo3;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo3Binding;

/**
 * X
 * com.hayukleung.x.demo.databinding
 * Demo1Activity.java
 * <p>
 * by hayukleung
 * at 2017-06-27 18:29
 */

public class Demo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemo3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_demo3);
        binding.setHandler(new EventHandler(this));
        Param param = new Param();
        param.setText("demo 3 event");
        binding.setParam(param);
    }
}
