package com.bvblogic.arandroid.adapter.user;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bvblogic.arandroid.R;
import com.bvblogic.arandroid.model.User;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Forfend on 31.03.2018.
 */
@EViewGroup(R.layout.item_user)
public class UserItemView extends LinearLayout {

    @ViewById(R.id.text)
    TextView textView;

    @Click(R.id.root_view)
    public void click(){
        Toast.makeText(getContext(), ((User)UserItemView.this.getTag()).getName(), Toast.LENGTH_SHORT).show();
    }


    public UserItemView(Context context) {
        super(context);
        this.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
        );
    }

    public void bind(User user){
        textView.setText(user.getName());
    }


}
