package com.bull.knowledgesharing.zxing;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Gen2DBarCodeByZXing {

	public void encode(String contents, int width, int height, String imgPath) {
		Hashtable<Object, Object> hints = new Hashtable<Object, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.QR_CODE, width, height, hints);

			MatrixToImageWriter
					.writeToFile(bitMatrix, "png", new File(imgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String imgPath = System.getProperty("user.dir")
		+ System.getProperty("file.separator") + "zxing_2D.png";
		String contents = "Hello Bull!布尔";  
		int width = 300, height = 300;
		Gen2DBarCodeByZXing handler = new Gen2DBarCodeByZXing();
		handler.encode(contents, width, height, imgPath);
	}

}
