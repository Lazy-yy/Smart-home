package com.exaple.fragment;




import com.exaple.allnative.LightSenserNative;
import com.exaple.allnative.TempNative;
import com.exaple.zyy.R;
import com.exaple.zyy.R.layout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Fragment3 extends Fragment{
	
	private TextView tv1;
	private TextView tv2;
	private TextView tv;
	
	private Handler handler;

	private boolean isEnable = false;

	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
		
		
		View view = inflater.inflate(R.layout.fragment3, container, false);
		return view;
		
	}
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	    TempNative.openHumidity();
	    LightSenserNative.openLightSenseDev();

	tv1 = (TextView) getActivity().findViewById(R.id.temperature);
	tv2 = (TextView) getActivity().findViewById(R.id.humidity);

	handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			int humidity = msg.arg1;
			int temp = msg.arg2;

			if (humidity != 0) {
				tv1.setText(humidity + "");
				tv2.setText(temp + "");
			}
		}
	};

	// 为了确保发送消息和处理消息是同一个handler对象
	TempNative.handler = handler;

	// 找控件和监听方法一起写
	// 启动监测温湿度的按钮
	getActivity().findViewById(R.id.start1).setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			isEnable = true;
			// 控制设备
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (isEnable) {
						// 控制设备
						TempNative.readHumidityValue();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// 如果在循环过程中遇到标志位被成false的话，退出循环
						// if (!isEnable) {
						// break;
						// }

					}

				}

			}).start();

		}
	});

	// 停止检测温湿度
	getActivity().findViewById(R.id.stop1).setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			isEnable = false;
		}
	});
	
	
	LightSenserNative.openLightSenseDev();

	tv = (TextView) getActivity().findViewById(R.id.Lightintensity);
	getActivity().findViewById(R.id.start2).setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			int a =LightSenserNative.nowLightSense();
//			tv.setText(""+a);
			tv.setText(LightSenserNative.nowLightSense()+"");
		}
	});

}
	



@Override
public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	// 关闭设备
	TempNative.closeHumidity();


    super.onDestroy();
    LightSenserNative.closeLightSenseDev();
}
}

