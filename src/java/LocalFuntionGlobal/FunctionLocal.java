package LocalFuntionGlobal;

//import Bean.AlertCustom;
import ApiFunction.ApiDao.*;
import ConnectBean.ConnectionProvider;
import  EntitiesBean.*;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.RenderedImage;
import java.awt.image.BufferedImage;
 
 
public class FunctionLocal {
    
    public static List<DistrictList> listquanhuyen=new ArrayList<>();
    

    public static Number kiemtraketnoi(String dt, String lt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static InputStream convertFiletoInputstream(InputStream isa,String duoifile) throws IOException {
     
 
             //InputStream isa=filein.getInputstream();
             BufferedImage originalImage = null;
             try {
                if(duoifile.equalsIgnoreCase(".TIF"))
                {
                TIFFDecodeParam param = null;
                ImageDecoder dec = ImageCodec.createImageDecoder("tiff", isa, null);
                RenderedImage op = dec.decodeAsRenderedImage(0);
                HamUserAll sa =new HamUserAll();
                originalImage=sa.convertRenderedImage(op);
                }
                else{
                   
                 //  BufferedImage ourImage = null;
                   originalImage = ImageIO.read(isa);  
                 /*  Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
                   ImageWriter writer = (ImageWriter) writers.next();
                   ByteArrayOutputStream ios = new ByteArrayOutputStream();
                   writer.setOutput(ios);
                   ImageWriteParam param = writer.getDefaultWriteParam();
                   param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                   param.setCompressionQuality(0.005f);
                   writer.write(null, new IIOImage(originalImage, null, null), param);
                   InputStream is = new ByteArrayInputStream(ios.toByteArray());
                   writer.dispose();
                  */
                }
             } catch (Exception e) {
                 
             }
        
        
        
        try {

            //   BufferedImage originalImage = ImageIO.read(isa);
              //  BufferedImage originalImage = ImageIO.read(sourceimage);
               int type = originalImage.getType() == 0 ? BufferedImage.TYPE_BYTE_BINARY : originalImage.getType();
               // System.out.println(type);
               // BufferedImage SubImgage = originalImage.getSubimage(150, 150, 200, 200);
             //  BufferedImage originalCrop = originalImage.getSubimage(0, 100, originalImage.getWidth(), originalImage.getHeight()/3);
             //   BufferedImage resizeImageJpg = Xulyimage.resizeImage(originalImage, type,);//call to resize the image
              //   BufferedImage resizeImageJpg =Xulyimage.resizeImage(originalImage, originalImage.TYPE_INT_RGB, 440, 900);    
//               String  maso = FunctionLocal.scanBarcode(originalImage);
                //BufferedImage to ByteArrayInputStream
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(originalImage, "jpg", os);
                InputStream is = new ByteArrayInputStream(os.toByteArray());
               
               return is ;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
     
 
    
    }
 
    public String bangchu(Number sotien, String lang, String loaitien) {

        try {
            String ketqua;
            ConnectionProvider.reconnectdbastatic();
            Connection con = ConnectionProvider.getCon();
            String fnCall = "{call ? := KH.cspke_misc.FN_NUM2WORDS(?,?,?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.VARCHAR);
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.setString(2, lang);
            stm.setFloat(3, sotien.floatValue());
            stm.setString(4, loaitien);
            stm.execute();
            ketqua = (String) stm.getString(1);
            stm.close();
            con.close();
            return ketqua;

        } catch (SQLException ex) {

          //  Bean.SystemBean.proMessError(AlertCustom.timMatKetNoiMang);
            return "";

        }

    }
 
   public static BufferedImage resizeImage(BufferedImage originalImage, int type,int docao,int dorong) {
         int w;
         int h;
     
           w=dorong;
           h=docao;
        
        try {
        BufferedImage resizedImage =new BufferedImage(  w , h ,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
          //below three lines are for RenderingHints for better image quality at cost of higher processing time
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage, 0, 0, w, h, null);
        g.setBackground(Color.white);
        g.dispose();
         return resizedImage;   
       } catch (Exception e) {
         return null;
       }
 
    }
       

    public java.sql.Date chuyenngayUtiltoSql(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    public boolean insertBangTamBn(String idchinhanh, String sophieu, Number sott, String userid) {

        try {
            String ketqua;
            ConnectionProvider.reconnectdbastatic();
            Connection con = ConnectionProvider.getCon();
            String fnCall = "call KH.PKS_WEB_TRUCTUYEN.INSERT_TAMIN_BIENNHANTT(?,? ,?,?)";
            CallableStatement stm = con.prepareCall(fnCall);
//            stm.registerOutParameter(1, Types.VARCHAR);
            stm.registerOutParameter(3, Types.INTEGER);
            stm.setString(1, idchinhanh);
            stm.setString(2, sophieu);
            stm.setInt(3, sott.intValue());
            stm.setString(4, userid);
            stm.executeUpdate();
            // ketqua = (String) stm.getString(1) ; 
            stm.close();
            con.close();
            return true;

        } catch (SQLException ex) {

//            Bean.SystemBean.proMessError(AlertCustom.timMatKetNoiMang);
            return false;

        }

    }
 
     
    
     public static Number kttaikhoandoitac(String doitac, String loaitien, String sp) {

        try {
            Number ketqua;
            ConnectionProvider.reconnectdbastatic();
            Connection con = ConnectionProvider.getCon();
            String fnCall = "{call ? := KH.FUNCCHECKSOTIEN_DOITACTT(?,?,?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.NUMERIC,2);
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.registerOutParameter(3, Types.VARCHAR);
            stm.setString(2, doitac);
            stm.setString(3, loaitien);
            stm.setString(4, sp);
            stm.execute();
            ketqua = (Number) stm.getBigDecimal(1);
            stm.close();
            return ketqua;

        } catch (SQLException ex) {
 
            return 0;

        }

    }
     

        public static Number hanmucnhap( String loaitien ) {

        try {
            Number ketqua;
            ConnectionProvider.reconnectdbastatic();
            Connection con = ConnectionProvider.getCon();
            String fnCall = "{call ? := KH.PKS_WEB_TRUCTUYEN.FUNC_HANMUCNHAP(?)}";
            CallableStatement stm = con.prepareCall(fnCall);
            stm.registerOutParameter(1, Types.NUMERIC,2);
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.setString(2, loaitien);
            stm.execute();
            ketqua = (Number) stm.getBigDecimal(1);
            stm.close();
 
            return ketqua;

        } catch (SQLException ex) {
 
            return 0;

        }

    }
 
 
  public BufferedImage processImage(BufferedImage orgimage, int brightness, int contrast, int t_black, int t_white) {
        Color c;
        int r, g, b;
        int red10=0;
        int tam =0;
        BufferedImage bimg=orgimage;
        Double centimeters = orgimage.getHeight() * 2.54 / 96 ;
        float factor = (259f * (contrast + 255f)) / (255f * (259f - contrast));
        
         
          //;
          red10=Math.min(255, Math.max(0, tam/50-50));
        
      
        for (int x = 0; x < bimg.getWidth(); x++)
            for (int y = 0; y < bimg.getHeight(); y++) {
                c = new Color(bimg.getRGB(x, y));
                 // apply brightness and contrast
          /*      r = Math.round(factor * (c.getRed() - 128) + 128) + brightness;
                g = Math.round(factor * (c.getGreen() - 128) + 128) + brightness;
                b = Math.round(factor * (c.getBlue() - 128) + 128) + brightness;
                //limit to [0, 255] range
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                  */
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
       
       
                 
                // apply black and white thresholds
                if (r < t_black && g < t_black && b < t_black)
                     bimg.setRGB(x, y, 0);
               
                else if (r > t_white && g > t_white && b > t_white)
                    bimg.setRGB(x, y, 255 << 16 | 255 << 8 | 255);
                  
            /*    else
            
                    bimg.setRGB(x, y, r << 16 | g << 8 | b);
                */
                       
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
                
                 
               /* chieucao = (originalImage.getWidth() * 0.1);
                int chieu = chieucao.intValue();*/
                 
                 
                 
                 
                 
                bimg = originalImage;//originalImage.getSubimage(0, 0, originalImage.getWidth(), originalImage.getHeight() - 40);
                 
             }
             else{
                 
                 bimg=null;
                 
             }

             BufferedImage resizedImage = null;
             resizedImage = bimg;//.getSubimage(0, toadoy1, bimg.getWidth(), 200);

             return resizedImage;

    }
 
 public List<LocalModel.DmXacminhToday> dshosoxmtrongngay () {

        try {
          ApiTimkiemDao dmxcaminhtodayRest=new ApiTimkiemDao();
          List<LocalModel.DmXacminhToday> li=new ArrayList<>();
          li=dmxcaminhtodayRest.dsHsXacMinhtrongngay();
          return li;
        } catch (Exception e) {
            return null;
        }
    }
    
    
 
     
}
