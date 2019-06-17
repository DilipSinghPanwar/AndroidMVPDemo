package com.e.androidmvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.androidmvpdemo.model.LoginPresenterImpl;
import com.e.androidmvpdemo.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenterImpl loginPresenter;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginPresenterImpl(this);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName, strPassword;
                strUserName = etEmail.getText().toString();
                strPassword = etPassword.getText().toString();
                loginPresenter.onLoginClicked(strUserName, strPassword);
            }
        });
    }

    @Override
    public void loginUserNameEmpty() {
        Toast.makeText(this, "Please enter user name", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginPasswordEmpty() {
        Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
    }
}
