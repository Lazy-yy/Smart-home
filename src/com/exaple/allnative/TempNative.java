package com.exaple.allnative;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class TempNative {
	
	public static Handler handler;
	
	// ���豸
	public static native int openHumidity();

	// �����豸
	public static native void readHumidityValue();

	// �ر��豸
	public static native void closeHumidity();

	// ��ȡ��ʪ�ȵķ���
	public static void getDataCallBack(int humidiyz, int tempz) {
		Log.e("TempNative", "humidiyz=" + humidiyz);
		Log.e("TempNative", "tempz=" + tempz);
		Message msg = Message.obtain();
		msg.arg1 = humidiyz;
		msg.arg2 = tempz;
		handler.sendMessage(msg);
	}

	// ��̬���ض�̬��
	static {
		System.loadLibrary("humidity");
	}
}
