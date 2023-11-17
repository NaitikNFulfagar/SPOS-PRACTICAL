#include<jni.h>
#include<stdio.h>
#include "testJni1.h" 
JNIEXPORT jint JNICALL Java_testJni1_add(JNIEnv *env, jobject thisobj, jint n1, jint n2)
{
    jint res;
    res=n1+n2;
    return res;
}