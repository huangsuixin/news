package com.app.huangsuixin1506101066.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * @author Silence
 * 页面适配器
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> mList;

	public MyPagerAdapter(FragmentManager fm, List<Fragment> mList) {
		super(fm);
		this.mList = mList;
	}

	@Override
	public Fragment getItem(int position) {
		//mList.get(position) 返回的是Fragment
		return mList.get(position);
	}

	@Override
	public int getCount() {
		return mList.size();
	}
}
