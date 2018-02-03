package dessert.foodie.miracles.com.foodiedessert.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dessert.foodie.miracles.com.foodiedessert.R;
import dessert.foodie.miracles.com.foodiedessert.adapter.FragmentAdapter;
import dessert.foodie.miracles.com.foodiedessert.fragment.FragmentA;
import dessert.foodie.miracles.com.foodiedessert.fragment.FragmentB;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.home_viewPager)
    ViewPager homeViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();
    }

    //初始化
    private void init() {
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager());
        List<Fragment>list=new ArrayList<>();
        list.add(new FragmentA());
        list.add(new FragmentB());
        adapter.setFragmentList(list);
        homeViewPager.setAdapter(adapter);
    }
}
