package com.hayukleung.x.demo.vlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.hayukleung.x.demo.vlayout.R;

public class FloatAdapter extends DelegateAdapter.Adapter {

  private Context context;
  private LayoutHelper helper;
  private LayoutInflater inflater;

  public FloatAdapter(Context context, LayoutHelper helper) {
    this.context = context;
    this.helper = helper;
    this.inflater = LayoutInflater.from(context);
  }

  @Override public LayoutHelper onCreateLayoutHelper() {
    return helper;
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MyViewHolder(inflater.inflate(R.layout.image, parent, false));
  }

  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
  }

  public int getItemCount() {
    return 1;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView img;

    public MyViewHolder(View view) {
      super(view);
      img = (ImageView) view.findViewById(R.id.img);
    }
  }
}
