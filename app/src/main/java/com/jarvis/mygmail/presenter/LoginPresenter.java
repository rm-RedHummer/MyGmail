package com.jarvis.mygmail.presenter;

import com.jarvis.mygmail.model.User;

/**
 * Created by Jarvis on 10/10/2018.
 */

public class LoginPresenter {

    public void login(String username, String password){

    }

    public interface loginPresenterCallback {
        void onLogin(User user);
        void onLoginFailed();
    }
}
