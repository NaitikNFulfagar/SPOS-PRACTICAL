#include<jni.h>
#include<stdio.h>
#include "testJni.h" 
JNIEXPORT jint JNICALL Java_testJni_add(JNIEnv *env, jobject thisobject, jint n1, jint n2)
{
    jint res;
    res=n1+n2;
    return res;
}