package com.hayukleung.x.demo.vlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.hayukleung.x.demo.vlayout.R;

public class StaggeredAdapter extends DelegateAdapter.Adapter {

  private Context context;
  private LayoutHelper helper;
  private LayoutInflater inflater;

  public StaggeredAdapter(Context context, LayoutHelper helper) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
    this.helper = helper;
  }

  public LayoutHelper onCreateLayoutHelper() {
    return helper;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MyViewHolder(inflater.inflate(R.layout.item, parent, false));
  }

  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ViewGroup.LayoutParams layoutParams = ((MyViewHolder) holder).text.getLayoutParams();
    layoutParams.height = 260 + position % 7 * 20;
    ((MyViewHolder) holder).text.setLayoutParams(layoutParams);
    ((MyViewHolder) holder).text.setText(position + 1 + "");
  }

  public int getItemCount() {
    return 60;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public MyViewHolder(View view) {
      super(view);
      text = (TextView) view.findViewById(R.id.text);
    }
  }
}
