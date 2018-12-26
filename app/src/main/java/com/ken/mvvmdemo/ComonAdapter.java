package com.ken.mvvmdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Create by zqf 2018/12/25
 * class desc
 */
public class ComonAdapter<T> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public ComonAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.variableId = variableId;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding viewDataBinding;
        if (convertView == null) {
            viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        } else {
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }
        //数据部分
        viewDataBinding.setVariable(variableId, list.get(position));
        return viewDataBinding.getRoot().getRootView();
    }
}
