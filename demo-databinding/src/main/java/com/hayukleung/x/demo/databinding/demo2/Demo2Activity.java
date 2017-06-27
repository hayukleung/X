package com.hayukleung.x.demo.databinding.demo2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo2Binding;

/**
 * X
 * com.hayukleung.x.demo.databinding
 * Demo1Activity.java
 * <p>
 * by hayukleung
 * at 2017-06-27 18:29
 */

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemo2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_demo2);
        binding.setHandler(new EventHandler(this));
    }
}
