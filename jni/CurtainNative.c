#include "CurtainNative.h"
#include <stdio.h>
#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <sys/ioctl.h>
#include <android/log.h>

#define  LOG_TAG    "libhumidit"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)s

static char sz[] = "hello!";
static char readback[1024];
//添加要读写的数组及字符串
static char led[5] = { 0x80 };
int fd4;
#define CMD  _IOC(2,0,0,0)

JNIEXPORT void JNICALL Java_com_exaple_allnative_CurtainNative_openCurtainDev
(JNIEnv *env, jclass cls) {
	int i,j,speed;
	fd4 = open("/dev/stepmotor", O_RDWR);
}

JNIEXPORT jint JNICALL Java_com_exaple_allnative_CurtainNative_changeCurtainDev
(JNIEnv *env, jclass cls, jint state, jint angle) {
	if (fd4) {
		ioctl(fd4, state, angle);
	}
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_CurtainNative_closeCurtainDev
(JNIEnv *env, jclass cls) {
	close(fd4);
}
