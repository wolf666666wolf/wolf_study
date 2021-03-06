package com.study.open.ocr.ocr;
 
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class SoundBinImage {
	public void releaseSound(String filepath,String destpath, int Threshold){
		//���˱���ɫ���кڰ׶�ֵ������
		try {
			BufferedImage bi=ImageIO.read(new File(filepath));
			int width=bi.getWidth();
			int height=bi.getHeight();
 			BufferedImage bi2=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
			Raster raster=bi.getRaster();
			WritableRaster wr=bi2.getRaster();
			for(int i=0;i<width;i++){
				for(int j=0;j<height;j++){
					int[] a=new int[4];
					raster.getPixel(i, j, a);
					//System.out.println("("+a[0]+", "+a[1]+", "+a[2]+", "+a[3]+")");
					if((a[0]+a[1]+a[2])/3>Threshold){
						a[0]=255;
						a[1]=255;
						a[2]=255;
						a[3]=255;
						wr.setPixel(i, j, a);
					}else{
						a[0]=0;
						a[1]=0;
						a[2]=0;
						a[3]=255;
						wr.setPixel(i, j, a);
 
					}
				}
			}
			ImageIO.write(bi2, "PNG", new File(destpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String grayPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "gray.jpeg";
	
	public static String blackPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "blackPath.jpeg";
	public static void main(String[] args) {
		new SoundBinImage().releaseSound(grayPath,blackPath, 60);
	}
}