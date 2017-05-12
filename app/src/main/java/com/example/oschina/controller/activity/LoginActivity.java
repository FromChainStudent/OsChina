package com.example.oschina.controller.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.oschina.R;
import com.example.oschina.base.BaseActivity;
import com.example.oschina.module.net.MyCallBack;
import com.example.oschina.module.net.ParsingFactory;
import com.example.oschina.utils.HttpUtils;
import com.j256.ormlite.logger.Log;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.login_back)
    ImageButton login_back;
    @Bind(R.id.login_et_phone)
    EditText login_et_phone;
    @Bind(R.id.login_et_pwd)
    EditText login_et_pwd;
    @Bind(R.id.login_tv_forget)
    TextView login_tv_forget;
    @Bind(R.id.login_btn_login)
    Button login_btn_login;
    @Bind(R.id.login_btn_register)
    Button login_btn_register;



    @Override
    protected int layoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.login_back, R.id.login_tv_forget, R.id.login_btn_login, R.id.login_btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.login_tv_forget:
                break;
            case R.id.login_btn_login:
                String name = login_et_phone.getText().toString().trim();
                String pwd = login_et_pwd.getText().toString().trim();
                Map<String, String> map = new HashMap<>();
                map.put("username", "17319422770");
                map.put("pwd", "990712..lwx");
                map.put("keep_login", "1");
                if (name.isEmpty()||pwd.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    android.util.Log.e("Http",HttpUtils.LOGIN+"");
                    ParsingFactory.initParsing().POST(HttpUtils.LOGIN, map, new MyCallBack() {
                        @Override
                        public void onSuccess(String strSuccess) {
                            Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(String strError) {
                            Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                            android.util.Log.e("yichang",strError+"");
                        }
                    });
                }
                break;
            case R.id.login_btn_register:
                Toast.makeText(this, "暂不支持此功能", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
