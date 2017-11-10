package com.exaple.allnative;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class TempNative {
	
	public static Handler handler;
	
	// 打开设备
	public static native int openHumidity();

	// 控制设备
	public static native void readHumidityValue();

	// 关闭设备
	public static native void closeHumidity();

	// 获取温湿度的方法
	public static void getDataCallBack(int humidiyz, int tempz) {
		Log.e("TempNative", "humidiyz=" + humidiyz);
		Log.e("TempNative", "tempz=" + tempz);
		Message msg = Message.obtain();
		msg.arg1 = humidiyz;
		msg.arg2 = tempz;
		handler.sendMessage(msg);
	}

	// 静态加载动态库
	static {
		System.loadLibrary("humidity");
	}
}
