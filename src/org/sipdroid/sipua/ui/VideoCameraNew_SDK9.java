package org.sipdroid.sipua.ui;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) 
public class VideoCameraNew_SDK9 {
	public static Camera open() {
		Camera c = null;
		try {
			int camera_id = FindFrontCamera();
			if (camera_id == -1) {
				camera_id = CameraInfo.CAMERA_FACING_BACK;
			}
			c = Camera.open(camera_id); // attempt to get a Camera
												// instance
		} catch (Exception e) {
			c = Camera.open(CameraInfo.CAMERA_FACING_BACK);
		}
		return c;
	}
	public static int FindFrontCamera() {
		int cameraCount = 0;
		Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
		cameraCount = Camera.getNumberOfCameras(); // get cameras number

		for (int camIdx = 0; camIdx < cameraCount; camIdx++) {
			Camera.getCameraInfo(camIdx, cameraInfo); // get camerainfo
			if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
				// 代表摄像头的方位，目前有定义值两个分别为CAMERA_FACING_FRONT前置和CAMERA_FACING_BACK后置
				return camIdx;
			}
		}
		return -1;
	}
}
