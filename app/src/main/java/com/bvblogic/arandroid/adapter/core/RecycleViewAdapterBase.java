package com.bvblogic.arandroid.adapter.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bvblogic.arandroid.activity.core.ViewWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Forfend on 31.03.2018.
 */

public abstract class RecycleViewAdapterBase<T, V extends View> extends RecyclerView.Adapter<ViewWrapper<V>> {

    List<T> items = new ArrayList<>();

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<V>(onCreateItemHolder(parent, viewType));
    }

    protected abstract V onCreateItemHolder(ViewGroup parent, int viewType);
}
