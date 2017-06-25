package com.hayukleung.x.demo.vlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.hayukleung.x.demo.vlayout.R;

public class OnePlusNRecyclerAdapter extends DelegateAdapter.Adapter {

  private Context context;
  private LayoutHelper helper;
  private LayoutInflater inflater;

  public OnePlusNRecyclerAdapter(Context context, LayoutHelper helper) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
    this.helper = helper;
  }

  public LayoutHelper onCreateLayoutHelper() {
    return helper;
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MyViewHolder(inflater.inflate(R.layout.item, parent, false));
  }

  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((MyViewHolder) holder).text.setText(position + 1 + "");
    VirtualLayoutManager.LayoutParams layoutParams =
        new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
    // layoutParams.leftMargin = 10;
    // layoutParams.topMargin = 10;
    // layoutParams.rightMargin = 10;
    // layoutParams.bottomMargin = 10;
    holder.itemView.setLayoutParams(layoutParams);
  }

  public int getItemCount() {
    return 5;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public MyViewHolder(View view) {
      super(view);
      text = (TextView) view.findViewById(R.id.text);
    }
  }
}
