package com.app.huangsuixin1506101066.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.huangsuixin1506101066.R;


/**
 * @author Silence
 */
public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText username, password;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        initViews();

        initListeners();
    }


    /** 初始化UI组件 */
    private void initViews() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    /** 注册监听事件 */
    private void initListeners() {

        // 点击登录后 回到main activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }


}
