package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Domain.UserInfo;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginView extends RecyclerView.ViewHolder implements View.OnClickListener {

    @InjectView(R.id.dl_user_login_username)
    EditText dlUserLoginUsername;
    @InjectView(R.id.dl_user_login_password)
    EditText dlUserLoginPassword;

    @InjectView(R.id.dl_user_login_regist)
    Button dlUserLoginRegist;
    @InjectView(R.id.dl_user_login)
    Button dlUserLogin;

    private Context context;
    private View rootView;

    public LoginView(Context context) {
        this(View.inflate(context, R.layout.login_activity, null), context);
    }

    public LoginView(View view, Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.rootView = view;
        this.context = context;
        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));


        dlUserLoginRegist.setOnClickListener(this);
        dlUserLogin.setOnClickListener(this);
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }


    public Button getDlUserLogin() {
        return dlUserLogin;
    }

    public EditText getDlUserLoginUsername() {
        return dlUserLoginUsername;
    }

    public EditText getDlUserLoginPassword() {
        return dlUserLoginPassword;
    }

    public Button getDlUserLoginRegist() {
        return dlUserLoginRegist;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.dl_user_login_regist: // 注册按钮

                MiddleViewManager.getInstance().changeView(ConstantValue.REGISTER_VIEW);
                break;

            case R.id.dl_user_login:   //登录按钮

                String userName=dlUserLoginUsername.getText().toString();
                String passWord=dlUserLoginPassword.getText().toString();

                if(TextUtils.isEmpty(userName)) {
                    Toast.makeText(context, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passWord)) {
                    Toast.makeText(context, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                NetUtils.getJson(ConstantValue.LOGIN+"?name=" + userName + "&pass=" + passWord, new NetUtils.NetAccessListener() {
                    @Override
                    public void onSeccuss(String json) {
                        if (json != null && !"".equals(json)) {
                            Gson gson = new Gson();
                            UserInfo userInfo = gson.fromJson(json, UserInfo.class);

                            SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
                            sp.edit().putString("currentUser",json).commit();

                            Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show();
                            MiddleViewManager.getInstance().changeView(ConstantValue.ACCOUNT_VIEW);
                        } else {
                            Toast.makeText(context, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });


                break;
        }

    }
}
