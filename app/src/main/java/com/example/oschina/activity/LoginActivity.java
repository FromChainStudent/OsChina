package com.example.oschina.activity;

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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class LoginActivity extends Activity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
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
                if (name.isEmpty()||pwd.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    String url = "http://www.oschina.net/action/api/login_validate";
                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    requestQueue.add(stringRequest);
                }
                break;
            case R.id.login_btn_register:
                break;
        }
    }
}
