package com.jia.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_name;

    private EditText et_pwd;

    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name= (EditText) findViewById(R.id.et_name);

        et_pwd= (EditText) findViewById(R.id.et_pwd);

        bt_login= (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bt_login){

            login();

        }
    }

    /**
     * 去登录
     */
    private void login() {



    }
}
