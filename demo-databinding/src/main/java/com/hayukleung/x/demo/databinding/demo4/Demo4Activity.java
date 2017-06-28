package com.hayukleung.x.demo.databinding.demo4;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo4Binding;

public class Demo4Activity extends AppCompatActivity {

    private ActivityDemo4Binding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo4);
        Demo4 demo4 = new Demo4();
        demo4.setVisible(true);
        mBinding.setDemo4(demo4);
    }

    public void onClickDemo4(View view) {
        boolean visible = mBinding.getDemo4().isVisible();
        mBinding.getDemo4().setVisible(!visible);
        mBinding.setDemo4(mBinding.getDemo4());
    }
}
