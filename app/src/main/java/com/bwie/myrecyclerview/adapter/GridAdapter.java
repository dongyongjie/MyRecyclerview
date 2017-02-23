package com.bwie.myrecyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.myrecyclerview.R;
import com.bwie.myrecyclerview.bean.Children2;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<Children2> list;

    public GridAdapter(Context context, List<Children2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        View view=convertView;
        if(view==null){
            view=View.inflate(context, R.layout.item3,null);
            holder=new ViewHolder();
            holder.textView= (TextView) view.findViewById(R.id.item3_textView);
            holder.imageView= (ImageView) view.findViewById(R.id.item3_imageView);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        BitmapUtils bitmapUtils=new BitmapUtils(context);
//        Log.i("TAG", "getView: "+list.size());
//        childrenBean = list.get(position);
        bitmapUtils.display(holder.imageView,list.get(position).getImgApp());
        holder.textView.setText(list.get(position).getDirName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getDirName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
