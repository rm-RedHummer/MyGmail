package com.jarvis.mygmail.presenter;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.jarvis.mygmail.MainActivity;
import com.jarvis.mygmail.model.User;

/**
 * Created by Jarvis on 10/10/2018.
 */

public class LoginPresenter {

    private LoginPresenterCallback loginPresenterCallback;


    public void login(Task<GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            loginPresenterCallback.onLogin();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Google Login Error", "signInResult:failed code=" + e.getStatusCode()+e.getMessage());
            //updateUI(null);
            loginPresenterCallback.onLoginFailed();
        }
    }



    public interface LoginPresenterCallback {
        void onLogin();
        void onLoginFailed();
    }

    public LoginPresenterCallback getLoginPresenterCallback() {
        return loginPresenterCallback;
    }

    public void setLoginPresenterCallback(LoginPresenterCallback loginPresenterCallback) {
        this.loginPresenterCallback = loginPresenterCallback;
    }
}
