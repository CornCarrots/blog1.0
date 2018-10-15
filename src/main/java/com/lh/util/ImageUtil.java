package com.lh.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageUtil {
//    public static InputStream  upload(HttpServletRequest request,Map<String,String> map) throws FileUploadException, IOException {
////创建一个工厂类。
//        DiskFileItemFactory factory = new DiskFileItemFactory();
////创建一个解析对象。
//        ServletFileUpload  fileUpload = new ServletFileUpload(factory);
////解析request，返回的是list集合，解析时会将上传的数据的每一部分封装成FileItem对象，存入list集合。
//        List<FileItem> fis = fileUpload.parseRequest(request);
////        factory.setSizeThreshold(1024 * 10240);
////        C.解析fileItem
//        InputStream in = null;
//        for(FileItem fi : fis) {
////            System.out.println(fi);
////            syso(fi);
////            重写了toString，有fileItem的具体信息。
////        }
//            if(fi.isFormField()){
//                //获取键值对
//                String key = fi.getFieldName();
//                String value = fi.getString();
//                //注意编码格式，这里直接处理了（可查看本人前几篇，有关请求乱码的精确处理）
//                value = new String(value.getBytes("ISO-8859-1"),"UTF-8"); //将非文件的form提交的数据先保存到map集合中
//                map.put(key, value);
//            }
////        D.对FileItem进行分类
//
//            else  {//一般表单数据
//                in=fi.getInputStream();
//               //图片处理
////                 String key = fi.getFieldName();
////                 //文件的名字
////                 String name = fi.getName();//没有乱码
////                 //创建输入流对象
////                 InputStream inputStream = fi.getInputStream();
////                 //获取到这个存储的文件夹的路径，会随着服务器的改变而动态的改变
////                 ServletContext sc = request.getServletContext();
////                 //该products是项目中存储图片的文件夹
////                 String productsPath = sc.getRealPath("img/category");
////                 //目录优化
//////                 String dir = UploadUtils.getDir();
////                 //拼接文件夹 如：D:\javaweb\tomcat\apache-tomcat-7.0.77\webapps\MyShopAdmin\products\dir
////                 File file = new File(productsPath);
////                 if(!file.exists()){
////                     file.mkdirs();
////                 }
////                 //文件名优化
////                 String fileName = Integer.toString( (Integer) request.getAttribute("categoryID"));
////                 //后缀名获取
//////                 int lastIndexOf = name.lastIndexOf(".");
//////                 String houZhui = name.substring(lastIndexOf);
//////                 fileName+=houZhui;
////                 //根据存储路径以及文件名创建文件
////                 File file2=new File(file,fileName);
////                 if(!file2.exists()){
////                     file2.createNewFile();
////                 }
////                 //创建输出流
////                 FileOutputStream out=new FileOutputStream(file2);
////                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
////                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
////                 //inputStream的数据写到out里
////                copyFile(reader,writer);
//////                 IOUtils.copy(inputStream, out);
//////                 IOUtils.closeQuietly(out);
//////                 IOUtils.closeQuietly(inputStream);
////                 //数据库存储文件路径//图片路径（存入数据库中的文件路径）
//////                 String imgPath="products"+dir+"/"+fileName;
//////                 map.put(key, imgPath);
////                writer.close();
////                reader.close();
////                inputStream.close();
////                out.close();
//            }
//        }
//        return in;
//    }
//    public static void copyFile(FileInputStream in, FileOutputStream out) {
//        try  {
//            if(in.available()==0)
//                return;
//            byte[] bytes = new byte[1024*1024];
//            int lenth = 0;
//            while ((lenth=in.read(bytes))>0)
//            {
//                out.write(bytes,0,lenth);
//            }
//            out.flush();
//
//        }
//
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        public static BufferedImage change2jpg(File f) {
            try {
                Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
                PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
                pg.grabPixels();
                int width = pg.getWidth(), height = pg.getHeight();
                final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
                final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
                DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
                WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
                BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
                return img;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }
    public static void delFile(String path, int id) {
        File file = new File(path, id + ".jpg");
        if (file.exists())
            file.delete();
        else
            System.out.println("不存在");
    }
    public static void resizeImage(File srcFile, int width,int height, File destFile) {
        try {
            if(!destFile.getParentFile().exists())
                destFile.getParentFile().mkdirs();
            Image i = ImageIO.read(srcFile);
            i = resizeImage(i, width, height);
            ImageIO.write((RenderedImage) i, "jpg", destFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Image resizeImage(Image srcImage, int width, int height) {
        try {

            BufferedImage buffImg = null;
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

            return buffImg;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
