#include "com_exaple_fragment_Fragment0.h"
#include <stdio.h>
#include <fcntl.h>
#include <android/log.h>

#define  LOG_TAG    "liblight"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

int fd = -1;

JNIEXPORT jint JNICALL Java_com_exaple_allnative_LightNative_openLightDev(
		JNIEnv *env, jclass cls) {
	fd = open("/dev/light", O_RDWR);
	if (fd < 0) {
		LOGE("Can not open /dev/light\n");
		return 0;
	}

	return fd;
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_LightNative_opLight
(JNIEnv *env, jclass cls, jint op)
{
	switch(op)
	{
		case 1: ioctl(fd,1,1); //·¿¼äµÆÃð
		break;
		case 2: ioctl(fd,1,0);//¿ÍÌüµÆÃð
		break;
		case 3: ioctl(fd,0,1);//·¿¼äµÆÁÁ
		break;
		case 4: ioctl(fd,0,0);//¿ÍÌüµÆÁÁ
		break;
	}
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_LightNative_closeLightDev
(JNIEnv *env, jclass cls)
{
	close(fd);
}
