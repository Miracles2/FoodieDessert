package dessert.foodie.miracles.com.foodiedessert;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Shinelon on 2018/2/1.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "cf10fe33e369c9ae3013708f394881f9");
    }
}
