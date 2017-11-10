package com.exaple.allnative;

public class LightNative {
	//打开灯设备
	public static native int openLightDev();
	
	//控制灯设备
	public static native void opLight(int a);
	
	//关闭灯设备
	public static native void closeLightDev();
	
	//静态加载动态库
	static{
		System.loadLibrary("light");
	}
	
}