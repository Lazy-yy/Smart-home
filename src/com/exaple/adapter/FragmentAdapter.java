package com.exaple.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter{



	private List<Fragment> mFragment;

	
	public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		// TODO Auto-generated constructor stub
		mFragment = fragments;
	}
	

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return mFragment.get(arg0);
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFragment.size();
	}
}
