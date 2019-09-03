package com.bawei.lixinzhoukao.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lixinzhoukao.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<Bean.BeanData> data;
    Context context;

    public ListAdapter(List<Bean.BeanData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (holder==null){
            view=View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.name=view.findViewById(R.id.name);
            holder.price=view.findViewById(R.id.price);
            holder.img=view.findViewById(R.id.img);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.name.setText(data.get(position).getGoods_name());
        holder.price.setText(data.get(position).getCurrency_price());
        Glide.with(context).load(data.get(position).getGoods_thumb()).into(holder.img);
        return view;
    }
    class ViewHolder{
        ImageView img;
        TextView name;
        TextView price;
    }
}
