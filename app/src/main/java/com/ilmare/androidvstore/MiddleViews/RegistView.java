package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegistView extends RecyclerView.ViewHolder {

    @InjectView(R.id.regist_name_edit)
    EditText registNameEdit;
    @InjectView(R.id.regist_pwd_edit)
    EditText registPwdEdit;
    @InjectView(R.id.regist_qrpwd_edit)
    EditText registQrpwdEdit;
    @InjectView(R.id.regist_tel)
    EditText registTel;
    @InjectView(R.id.regist_addr)
    EditText registAddr;
    @InjectView(R.id.zzregist_text)
    TextView zzregistText;

    Context context;
    View rootView;

    public RegistView(Context context) {
        this(View.inflate(context, R.layout.regist_activity, null), context);
    }

    public RegistView(View view, Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.context = context;
        this.rootView = view;

        register();

    }

    //注册
    private void register() {


        zzregistText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userName = registNameEdit.getText().toString();
                String password = registPwdEdit.getText().toString();
                String confirmPassword = registQrpwdEdit.getText().toString();
                String tel = registTel.getText().toString();
                String address = registAddr.getText().toString();

                System.out.println(password);
                System.out.println(confirmPassword);

                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(context, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(context, "确认密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(context, "地址不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(tel)) {
                    Toast.makeText(context, "电话不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.equals(password, confirmPassword)) {
                    Toast.makeText(context, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }


                String url = ConstantValue.BASEURL + "cusRegisterManage_cusRegister.action?cusName=" + userName + "&cusPasswd=" + password + "&tel=" + tel
                        + "&cusAddress=" + address;
                System.out.println(url);


                NetUtils.getJson(url, new NetUtils.NetAccessListener() {
                    @Override
                    public void onSeccuss(String json) {

                        if ("EXIST".equals(json)) {
                            Toast.makeText(context, "用户已存在", Toast.LENGTH_SHORT).show();
                        }else if("SUCCESS".equals(json)){
                            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });

            }
        });
    }


    public View getRootView() {
        return rootView;
    }


}
