package com.bull.knowledgesharing.swetake;

import java.awt.Color;  
import java.awt.Graphics2D;  
import java.awt.image.BufferedImage;  
import java.io.File;  
  
import javax.imageio.ImageIO;  
  
import com.swetake.util.Qrcode; 

public class Gen2DBarCodeBySwetake {

    public void encoderQRCode(String content, String imgPath) {  
        try {  
  
            Qrcode qrcodeHandler = new Qrcode();  
            qrcodeHandler.setQrcodeErrorCorrect('L');  
            qrcodeHandler.setQrcodeEncodeMode('B');  
  
            byte[] contentBytes = content.getBytes("UTF-8");  
  
            BufferedImage bufImg = new BufferedImage(300, 300,  
                    BufferedImage.TYPE_INT_RGB);  
  
            Graphics2D gs = bufImg.createGraphics();  
  
            gs.setBackground(Color.WHITE);  
            gs.clearRect(0, 0, 140, 140);  
  
            gs.setColor(Color.BLACK);  
  
            int pixoff = 2;  
            if (contentBytes.length > 0 && contentBytes.length < 120) {  
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
                for (int i = 0; i < codeOut.length; i++) {  
                    for (int j = 0; j < codeOut.length; j++) {  
                        if (codeOut[j][i]) {  
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                        }  
                    }  
                }  
            } else {  
                System.err.println("QRCode content bytes length = "  
                        + contentBytes.length + " not in [ 0,120 ]. ");  
            }  
  
            gs.dispose();  
            bufImg.flush();  
  
            File imgFile = new File(imgPath);  
  
            ImageIO.write(bufImg, "png", imgFile);  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        String imgPath = "D:\\eclipse\\workspace\\OCRDemo\\swetake_2D.png";  
  
        String content = "Hello Bull!";  
  
        Gen2DBarCodeBySwetake handler = new Gen2DBarCodeBySwetake();  
        handler.encoderQRCode(content, imgPath);  
    } 
    
}
