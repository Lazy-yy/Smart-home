#include "LightSensorNative.h"
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>

int fd = -1;

JNIEXPORT void JNICALL Java_com_exaple_allnative_LightSenserNative_openLightSenseDev
(JNIEnv *env, jclass cls) {
	fd = open("/dev/lightsensor",O_RDWR);
	if(fd < 0) {
		perror("open lightsensor device:");
	}
}

JNIEXPORT jint JNICALL Java_com_exaple_allnative_LightSenserNative_nowLightSense(
		JNIEnv *env, jclass cls) {
	int ret;
	char buffer[30];
	int value;
	ret = read(fd, buffer, sizeof(buffer) - 1);
	if (ret > 0) {
		buffer[ret] = '\0';
		value = -1;
		sscanf(buffer, "%d", &value);
		return value;
	} else {
		perror("read lightsensor device:");
		exit(EXIT_FAILURE);
	}
	return 0;
}

JNIEXPORT void JNICALL Java_com_exaple_allnative_LightSenserNative_closeLightSenseDev
(JNIEnv *env, jclass cls) {
	close(fd);
}
