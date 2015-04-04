package com.study.open.ocr.ocr;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class OperateImage
{

    // ===源图片路径名称如:c:\1.jpg
    private String srcpath;

    // ===剪切图片存放路径名称.如:c:\2.jpg
    private String subpath;

    // ===剪切点x坐标
    private int x;

    private int y;

    // ===剪切点宽度
    private int width;

    private int height;

    public OperateImage()
    {

    }

    public OperateImage(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /** */
    /**
     * 对图片裁剪，并把裁剪完蛋新图片保存 。
     */
    public void cut() throws IOException
    {

        FileInputStream is = null;
        ImageInputStream iis = null;

        try
        {
            // 读取图片文件
            is = new FileInputStream(srcpath);

            /**//*
                 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。 参数：formatName - 包含非正式格式名称 . （例如 "jpeg"
                 * 或 "tiff"）等 。
                 */
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(is);

            /**//*
                 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
                 * 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
                 */
            reader.setInput(iis, true);

            /**//*
                 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
                 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
                 */
            ImageReadParam param = reader.getDefaultReadParam();

            /**//*
                 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
                 */
            Rectangle rect = new Rectangle(x, y, width, height);

            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
            param.setSourceRegion(rect);

            /**//*
                 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的 BufferedImage 返回。
                 */
            BufferedImage bi = reader.read(0, param);

            // 保存新图片
            ImageIO.write(bi, "jpg", new File(subpath));
        }

        finally
        {
            if (is != null)
                is.close();
            if (iis != null)
                iis.close();
        }

    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getSrcpath()
    {
        return srcpath;
    }

    public void setSrcpath(String srcpath)
    {
        this.srcpath = srcpath;
    }

    public String getSubpath()
    {
        return subpath;
    }

    public void setSubpath(String subpath)
    {
        this.subpath = subpath;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    // 图像的高和宽
    public int h;

    public int w;
    public BufferedImage newImage;

    // ////////////////获取图像像素矩阵\\\\\\\\\
    public int[] getPixArray(Image im, int w, int h)
    {
        int[] pix = new int[w * h];
        PixelGrabber pg = null;
        try
        {
            pg = new PixelGrabber(im, 0, 0, w, h, pix, 0, w);
            if (pg.grabPixels() != true)
                try
                {
                    throw new java.awt.AWTException("pg error" + pg.status());
                }
                catch (Exception eq)
                {
                    eq.printStackTrace();
                }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return pix;
    }

    // ////////////////灰度转换\\\\\\\\\\\
    public int[] RGBtoGray(int[] ImageSource)
    {
        int[] grayArray = new int[h * w];
        ColorModel colorModel = ColorModel.getRGBdefault();
        int i, j, k, r, g, b;
        for (i = 0; i < h; i++)
        {
            for (j = 0; j < w; j++)
            {
                k = i * w + j;
                r = colorModel.getRed(ImageSource[k]);
                g = colorModel.getGreen(ImageSource[k]);
                b = colorModel.getBlue(ImageSource[k]);
                int gray = (int) (r * 0.3 + g * 0.59 + b * 0.11);
                r = g = b = gray;
                grayArray[i * w + j] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        return grayArray;
    }

    public int[] filter(int[] data) throws Exception
    {
        int width = w;
        int height = h;
        int filterData[] = new int[data.length];
        int min = 10000;
        int max = -10000;
        if (data.length != width * height)
            return filterData;
        try
        {

            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    if (i == 0 || i == 1 || i == height - 1 || i == height - 2 || j == 0 || j == 1 || j == width - 1
                            || j == width - 2)
                    {
                        filterData[i * width + j] = data[i * width + j];
                    }
                    else
                    {
                        double average;
                        // 中心的九个像素点
                        average = (data[i * width + j] + data[i * width + j - 1] + data[i * width + j + 1]
                                + data[(i - 1) * width + j] + data[(i - 1) * width + j - 1]
                                + data[(i - 1) * width + j + 1] + data[(i + 1) * width + j]
                                + data[(i + 1) * width + j - 1] + data[(i + 1) * width + j + 1]) / 9;
                        filterData[i * width + j] = (int) (average);
                    }
                    if (filterData[i * width + j] < min)
                        min = filterData[i * width + j];
                    if (filterData[i * width + j] > max)
                        max = filterData[i * width + j];
                }
            }
            for (int i = 0; i < width * height; i++)
            {
                filterData[i] = (filterData[i] - min) * 255 / (max - min);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        return filterData;
    }

    public BufferedImage median(BufferedImage image, int iw, int ih, int[] pixels)
    {
        PixelGrabber pg = new PixelGrabber(image.getSource(), 0, 0, iw, ih, pixels, 0, iw);
        try
        {
            pg.grabPixels();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        // 对图像进行中值滤波，Alpha值保持不变
        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 1; i < ih - 1; i++)
        {
            for (int j = 1; j < iw - 1; j++)
            {
                int red, green, blue;
                int alpha = cm.getAlpha(pixels[i * iw + j]);

                // int red2 = cm.getRed(pixels[(i - 1) * iw + j]);
                int red4 = cm.getRed(pixels[i * iw + j - 1]);
                int red5 = cm.getRed(pixels[i * iw + j]);
                int red6 = cm.getRed(pixels[i * iw + j + 1]);
                // int red8 = cm.getRed(pixels[(i + 1) * iw + j]);

                // 水平方向进行中值滤波
                if (red4 >= red5)
                {
                    if (red5 >= red6)
                    {
                        red = red5;
                    }
                    else
                    {
                        if (red4 >= red6)
                        {
                            red = red6;
                        }
                        else
                        {
                            red = red4;
                        }
                    }
                }
                else
                {
                    if (red4 > red6)
                    {
                        red = red4;
                    }
                    else
                    {
                        if (red5 > red6)
                        {
                            red = red6;
                        }
                        else
                        {
                            red = red5;
                        }
                    }
                }

                // int green2 = cm.getGreen(pixels[(i - 1) * iw + j]);
                int green4 = cm.getGreen(pixels[i * iw + j - 1]);
                int green5 = cm.getGreen(pixels[i * iw + j]);
                int green6 = cm.getGreen(pixels[i * iw + j + 1]);
                // int green8 = cm.getGreen(pixels[(i + 1) * iw + j]);

                // 水平方向进行中值滤波
                if (green4 >= green5)
                {
                    if (green5 >= green6)
                    {
                        green = green5;
                    }
                    else
                    {
                        if (green4 >= green6)
                        {
                            green = green6;
                        }
                        else
                        {
                            green = green4;
                        }
                    }
                }
                else
                {
                    if (green4 > green6)
                    {
                        green = green4;
                    }
                    else
                    {
                        if (green5 > green6)
                        {
                            green = green6;
                        }
                        else
                        {
                            green = green5;
                        }
                    }
                }

                // int blue2 = cm.getBlue(pixels[(i - 1) * iw + j]);
                int blue4 = cm.getBlue(pixels[i * iw + j - 1]);
                int blue5 = cm.getBlue(pixels[i * iw + j]);
                int blue6 = cm.getBlue(pixels[i * iw + j + 1]);
                // int blue8 = cm.getBlue(pixels[(i + 1) * iw + j]);

                // 水平方向进行中值滤波
                if (blue4 >= blue5)
                {
                    if (blue5 >= blue6)
                    {
                        blue = blue5;
                    }
                    else
                    {
                        if (blue4 >= blue6)
                        {
                            blue = blue6;
                        }
                        else
                        {
                            blue = blue4;
                        }
                    }
                }
                else
                {
                    if (blue4 > blue6)
                    {
                        blue = blue4;
                    }
                    else
                    {
                        if (blue5 > blue6)
                        {
                            blue = blue6;
                        }
                        else
                        {
                            blue = blue5;
                        }
                    }
                }
                pixels[i * iw + j] = alpha << 24 | red << 16 | green << 8 | blue;
            }
        }

        // 将数组中的象素产生一个图像
        return ImageIOHelper.imageProducerToBufferedImage(new MemoryImageSource(iw, ih, pixels, 0, iw));
    }

    public BufferedImage sharp(BufferedImage image, int iw, int ih, int[] pixels)
    {
        PixelGrabber pg = new PixelGrabber(image.getSource(), 0, 0, iw, ih, pixels, 0, iw);
        try
        {
            pg.grabPixels();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // 象素的中间变量
        int tempPixels[] = new int[iw * ih];
        for (int i = 0; i < iw * ih; i++)
        {
            tempPixels[i] = pixels[i];
        }
        // 对图像进行尖锐化处理，Alpha值保持不变
        ColorModel cm = ColorModel.getRGBdefault();
        for (int i = 1; i < ih - 1; i++)
        {
            for (int j = 1; j < iw - 1; j++)
            {
                int alpha = cm.getAlpha(pixels[i * iw + j]);

                // 对图像进行尖锐化
                int red6 = cm.getRed(pixels[i * iw + j + 1]);
                int red5 = cm.getRed(pixels[i * iw + j]);
                int red8 = cm.getRed(pixels[(i + 1) * iw + j]);
                int sharpRed = Math.abs(red6 - red5) + Math.abs(red8 - red5);

                int green5 = cm.getGreen(pixels[i * iw + j]);
                int green6 = cm.getGreen(pixels[i * iw + j + 1]);
                int green8 = cm.getGreen(pixels[(i + 1) * iw + j]);
                int sharpGreen = Math.abs(green6 - green5) + Math.abs(green8 - green5);

                int blue5 = cm.getBlue(pixels[i * iw + j]);
                int blue6 = cm.getBlue(pixels[i * iw + j + 1]);
                int blue8 = cm.getBlue(pixels[(i + 1) * iw + j]);
                int sharpBlue = Math.abs(blue6 - blue5) + Math.abs(blue8 - blue5);

                if (sharpRed > 255)
                {
                    sharpRed = 255;
                }
                if (sharpGreen > 255)
                {
                    sharpGreen = 255;
                }
                if (sharpBlue > 255)
                {
                    sharpBlue = 255;
                }

                tempPixels[i * iw + j] = alpha << 24 | sharpRed << 16 | sharpGreen << 8 | sharpBlue;
            }
        }

        // 将数组中的象素产生一个图像
        return ImageIOHelper.imageProducerToBufferedImage(new MemoryImageSource(iw, ih, tempPixels, 0, iw));
    }
    

}

