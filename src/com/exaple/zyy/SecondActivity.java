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
	 * �ĸ�������ť
	 */
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	
	/**
	 * ��Ϊҳ��������ViewPager
	 */
	ViewPager ViewPager;
	/**
	 * ҳ�漯��
	 */
	List<Fragment> fragmentList;  //fragment����
	
	/**
	 * �ĸ�Fragment��ҳ�棩
	 */
	Fragment Fragment0;
	Fragment Fragment1;
	Fragment Fragment2;
	Fragment Fragment3;
	
	//���ǲ�
	ImageView imageviewOvertab;
	
	//��Ļ���
	int screenWidth;
	//��ǰѡ�е���
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
	 * �����Լ���ViewPager��������
	 * Ҳ����ʹ��FragmentPagerAdapter������������֮������𣬿����Լ�ȥ��һ�¡�
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
		 * ÿ�θ������ViewPager�����ݺ󣬵��øýӿڣ��˴���д��Ҫ��Ϊ���õ�����ť�ϲ�ĸ��ǲ��ܹ���̬���ƶ�
		 */
		@Override
		public void finishUpdate(ViewGroup container) 
		{
			super.finishUpdate(container);//��仰Ҫ������ǰ�棬����ᱨ��
			//��ȡ��ǰ����ͼ��λ��ViewGroup�ĵڼ���λ�ã��������¶�Ӧ�ĸ��ǲ����ڵ�λ��
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
	 * �ƶ����ǲ�
	 * @param moveToTab Ŀ��Tab��Ҳ����Ҫ�ƶ����ĵ���ѡ�ť��λ��
	 * ��һ��������ť��Ӧ0���ڶ�����Ӧ1���Դ�����
	 */
	private void imageMove(int moveToTab)
	{
		int startPosition=0;
		int movetoPosition=0;
		
		startPosition=currenttab*(screenWidth/4);
		movetoPosition=moveToTab*(screenWidth/4);
		//ƽ�ƶ���
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
	//�ֶ�����ViewPagerҪ��ʾ����ͼ
	private void changeView(int desTab)
	{
		ViewPager.setCurrentItem(desTab, true);
	}

}



	



