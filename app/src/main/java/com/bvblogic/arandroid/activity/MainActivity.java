package com.bvblogic.arandroid.activity;

import android.view.Window;

import com.bvblogic.arandroid.R;
import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.navigator.NavigatorManager;
import com.bvblogic.arandroid.navigator.core.ResourceManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature({Window.FEATURE_NO_TITLE})
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Bean
    public NavigatorManager navigatorManager;

    @AfterViews
    public void initView(){
        navigatorManager
                .getMainManager(null)
                .moveFragmentTo(ResourceManager.FragmentId.FIRST_FRAGMENT);
    }

}
