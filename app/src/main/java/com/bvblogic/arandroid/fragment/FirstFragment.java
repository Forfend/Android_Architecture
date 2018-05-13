package com.bvblogic.arandroid.fragment;

import android.widget.Toast;

import com.bvblogic.arandroid.R;
import com.bvblogic.arandroid.bean.ProviderBeanUser;
import com.bvblogic.arandroid.bean.UserBeanPresenter;
import com.bvblogic.arandroid.fragment.core.BaseFragment;
import com.bvblogic.arandroid.navigator.core.ResourceManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Forfend on 24.03.2018.
 */

@EFragment(R.layout.fragment_first)
public class FirstFragment extends BaseFragment {

    @Bean
    UserBeanPresenter userBeanPresenter;

    @Bean
    ProviderBeanUser providerBeanUser;

    @Override
    public void backPressed() {
        Toast.makeText(getBaseActivity(), "Oleh", Toast.LENGTH_SHORT).show();
    }

    @AfterViews
    public void initToolbar() {
        navigatorManager.getMainManager(this)
                .initToolbar(ResourceManager.ToolbarId.SIMPLE, R.string.app_name);
    }

}
