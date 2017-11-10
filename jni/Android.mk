# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := liblight
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := com_exaple_fragment_Fragment0.c
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE    := libgecdcmotor
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := dcmotorNative.c
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE    := libcurtainnative
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := CurtainNative.c
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE    := libhumidity
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := tempNative.c
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE    := liblightSensor
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := LightSensorNative.c
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)
