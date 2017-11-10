#include "tempNative.h"
#include<stdio.h>
#include<sys/types.h>
#include <android/log.h>

#define  LOG_TAG    "libtemp"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

int fd;

JNIEXPORT jint JNICALL Java_com_exaple_allnative_TempNative_openHumidity(
		JNIEnv *env, jclass cls) {
	fd = open("/dev/humidity", 0);
	if (fd < 0) {
		LOGE("/dev/humidiy open fail\n");
		return 0;
	}

	return fd;
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_TempNative_readHumidityValue
(JNIEnv *env, jclass cls)
{

	unsigned short tempz = 0;
	unsigned short tempx = 0;
	unsigned short humidiyz = 0;
	unsigned short humidiyx = 0;
	unsigned long temperature = 0;

	read(fd,&temperature,sizeof( temperature ));

	humidiyz = (temperature & 0xff000000)>>24; //ʪ�ȵ���������
	humidiyx = (temperature & 0x00ff0000)>>16;//ʪ�ȵ�С������
	tempz = (temperature & 0x0000ff00)>>8;//�¶ȵ���������
	tempx = (temperature & 0x000000ff);//�¶ȵ�С������

	LOGI("humidity = %d.%d%%\n", humidiyz, humidiyx);
	LOGI("temp = %d.%d\n",tempz,tempx);

    //jmethodID (JNICALL *GetMethodID)
      //(JNIEnv *env, jclass clazz, const char *name, const char *sig);

	//��C���е���java��ķ���getDataCallBack��������Ӧ����
	jmethodID getDataCallBackMethodId=(*env)->GetStaticMethodID(env,cls,"getDataCallBack","(II)V");

    //void (JNICALL *CallStaticVoidMethod)
      //(JNIEnv *env, jclass cls, jmethodID methodID, ...);

	(*env)->CallStaticVoidMethod(env,cls,getDataCallBackMethodId,humidiyz,tempz);

}

JNIEXPORT void JNICALL Java_com_exaple_allnative_TempNative_closeHumidity
(JNIEnv *env, jclass cls)
{
	close(fd);
}
