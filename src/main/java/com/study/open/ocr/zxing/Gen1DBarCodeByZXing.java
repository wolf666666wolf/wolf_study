package com.bull.knowledgesharing.zxing;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class Gen1DBarCodeByZXing {

	public void encode(String contents, int width, int height, String imgPath) {
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.EAN_13, width, height, null);

			MatrixToImageWriter
					.writeToFile(bitMatrix, "png", new File(imgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String imgPath = System.getProperty("user.dir")
		+ System.getProperty("file.separator") + "zxing_1D.png";
		String contents = "6945601700093";
		int width = 100, height = 50;
		Gen1DBarCodeByZXing handler = new Gen1DBarCodeByZXing();
		handler.encode(contents, width, height, imgPath);
	}
}
