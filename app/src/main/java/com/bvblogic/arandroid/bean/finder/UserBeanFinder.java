package com.bvblogic.arandroid.bean.finder;

import com.bvblogic.arandroid.model.User;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Forfend on 31.03.2018.
 */

@EBean
public class UserBeanFinder {

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("Oleh"));
        users.add(new User("Yura"));
        users.add(new User("Petro"));
        users.add(new User("Petro676"));
        users.add(new User("Petro77"));
        users.add(new User("Petro435"));
        users.add(new User("Petro123"));
        users.add(new User("Petro34"));
        users.add(new User("Petro432"));
        users.add(new User("Petro12"));

        return users;
    }
}
