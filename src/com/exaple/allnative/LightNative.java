package com.exaple.allnative;

public class LightNative {
	//�򿪵��豸
	public static native int openLightDev();
	
	//���Ƶ��豸
	public static native void opLight(int a);
	
	//�رյ��豸
	public static native void closeLightDev();
	
	//��̬���ض�̬��
	static{
		System.loadLibrary("light");
	}
	
}