 
package LocalFuntionGlobal;

 
import static ConnectBean.Provider.hostname;
import static ConnectBean.Provider.passftp;
import static ConnectBean.Provider.userftp;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
 
 

 
public class Hamimage {
    
 
    // Chuyen doi gia tri sang Buffimage  
 
  public static BufferedImage tranimage (InputStream byteImage) throws IOException{
      
      BufferedImage bf = null ;
      
     // InputStream in =new ByteInputStream();
      bf=ImageIO.read(byteImage);

      return bf ;
  } 
    
   public static InputStream convertFiletoInputstream(InputStream isa,String duoifile) throws IOException {
     
  
             BufferedImage originalImage = null;
             try {
                
                    
                   originalImage = ImageIO.read(isa);  
                   ByteArrayOutputStream os = new ByteArrayOutputStream();
                   ImageIO.write(originalImage, duoifile, os);
                   InputStream is = new ByteArrayInputStream(os.toByteArray());
                   return is ;
                 
             } catch (Exception e) {
                    return null;
                 
             }
 
    }
  
  // Xử lý ảnh về trắng đen .
 
  public BufferedImage processImage(BufferedImage orgimage, int brightness, int contrast, int t_black, int t_white) {
       
        Color c;
        int r, g, b;
   
        BufferedImage bimg=orgimage;
        Double centimeters = orgimage.getHeight() * 2.54 / 96 ;
        float factor = (259f * (contrast + 255f)) / (255f * (259f - contrast));
 
        for (int x = 0; x < bimg.getWidth(); x++)
            for (int y = 0; y < bimg.getHeight(); y++) {
                c = new Color(bimg.getRGB(x, y));

                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();

                // apply black and white thresholds
                if (r < t_black && g < t_black && b < t_black)
                     bimg.setRGB(x, y, 0);
               
                else if (r > t_white && g > t_white && b > t_white)
                    bimg.setRGB(x, y, 255 << 16 | 255 << 8 | 255);
                  
                else
            
                    bimg.setRGB(x, y, r << 16 | g << 8 | b);
                
                       
            }
        
        return bimg;
        
    }         
    
   public static BufferedImage dropFileImage(InputStream isa,String duoifile,String loaidrop) throws IOException {
      
             Color c;
             int r, g, b;
             int toadoy1 = 0;
             float tyle = (float) 0.2;
             String loaixuly=null;

             // Chuyển sang BufferedImage .
             BufferedImage originalImage;
             originalImage = ImageIO.read(isa);
             BufferedImage bimg = null;
             Double chieucao=null;
             
             double tyle1=originalImage.getWidth()/originalImage.getHeight();
             if(originalImage.getWidth()>originalImage.getHeight() && tyle1>=1 && tyle1<2)
             {
                 loaixuly="A";
                 
             }
             else if(originalImage.getWidth()>originalImage.getHeight() && tyle1>=2  ){
                 
                loaixuly="B"; 
             }
             else{
                 
                 loaixuly="C"; 
                 
             }
              // Drop 1/3 hình .
             if(loaixuly.equalsIgnoreCase("A"))
             {
                chieucao = (originalImage.getWidth() / 2.4);
                int chieu = chieucao.intValue();
                bimg = originalImage.getSubimage(0, 0, originalImage.getWidth(), chieu);
             }
             else if(loaixuly.equalsIgnoreCase("B")){
 
                bimg = originalImage; 
                 
             }
             else{
                 
                 bimg=null;
                 
             }

             BufferedImage resizedImage = null;
             resizedImage = bimg; 

             return resizedImage;

    }
   
  public static String  layduongdanimage(String hethong) {
        String rootpath ;
        try {
           if (hethong.equalsIgnoreCase("win")) {
                rootpath = "D:\\home\\";

            } else {
                rootpath = "/var/home/";

            }
            return rootpath;
            
        } catch (Exception e) {
            return null;
        }
       

    }
 
  public static String  laydauNgancach(String hethong) {
            
         String rootpath ;
            try {
                if (hethong.equalsIgnoreCase("win")) {
                    rootpath = "\\";

                } else {
                    rootpath = "/";

                }

                return rootpath;
                
            } catch (Exception e) {
                return null;
            }
       

    }

 
 public static  Boolean storeImageServer(BufferedImage orgimage ,String filename,String hethong,String tenthumuc,String duoifile,String userid) throws IOException {
     
  
     //Lay thong tin ve file . 
     DateFormat df = new SimpleDateFormat("MMddyyyy");
     Date today = Calendar.getInstance().getTime();        
     String reportDate = df.format(today);
     String duongdanimage=layduongdanimage(hethong);
     String daungancachimage=laydauNgancach(hethong);
     String  paththumuc=duongdanimage+tenthumuc;
     String  pathfile=paththumuc+daungancachimage+reportDate+daungancachimage+userid;
     //Xoa thu muc.
    // Boolean kq=Xulykhac.xoathumuc(pathfile);
 
    
     Boolean kq1=false;//Xulykhac.taothumuc(paththumuc+daungancachimage+reportDate);
 
     Boolean kq2=false;//Xulykhac.taothumuc(pathfile);
 
     if(kq2){
         try {
             //Ghi image vao duong dan vua tao . 
           File fi =new File(pathfile+daungancachimage+filename+"."+duoifile);
                if(fi.exists()){
                    fi.delete();
                }
           ImageIO.write(orgimage, duoifile,fi);
           return true;
         } catch (Exception e) {
             return false;
         }
         
     }
     else{
          return false;
     }
     
 
   
 }
 
  
  public static BufferedImage convertRenderedImage(RenderedImage img) {
    if (img instanceof BufferedImage) {
        return (BufferedImage)img;  
    }   
    ColorModel cm = img.getColorModel();
    int width = img.getWidth();
    int height = img.getHeight();
    WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    Hashtable properties = new Hashtable();
    String[] keys = img.getPropertyNames();
    if (keys!=null) {
        for (int i = 0; i < keys.length; i++) {
            properties.put(keys[i], img.getProperty(keys[i]));
        }
    }
    BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
    img.copyData(raster);
    return result;
}
@SuppressWarnings("unchecked")  
public static String imgToBase64String(RenderedImage img, String formatName)
{
 
  ByteArrayOutputStream os = new ByteArrayOutputStream();

  try
  {
    ImageIO.write(img, formatName, os);
    String ketqua=Base64.getEncoder().encodeToString(os.toByteArray());
    return ketqua;
  }
  catch (final IOException ioe)
  {
    throw new UncheckedIOException(ioe);
  }
} 
@SuppressWarnings("unchecked") 
public static RenderedImage bufferedImageTorenderedImage(final BufferedImage img ){
   
    RenderedImage rImage      = (RenderedImage)img;
      
    return rImage;
    
}
 
@SuppressWarnings("unchecked")
public static BufferedImage  base64StringtoImg(String  stringsource) throws IOException
{
     // create a buffered image
        BufferedImage image = null;
        byte[] imageByte;
     
        //BASE64Decoder decoder = new BASE64Decoder();
        //imageByte = decoder.decodeBuffer(stringsource);
      //  ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
      //  image = ImageIO.read(bis);
      //  bis.close();
    
    return image;
}     
 
  public  static String comperssionfileimage(BufferedImage image,String fileoutpath,Float chiso)  {
 
    
       try {
      
            File compressedImageFile = new File(fileoutpath);
            OutputStream os =new FileOutputStream(compressedImageFile);

            Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
            ImageWriter writer = (ImageWriter) writers.next();

            ImageOutputStream ios = ImageIO.createImageOutputStream(os);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();

            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(chiso);
            writer.write(null, new IIOImage(image, null, null), param);

            os.close();
            ios.close();
            writer.dispose();
            
           return "T";
       } catch (Exception e) {
           return e.getMessage();
       }
    
   }
  
  public Boolean  uploadImageFtp(String filepath,String filename){
      try {
 
          FTPUploader ftpUploader = new FTPUploader(hostname, userftp, passftp);
          ftpUploader.uploadFile(filepath, filename+".jpg", "/");
          ftpUploader.disconnect();

          return true ;
      } catch (Exception ex) {
          return false ;
      }
      
	}
   

}
