package dessert.foodie.miracles.com.foodiedessert.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import dessert.foodie.miracles.com.foodiedessert.utils.IsFormatUtils;
import dessert.foodie.miracles.com.foodiedessert.R;
import dessert.foodie.miracles.com.foodiedessert.bean.UserDataBean;


public class RegisterActivity extends BaseActivity {
    @Bind(R.id.register_userNaem_edit)
    EditText registerUserNaemEdit;//用户名
    @Bind(R.id.register_password_edit)
    EditText registerPasswordEdit;//用户密码
    @Bind(R.id.register_email_edit)
    EditText registerEmailEdit;//邮箱
    @Bind(R.id.register_phone_edit)
    EditText registerPhoneEdit;//电话
    @Bind(R.id.register_age_edit)
    EditText registerAgeEdit;//年龄
    @Bind(R.id.register_city_edit)
    EditText registerCityEdit;//地区
    @Bind(R.id.register_male_radio)
    RadioButton registerMaleRadio;//男
    @Bind(R.id.register_woman_radio)
    RadioButton registerWomanRadio;//女
    @Bind(R.id.register_comfirm_button)
    Button registerComfirmButton;//确认注册
    @Bind(R.id.register_radioGroup)
    RadioGroup registerRadioGroup;

    private boolean gender;//性别
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private String phone;//手机
    private String age;//年龄
    private String city;//地区
    private UserDataBean userDataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initGender();


    }


    /**
     * 初始化数据
     */
    private void initData() {

    }


    /**
     * 性别设置
     */
    public void initGender() {
        registerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.register_male_radio://男
                        gender = true;
                        break;
                    case R.id.register_woman_radio://女
                        gender = false;
                        break;
                }
            }
        });

    }


    //注册
    @OnClick(R.id.register_comfirm_button)
    public void register() {
        username = registerUserNaemEdit.getText().toString().trim();
        password = registerPasswordEdit.getText().toString().trim();
        email = registerEmailEdit.getText().toString().trim();
        phone = registerPhoneEdit.getText().toString().trim();
        age = registerAgeEdit.getText().toString().trim();
        city = registerCityEdit.getText().toString().trim();

        userDataBean = new UserDataBean();
        userDataBean.setUserName(username);
        userDataBean.setPassword(password);
        userDataBean.setEmail(email);
        userDataBean.setPhone(phone);
        userDataBean.setAge(age);
        userDataBean.setCity(city);

        if (gender == false) {
            userDataBean.setGender("女");
        } else {
            userDataBean.setGender("男");
        }

        if (TextUtils.isEmpty(username) ||
                TextUtils.isEmpty(password) ||
                TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(phone) ||
                TextUtils.isEmpty(age) ||
                TextUtils.isEmpty(city) &
                        registerWomanRadio.isChecked() == false |
                        registerMaleRadio.isChecked() == false

                ) {//数据未填写完整
            Toast.makeText(this, "请输入完整", Toast.LENGTH_SHORT).show();
            return;
        } else if (!IsFormatUtils.isEmail(email) && !IsFormatUtils.isNumeric(email)) {
            Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
            return;
        } else if (!IsFormatUtils.isMobileNO(phone) && !IsFormatUtils.isNumeric(phone)||phone.length()!=11) {
            Toast.makeText(this, "手机格式不正确", Toast.LENGTH_SHORT).show();
            return;
        } else if (!IsFormatUtils.isLetterOrDigit(password)||password.length()<6) {
            Toast.makeText(this, "密码至少包含大小写字母及数字6位长度", Toast.LENGTH_LONG).show();
            return;
        } else {
            userDataBean.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败(" + "该手机已被注册" + ")", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }


    }


}
