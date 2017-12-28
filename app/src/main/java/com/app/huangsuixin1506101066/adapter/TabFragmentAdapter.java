package com.app.huangsuixin1506101066.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class TabFragmentAdapter extends FragmentPagerAdapter {

	private final String[] titles;
	private List<Fragment> fragments;

	public TabFragmentAdapter(List<Fragment> fragments, String[] titles, FragmentManager fm) {
		super(fm);
		this.fragments = fragments;
		this.titles = titles;
	}


	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return titles.length;
	}
	//返回的是抬头的文字
	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}
}