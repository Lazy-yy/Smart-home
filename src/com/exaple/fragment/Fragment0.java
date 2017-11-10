package com.exaple.fragment;


import com.exaple.allnative.LightNative;
import com.exaple.zyy.R;
import com.exaple.zyy.R.drawable;
import com.exaple.zyy.R.id;
import com.exaple.zyy.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;


public class Fragment0 extends Fragment  {
	
	private ToggleButton tb1,tb2;
	private ImageView img;
	
	// ��־λ
	boolean flag = true;
	boolean flag1 = true;

	// ����һ����ѡ�ı���
	CheckBox cb1, cb2;
	Button btn;
	Switch sw;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		View view = inflater.inflate(R.layout.fragment0, container, false);
		
		
		tb1=(ToggleButton)view.findViewById(R.id.toggleButton1);
		tb2=(ToggleButton)view.findViewById(R.id.toggleButton2);
		img=(ImageView)view.findViewById(R.id.imageView1);
		
		
		tb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
				
				img.setBackgroundResource(isChecked?R.drawable.on:R.drawable.off);
			}
		});
		
		
		
		tb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
				
				img.setBackgroundResource(isChecked?R.drawable.on:R.drawable.off);
			}
		});
		return view;
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// ���豸
		LightNative.openLightDev();
		// ��ʼ���ؼ�
		// initView();
		tb1=(ToggleButton)getActivity().findViewById(R.id.toggleButton1);
		tb2=(ToggleButton)getActivity().findViewById(R.id.toggleButton2);
		
		tb1.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				switch (v.getId()) {
				case R.id.toggleButton1:
					
					
					if (flag) {
						LightNative.opLight(3);// ����ƿ�
						flag = false;
					} else {
						LightNative.opLight(1);// ����ƹ�
						flag = true;
					}
					break;

				case R.id.toggleButton2:
					if (flag1) {
						LightNative.opLight(4);// �����ƿ�
						flag1 = false;
					} else {
						LightNative.opLight(2);// �����ƹ�
						flag1 = true;
					}
					break;

				default:
					break;
				}
				
			}
			
			
		});
		
		
	tb2.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				switch (v.getId()) {
				case R.id.toggleButton1:
					
					
					if (flag) {
						LightNative.opLight(3);// ����ƿ�
						flag = false;
					} else {
						LightNative.opLight(1);// ����ƹ�
						flag = true;
					}
					break;

				case R.id.toggleButton2:
					if (flag1) {
						LightNative.opLight(4);// �����ƿ�
						flag1 = false;
					} else {
						LightNative.opLight(2);// �����ƹ�
						flag1 = true;
					}
					break;

				default:
					break;
				}
				
			}
			
			
		});
		
		
		
	}
	
	
	
		

			@Override
			public void onDestroy() {
				// TODO Auto-generated method stub
				super.onDestroy();
				// �ر��豸
				LightNative.closeLightDev();
			}
	
	
	
	
}