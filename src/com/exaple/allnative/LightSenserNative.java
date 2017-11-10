package com.exaple.allnative;

public class LightSenserNative {
	public static native void openLightSenseDev();

	public static native int nowLightSense();

	public static native void closeLightSenseDev();

	static {
		System.loadLibrary("lightSensor");
	}
}
