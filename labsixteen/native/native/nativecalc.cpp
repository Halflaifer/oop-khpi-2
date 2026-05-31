#include <jni.h>
#include <vector>

extern "C" {
    JNIEXPORT jdouble JNICALL
    Java_ua_khpi_oop_lab16_service_NativeDataProcessor_calculateAverageNative(
        JNIEnv *env, jobject obj, jdoubleArray values) {

        if (values == NULL) return 0.0;

        jsize length = env->GetArrayLength(values);
        if (length == 0) return 0.0;

        jdouble *elements = env->GetDoubleArrayElements(values, NULL);
        
        double sum = 0.0;
        for (int i = 0; i < length; i++) {
            sum += elements[i];
        }

        env->ReleaseDoubleArrayElements(values, elements, JNI_ABORT);

        return sum / length;
    }
}