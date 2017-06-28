package com.hayukleung.x.demo.databinding.demo5;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo52Binding;

public class Demo52Activity extends AppCompatActivity {

    private ActivityDemo52Binding mBinding;
    private int mCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo52);
        Demo52 demo52 = new Demo52();
        demo52.name.set("demo 52 before");
        mBinding.setDemo52(demo52);
    }

    public void onClickDemo52(View view) {
        mCount++;
        mBinding.getDemo52().name.set("demo 52 after " + mCount);
    }
}
