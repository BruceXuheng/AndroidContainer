package com.study.test.testapplication.util;

import android.util.Log;

public class OtherUtils {

    /**
     * 远程版本号 大于 本地版本号
     *
     * @param localVersion   本地版本号[1.0.0]
     * @param controlVersion 远程控制版本号[1.1]
     *
     */
    public static boolean monitorVersion(String localVersion, String controlVersion) {
        if (controlVersion.isEmpty()) {
            return false;
        }
        boolean isFlag = false;
        String localVersionArr[] = localVersion.split("\\.");
        String controlVersionArr[] = controlVersion.split("\\.");
        if (localVersionArr.length > controlVersionArr.length) {
            for (int i = 0; i < controlVersionArr.length; i++) {
                if (Integer.parseInt(controlVersionArr[i]) > Integer.parseInt(localVersionArr[i])) {
                    isFlag = true;
                }
            }
            if (!isFlag) {
                if (Integer.parseInt(localVersionArr[localVersionArr.length - 1]) > 0) {
                    isFlag = true;
                }
            }
        } else if (controlVersionArr.length > localVersionArr.length) {
            for (int i = 0; i < localVersionArr.length; i++) {
                if (Integer.parseInt(controlVersionArr[i]) > Integer.parseInt(localVersionArr[i])) {
                    isFlag = true;
                }
            }
            if (!isFlag) {
                if (Integer.parseInt(controlVersionArr[controlVersionArr.length - 1]) > 0) {
                    isFlag = true;
                }
            }
        } else {
            for (int i = 0; i < localVersionArr.length; i++) {
                if (Integer.parseInt(controlVersionArr[i]) > Integer.parseInt(localVersionArr[i])) {
                    isFlag = true;
                }
            }
        }
        if (isFlag) {
            Log.e("chenxh","monitorVersion 远程"+"大于等于本地");
            return true;
        } else {
            Log.e("chenxh","monitorVersion 远程"+"小于等于本地");
            return false;
        }

    }

}
