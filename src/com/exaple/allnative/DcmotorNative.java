package com.exaple.allnative;

public class DcmotorNative {
	public static native int openDcMotorDev();

	public static native void opDcMotorDev(int op);

	public static native void closeDcMotorDev();

	static {
		System.loadLibrary("gecdcmotor");
	}
}
