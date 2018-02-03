package dessert.foodie.miracles.com.foodiedessert.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

/**
 *
 * 用户注册数据存储
 * 作者邮箱:zeng_huanmu@163.com
 * Created by Shinelon on 2018/2/1.
 */

public class UserDataBean extends BmobObject implements Serializable {
    private String userName;//用户名
    private String password;//密码
    private String phone;//手机
    private String email;//邮箱
    private String gender;//性别
    private String age;//年龄
    private String city;//地区

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
