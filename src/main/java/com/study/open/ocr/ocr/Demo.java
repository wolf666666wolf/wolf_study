package com.study.open.ocr.ocr;

import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class Demo {

	public static String demoPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "demo.jpeg";

	public static String removeNoisePath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "removeNoise.jpeg";

	public static String filterPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "filter.jpeg";
	
	public static String grayPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "gray.jpeg";
	
	public static String blackPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "black.png";
	

	public static void main(String[] args) throws Exception {

		OperateImage o = new OperateImage();

		for (int i = 0; i < 8; i++) {
			Pic pic = new Pic(demoPath);
			BufferedImage srcImage = ImageIOHelper
					.imageProducerToBufferedImage(new MemoryImageSource(pic
							.getWidth(), pic.getHeight(), pic
							.getRemovedNoise2(), 0, pic.getWidth()));
			FileOutputStream outImgStream = new FileOutputStream(
					removeNoisePath);
			ImageIO.write(srcImage, "jpeg", outImgStream);
			outImgStream.flush();
			outImgStream.close();
		}

		o.newImage = ImageIO.read(new File(removeNoisePath));
		o.w = o.newImage.getWidth();
		o.h = o.newImage.getHeight();
		int currentPixArray[] = o.getPixArray(o.newImage, o.w, o.h);
		currentPixArray = o.filter(currentPixArray);
		BufferedImage srcImage = ImageIOHelper
				.imageProducerToBufferedImage(new MemoryImageSource(o.w, o.h,
						currentPixArray, 0, o.w));
		
		FileOutputStream outImgStream = new FileOutputStream(filterPath);
		ImageIO.write(srcImage, "jpeg", outImgStream);
		outImgStream.flush();
		outImgStream.close();
		
		currentPixArray = o.RGBtoGray(currentPixArray);
	    srcImage = ImageIOHelper
				.imageProducerToBufferedImage(new MemoryImageSource(o.w, o.h,
						currentPixArray, 0, o.w));
	    outImgStream = new FileOutputStream(grayPath);
		ImageIO.write(srcImage, "jpeg", outImgStream);
		outImgStream.flush();
		outImgStream.close();

		
		new SoundBinImage().releaseSound(grayPath,blackPath, 60);
		
		String pazzleString = new Tesseract().recognizeText(new File(blackPath),
				"png");
		System.err.println(pazzleString);
	}
}
