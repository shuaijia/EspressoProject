package com.jia.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;

    private EditText et_pwd;

    private Button bt_login;

    private TextView tv_login_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);

        et_pwd = (EditText) findViewById(R.id.et_pwd);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);

        tv_login_result = (TextView) findViewById(R.id.tv_login_result);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_login) {

            login();

        }
    }

    /**
     * 去登录
     */
    private void login() {

        String name = et_name.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            tv_login_result.setText("用户名为空");
            return;
        }

        if (name.length() < 6 ) {
            tv_login_result.setText("用户名格式错误");
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            tv_login_result.setText("密码为空");
            return;
        }

        if (pwd.length() < 6 ) {
            tv_login_result.setText("密码格式错误");
            return;
        }

        tv_login_result.setText("登录成功");
    }
}
