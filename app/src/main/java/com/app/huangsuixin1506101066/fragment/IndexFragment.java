package com.app.huangsuixin1506101066.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.app.huangsuixin1506101066.R;
import com.app.huangsuixin1506101066.adapter.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.app.huangsuixin1506101066.R.id.tablayout;


public class IndexFragment extends Fragment {

	private TextView tv;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_index, container, false);

		tv = (TextView) v.findViewById(R.id.tv);
		mTabLayout = (TabLayout) v.findViewById(tablayout);
		mViewPager = (ViewPager) v.findViewById(R.id.index_vp);
		initView();
		return v;
	}

	private void initView() {

		List<Fragment> fragments = new ArrayList<>();
		fragments.add(new IntroFragment("焦点"));
		fragments.add(new IntroFragment("社会最新"));
		fragments.add(new IntroFragment("科技焦点"));
		fragments.add(new IntroFragment("体育最新"));
		fragments.add(new IntroFragment("教育最新"));
		fragments.add(new IntroFragment("游戏最新"));
		fragments.add(new IntroFragment("健康养生最新"));
		fragments.add(new IntroFragment("财经最新"));

		String[] strings = {"焦点","社会","科技","体育", "教育", "游戏" , "健康养生", "财经"};

		mViewPager.setAdapter(new TabFragmentAdapter(fragments,strings,getChildFragmentManager()));
		// 设置tab文本的没有选中（第一个参数）和选中（第二个参数）的颜色
		mTabLayout.setTabTextColors(Color.parseColor("#000000"),getResources().getColor(R.color.colorPrimary));
		//tablayout绑定viewpager
		mTabLayout.setupWithViewPager(mViewPager);


	}


}
