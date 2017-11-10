package com.exaple.zyy;


import java.util.ArrayList;
import java.util.List;

import com.exaple.fragment.Fragment0;
import com.exaple.fragment.Fragment1;
import com.exaple.fragment.Fragment2;
import com.exaple.fragment.Fragment3;
import com.exaple.zyy.R;
import com.exaple.zyy.R.id;
import com.exaple.zyy.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class SecondActivity extends FragmentActivity implements OnClickListener{


	/**
	 * 四个导航按钮
	 */
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	
	/**
	 * 作为页面容器的ViewPager
	 */
	ViewPager ViewPager;
	/**
	 * 页面集合
	 */
	List<Fragment> fragmentList;  //fragment集合
	
	/**
	 * 四个Fragment（页面）
	 */
	Fragment Fragment0;
	Fragment Fragment1;
	Fragment Fragment2;
	Fragment Fragment3;
	
	//覆盖层
	ImageView imageviewOvertab;
	
	//屏幕宽度
	int screenWidth;
	//当前选中的项
	int currenttab=-1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		button1=(Button)findViewById(R.id.rb_lamp);
		button2=(Button)findViewById(R.id.rb_Airconditioner);
		button3=(Button)findViewById(R.id.rb_curtain);
		button4=(Button)findViewById(R.id.rb_shushidu);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		
		ViewPager=(ViewPager) findViewById(R.id.id_viewpager);
		
		fragmentList=new ArrayList<Fragment>();
		Fragment0=new Fragment0();
		Fragment1=new Fragment1();
		Fragment2=new Fragment2();
		Fragment3=new Fragment3();
		
		fragmentList.add(Fragment0);
		fragmentList.add(Fragment1);
		fragmentList.add(Fragment2);
		fragmentList.add(Fragment3);
		
		
		screenWidth=getResources().getDisplayMetrics().widthPixels;
		
		button2.measure(0, 0);
		imageviewOvertab=(ImageView) findViewById(R.id.imgv_overtab);
		RelativeLayout.LayoutParams imageParams=new RelativeLayout.LayoutParams(screenWidth/4, button2.getMeasuredHeight());
		imageParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		imageviewOvertab.setLayoutParams(imageParams);
		
		ViewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));
	}

	/**
	 * 定义自己的ViewPager适配器。
	 * 也可以使用FragmentPagerAdapter。关于这两者之间的区别，可以自己去搜一下。
	 */
	class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter
	{

		public MyFrageStatePagerAdapter(FragmentManager fm) 
		{
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
		
		/**
		 * 每次更新完成ViewPager的内容后，调用该接口，此处复写主要是为了让导航按钮上层的覆盖层能够动态的移动
		 */
		@Override
		public void finishUpdate(ViewGroup container) 
		{
			super.finishUpdate(container);//这句话要放在最前面，否则会报错
			//获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置
			int currentItem=ViewPager.getCurrentItem();
			if (currentItem==currenttab)
			{
				return ;
			}
			imageMove(ViewPager.getCurrentItem());
			currenttab=ViewPager.getCurrentItem();
		}
		
	}
	
	/**
	 * 移动覆盖层
	 * @param moveToTab 目标Tab，也就是要移动到的导航选项按钮的位置
	 * 第一个导航按钮对应0，第二个对应1，以此类推
	 */
	private void imageMove(int moveToTab)
	{
		int startPosition=0;
		int movetoPosition=0;
		
		startPosition=currenttab*(screenWidth/4);
		movetoPosition=moveToTab*(screenWidth/4);
		//平移动画
		TranslateAnimation translateAnimation=new TranslateAnimation(startPosition,movetoPosition, 0, 0);
		translateAnimation.setFillAfter(true);
		translateAnimation.setDuration(200);
		imageviewOvertab.startAnimation(translateAnimation);
	}
	
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.rb_lamp:
			changeView(0);
			break;
		case R.id.rb_Airconditioner:
			changeView(1);
			break;
		case R.id.rb_curtain:
			changeView(2);
			break;
		case R.id.rb_shushidu:
			changeView(3);
			break;
		default:
			break;
		}
	}
	//手动设置ViewPager要显示的视图
	private void changeView(int desTab)
	{
		ViewPager.setCurrentItem(desTab, true);
	}

}



	



