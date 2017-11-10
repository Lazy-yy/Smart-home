#include "dcmotorNative.h"

#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ioctl.h>

#include <android/log.h>

#define  LOG_TAG    "libdcmotor"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)



#define PATH  	"/dev/dc_motor"

int fd = -1;

JNIEXPORT jint JNICALL Java_com_exaple_allnative_DcmotorNative_openDcMotorDev
  (JNIEnv *env, jclass cls)
{

	unsigned int val;

	fd = open(PATH, 0);
	if (fd < 0) {
		LOGE("Can not open /dev/dc_motor\n");
		return 0;
	}

	return fd;
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_DcmotorNative_opDcMotorDev
  (JNIEnv *env, jclass cls, jint op)
{
	ioctl(fd, op, 0);
}


JNIEXPORT void JNICALL Java_com_exaple_allnative_DcmotorNative_closeDcMotorDev
  (JNIEnv *env, jclass cls)
{
	close(fd);
}

