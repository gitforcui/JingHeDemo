package com.cui.hebut.jinghedemo.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cui.hebut.jinghedemo.R;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends BaseAdapter {

    private Context context;
    private List<Shop> shopList = null;

    public ShopAdapter(Context context) {
        this.context = context;
        shopList = new ArrayList<Shop>();
    }

    public void setShopData(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return shopList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return shopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.dateTime = (TextView) convertView.findViewById(R.id.dateTime);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(shopList.get(position).getName());
        holder.dateTime.setText(shopList.get(position).getRaminTime());
        //System.out.println(holder.name.getText());
        return convertView;
    }

    private class ViewHolder {
        public TextView name;
        public TextView dateTime;
    }
}
