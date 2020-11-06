package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GiayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Giay> giayList;

    public GiayAdapter(Context context, int layout, List<Giay> giayList) {
        this.context = context;
        this.layout = layout;
        this.giayList = giayList;
    }

    @Override
    public int getCount() {
        return giayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class  ViewHolder{
        ImageView imageView;
        TextView txtten,txtgia;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.imageView=(ImageView) view.findViewById(R.id.im_hinh);
            holder.txtten=(TextView) view.findViewById(R.id.tv_ten);
            holder.txtgia=(TextView) view.findViewById(R.id.tv_gia);
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }

        Giay giay=giayList.get(i);
        holder.imageView.setImageResource(giay.getHinh());
        holder.txtten.setText(giay.getTen());
        holder.txtgia.setText(giay.getGia());

        return null;
    }
}
