package com.exaple.allnative;

public class CurtainNative {
	public static native void openCurtainDev();

	public static native int changeCurtainDev(int state, int angle);

	public static native void closeCurtainDev();

	static {
		System.loadLibrary("curtainnative");
	}
}
