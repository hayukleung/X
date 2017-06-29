package com.hayukleung.x.demo.databinding.demo6;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo6Binding;

/**
 * X
 * com.hayukleung.x.demo.databinding.demo6
 * Demo6Activity.java
 * <p>
 * by hayukleung
 * at 2017-06-29 13:53
 */

public class Demo6Activity extends AppCompatActivity {

    private ActivityDemo6Binding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo6);
    }
}
