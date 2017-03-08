package com.example.gridview.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhu_lin on 2017/2/27.
 */

public abstract class CustomAdapter<T> extends BaseAdapter {

    private ArrayList<T> mData;
    private int mLayoutRes;           //布局id

    public CustomAdapter(){}

    public CustomAdapter(ArrayList<T> mData, int mLayoutRes){
        this.mData = mData;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.bind(viewGroup.getContext(), convertView, viewGroup, mLayoutRes, position);
        bindView(holder, getItem(position));
        return holder.getItemView();
    }

    //添加一条数据
    public void add(T data){
        if(mData == null){
            mData = new ArrayList<T>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    //在固定位置添加数据
    public void add(int position, T data){
        if(mData == null){
            mData = new ArrayList<T>();
        }
        mData.add(position, data);
        notifyDataSetChanged();
    }

    //依据对象删除数据
    public void delete(T data){
        if(mData != null){
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    //删除选中项
    public void delete(int position){
        if(mData != null){
            mData.remove(position);
        }
        notifyDataSetChanged();
    }

    //清除所有数据
    public void clear(){
        if(mData != null){
            mData.clear();
        }
        notifyDataSetChanged();
    }

    //4、ViewHolder与Data数据集的绑定
    public abstract void bindView(ViewHolder holder, T obj);

    public static class ViewHolder {
        private SparseArray<View> mViews;   //存储ListView 的 item中的View
        private View item;                  //存放convertView
        private int position;              //游标
        private Context context;            //Context上下文

        //1、构造函数，初始化时拿到convertView
        private ViewHolder(Context context,ViewGroup viewGroup, int layoutRes){
            mViews = new SparseArray<>();
            this.context = context;
            View convertView = LayoutInflater.from(context).inflate(layoutRes, viewGroup, false);
            convertView.setTag(this);
            item = convertView;
        }

        //2、绑定ViewHolder与item(convertView)
        public static ViewHolder bind(Context context, View convertView, ViewGroup viewGroup, int layoutRes, int position){
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder(context, viewGroup, layoutRes);
            }else {
                holder = (ViewHolder) convertView.getTag();
                holder.item = convertView;
            }
            holder.position = position;
            return holder;
        }

        //3、根据id获取集合中保存的控件（findViewById）
        public <T extends View>T getView(int id){
            T t = (T) mViews.get(id);
            if(t == null){
                t = (T) item.findViewById(id);
                mViews.put(id,t);
            }
            return t;
        }

        /**
         * 获取当前条目
         */
        public View getItemView() {
            return item;
        }

        /**
         * 获取条目位置
         */
        public int getItemPosition() {
            return position;
        }

        /**
         * 设置文字
         */
        public ViewHolder setText(int id, CharSequence text){
            View view = getView(id);
            if(view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        /**
         * 设置图片
         */
        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if(view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }

        /**
         * 设置点击监听
         */
        public ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         */
        public ViewHolder setVisibility(int id, int visible) {
            getView(id).setVisibility(visible);
            return this;
        }

        /**
         * 设置标签
         */
        public ViewHolder setTag(int id, Object obj) {
            getView(id).setTag(obj);
            return this;
        }

        //扩展项。。。

    }


}
