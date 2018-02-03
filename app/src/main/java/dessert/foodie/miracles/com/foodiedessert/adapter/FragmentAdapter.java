package dessert.foodie.miracles.com.foodiedessert.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者邮箱：zeng_huanmu@163.com
 * fragemnt适配器
 * Created by Shinelon on 2018/2/2.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public void setFragmentList(List<Fragment> list) {
        this.fragmentList = list;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
