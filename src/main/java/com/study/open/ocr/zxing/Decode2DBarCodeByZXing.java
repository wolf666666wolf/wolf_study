package com.bull.knowledgesharing.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Decode2DBarCodeByZXing {

	/**
	 * @param imgPath
	 * @return String
	 */
	public String decode(String imgPath) {
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File(imgPath));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Hashtable<Object, Object> hints = new Hashtable<Object, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

			result = new MultiFormatReader().decode(bitmap, hints);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String imgPath = System.getProperty("user.dir")
		+ System.getProperty("file.separator") + "zxing_2D.png";
		Decode2DBarCodeByZXing handler = new Decode2DBarCodeByZXing();
		String decodeContent = handler.decode(imgPath);
		System.out.println(decodeContent);

	}
}
