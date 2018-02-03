package dessert.foodie.miracles.com.foodiedessert.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import dessert.foodie.miracles.com.foodiedessert.constant.Constants;
import dessert.foodie.miracles.com.foodiedessert.utils.PreferencesUtils;
import dessert.foodie.miracles.com.foodiedessert.R;
import dessert.foodie.miracles.com.foodiedessert.bean.UserDataBean;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.login_userName_edit)
    EditText loginUserNameEdit;//用户名
    @Bind(R.id.login_password_edit)
    EditText loginPasswordEdit;//用户密码
    @Bind(R.id.login_button)
    Button loginButton;//登陆

    private String userName, password;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext = this;

    }

    //初始化
    @OnClick(R.id.login_button)
    public void login() {
        userName = loginUserNameEdit.getText().toString();
        password = loginPasswordEdit.getText().toString();

        BmobQuery<UserDataBean> query = new BmobQuery();
        query.addWhereEqualTo("phone", userName);
        query.findObjects(new FindListener<UserDataBean>() {
            @Override
            public void done(List<UserDataBean> list, BmobException e) {
                if (e == null && list.size() > 0) {
                    UserDataBean bean = list.get(0);
                    userName = bean.getUserName();
                    if (bean.getPassword().equals(password)) {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        PreferencesUtils.putString(mContext, Constants.USERNAME, userName);
                        PreferencesUtils.putString(mContext, Constants.USERNAME, password);
                        Intent loginIntent = new Intent(mContext, HomeActivity.class);
                        startActivity(loginIntent);
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
