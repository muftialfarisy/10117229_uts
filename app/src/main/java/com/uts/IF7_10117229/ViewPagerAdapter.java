package com.uts.IF7_10117229;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
import java.util.ArrayList;
import java.util.List;
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private Menu _menu = null;
    ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
    private Menu getMenu( int position)
    {
        //use it like this
        return _menu;
    }
}
