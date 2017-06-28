package com.hayukleung.x.demo.databinding.demo5;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo5Binding;

public class Demo5Activity extends AppCompatActivity {

    private ActivityDemo5Binding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo5);
        Demo5 demo5 = new Demo5();
        demo5.setName("demo 5 before");
        mBinding.setDemo5(demo5);
    }

    public void onClickDemo5(View view) {
        mBinding.getDemo5().setName("demo 5 after");
    }
}
