package com.hayukleung.x.demo.databinding.demo5;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hayukleung.x.demo.databinding.BR;

/**
 * X
 * com.hayukleung.x.demo.databinding.demo5
 * Demo5.java
 * <p>
 * by hayukleung
 * at 2017-06-28 10:34
 */

public class Demo5 extends BaseObservable {

    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
