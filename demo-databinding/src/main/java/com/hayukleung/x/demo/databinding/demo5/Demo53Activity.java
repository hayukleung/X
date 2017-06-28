package com.hayukleung.x.demo.databinding.demo5;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hayukleung.x.demo.databinding.R;
import com.hayukleung.x.demo.databinding.databinding.ActivityDemo53Binding;

public class Demo53Activity extends AppCompatActivity {

    private ActivityDemo53Binding mBinding;
    private int mCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo53);
        final ObservableMap<String, String> map = new ObservableArrayMap<>();
        map.put("param", "demo 53 before");
        mBinding.setDemo53(map);
    }

    public void onClickDemo53(View view) {
        mCount++;
        mBinding.getDemo53().put("param", "demo 53 after " + mCount);
    }
}
