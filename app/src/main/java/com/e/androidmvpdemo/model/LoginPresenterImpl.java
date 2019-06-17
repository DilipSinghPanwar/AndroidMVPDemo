package com.e.androidmvpdemo.model;

import com.e.androidmvpdemo.presenter.LoginPresenter;
import com.e.androidmvpdemo.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLoginClicked(String login, String password) {
        if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            loginView.loginSuccess();
        } else if (login.length() <= 0) {
            loginView.loginUserNameEmpty();
        } else if (password.length() <= 0) {
            loginView.loginPasswordEmpty();
        } else {
            loginView.loginFailure();
        }
    }
}