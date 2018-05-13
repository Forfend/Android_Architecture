package com.bvblogic.arandroid.fragment.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bvblogic.arandroid.R;
import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.activity.core.OnBackPressedListener;
import com.bvblogic.arandroid.navigator.NavigatorManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import io.reactivex.functions.Consumer;


/**
 * Created by Forfend on 24.03.2018.
 */

@EFragment
public abstract class BaseFragment extends Fragment implements OnBackPressedListener {

    @Bean
    protected NavigatorManager navigatorManager;

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.toolbarContainer)
    protected RelativeLayout toolbarContainer;

    public void clickToolbar(){
        Toast.makeText(getActivity(), "1234567890", Toast.LENGTH_SHORT).show();
    }

    private Consumer<String> onNextAction = s-> backPressed();

    public RelativeLayout getToolbarContainer() {
        return toolbarContainer;
    }

    @Override
    public void backPressed() {
        getActivity().finish();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToActivity();
    }

    protected void onAttachToActivity(){
        getBaseActivity().setBackPressedListener(onNextAction);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onAttachToActivity();
    }

    @Override
    public void onDetach() {
        getBaseActivity().removeBackPressedListener(onNextAction);
        super.onDetach();
    }

    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}
