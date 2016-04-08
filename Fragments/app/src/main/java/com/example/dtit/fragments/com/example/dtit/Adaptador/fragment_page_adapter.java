package com.example.dtit.fragments.com.example.dtit.Adaptador;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dtit.fragments.com.example.dtit.Fragmentos.fragment_page;

//import com.example.dtit.fragments.com.example.dtit.Fragmentos.fragment_page;


/**
 * Created by dtit on 02/03/16.
 */
public class fragment_page_adapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabtitles[] = new String[] {"tab1", "tab2", "tab3"};


    public fragment_page_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //return fragment_page.newinstance(position + 1);
        return fragment_page.newInstance(position + 1);
        //return null; android.support.v4
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
