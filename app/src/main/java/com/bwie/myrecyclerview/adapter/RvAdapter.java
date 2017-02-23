package com.bwie.myrecyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwie.myrecyclerview.R;
import com.bwie.myrecyclerview.bean.Rs;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/9.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private Context context;
    private List<Rs> datas;
    private List<Boolean> isClicks;

    /**
     * item的点击事件的长按事件接口
     */
    private OnItemClickListener onItemClickListener;
    /**
     * 瀑布流时的item随机高度
     */
    private List<Integer> heights = new ArrayList<>();

    /**
     * 不同的类型设置item不同的高度
     *
     * @param type
     */

    private int type = 0;

    public RvAdapter(Context context, List<Rs> datas) {
        super();
        this.context = context;
        this.datas = datas;
//        for (int i : datas) {
//            int height = (int) (Math.random() * 100 + 300);
//            heights.add(height);
//        }
        isClicks = new ArrayList<>();
        for(int i = 0;i<datas.size();i++){

            if(i==0){
                isClicks.add(true);
            }else {
                isClicks.add(false);
            }
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 设置点击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(contentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        RecyclerView.LayoutParams layoutParams;
        if (type == 0) {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (type == 1) {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heights.get(position));
            layoutParams.setMargins(2, 2, 2, 2);
        }
        holder.itemView.setLayoutParams(layoutParams);
//        holder.imageView.setImageResource(datas.get(position));
        holder.tv.setText(datas.get(position).getDirName());
        if(isClicks.get(position)){
            holder.itemView.setBackgroundColor(Color.WHITE);
        }else{
            holder.itemView.setBackgroundResource(R.color.hui);
        }
        /**设置item点击监听**/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    for(int i = 0; i <isClicks.size();i++){
                        isClicks.set(i,false);
                    }
                    isClicks.set(position,true);
                    notifyDataSetChanged();
                    onItemClickListener.onItemClickListener(holder.itemView, position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    /**
     * 用于缓存的ViewHolder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView;
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.recyclerView_TextView);
            tv = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    /**
     * 设置item监听的接口
     */
    public static interface OnItemClickListener {
        void onItemClickListener(View viewHolder, int pos);

    }

}
