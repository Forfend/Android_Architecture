package com.bvblogic.arandroid.activity.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Forfend on 31.03.2018.
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder{

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
