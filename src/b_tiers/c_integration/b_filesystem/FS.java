package b_tiers.c_integration.b_filesystem;

//import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Table;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.IOUtils;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;

import a_main.RCMException;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;
import c_dto.Command;
import c_dto.NetworkCommand;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Riga;
import c_dto.b_real.Descrizione;
import c_dto.b_real.Documento;
import c_dto.b_real.DocumentoSub;
import c_dto.b_real.Parametro;
import c_dto.b_real.RettangoloPDF;
import c_dto.b_real.RettangoloPDFText;
import c_dto.b_real.RigaProdotto;
import c_dto.b_real.RigaProdottoSub;
import c_dto.b_real.RigaTesto;
import c_dto.b_real.RigaTestoSub;
import c_dto.b_real.TempoConsegna;
import c_dto.b_real.Titolo;
import c_dto.c_enum.IDCampo;
import c_dto.c_enum.TextAlign;
import d_utils.OSValidator;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
//import jcifs.smb.SmbFileOutputStream;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import javafx.scene.control.Alert.AlertType;

public class FS {
	private static final URL fontUrl = FS.class.getResource("font/Arial Bold.ttf");
	private static Font myBoldFont=null;
	
	private static final float size=14.5f;
	private static final float cellHeight=4.0f;
	private static final float titleSize=11.5f;
	
	private static void createTextElement(PdfContentByte cb, String txt, float y, RettangoloPDFText rect2) {
         BaseFont bf=null;
         float x;
			try {
//				bf = BaseFont.createFont(BaseFont.WINANSI, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//	    	    Font fontCell = null;
//	    	    Font fontCellWhite = null;
	    	    String sep = File.separator;
	    	    String fontPath ="font";
		    	File file = new File("");
	    	    if (OSValidator.isMac()) {
//	        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
//	        	    fontCell.setColor(0, 0, 255);
//	        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
//	        	    fontCellWhite.setColor(255, 255, 255);
					bf = BaseFont.createFont(fontUrl.toString(), BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);/*bf = BaseFont.createFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);*/
	    	    }
	    	    else if (OSValidator.isWindows()) {
//	        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+sep+ fontPath + sep+sep+ "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
//	        	    fontCell.setColor(0, 0, 255);
//	        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+sep+ fontPath + sep +sep+ "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
//	        	    fontCellWhite.setColor(255, 255, 255);
//					bf = BaseFont.createFont(file.getAbsolutePath() +sep+sep+ fontPath + sep +sep+ "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
					bf = BaseFont.createFont(fontUrl.toString(), BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);/*bf = BaseFont.createFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);*/
	    	    }
				
//				/*bf = BaseFont.createFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);*/
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				RCMException.showException(e);
			}
//	           float size = 10;
//	           float size = 16;
         cb.saveState();
         cb.beginText();
         cb.setFontAndSize(bf, size);
         cb.setColorFill(BaseColor.BLUE);
//         cb.showText(txt);
         
         switch (rect2.getTitleAlignment()) {
         case LEFT:
        	 	x = (float) (rect2.getX()+2);
                cb.showTextAligned(cb.ALIGN_LEFT, txt, x+(size/2), y-(size/2), 0.0f);
        	 	break;
         case CENTER:
     	 	x = (float) (rect2.getX()+(rect2.getWidth()/2));
            cb.showTextAligned(cb.ALIGN_CENTER, txt, x, y-(size/2), 0.0f);
        	 	break;
        	 default:
          	 	x = (float) (rect2.getX()+rect2.getWidth());
                cb.showTextAligned(cb.ALIGN_RIGHT, txt, x-(size/2), y-(size/2), 0.0f);
        		 break;
         }
         
         
         cb.endText();
         cb.restoreState();
		}

	
	
	private static void createText(PdfContentByte cb, String txt, float x, float y) {
        BaseFont bf=null;
		try {
			bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			RCMException.showException(e);
		}
//		int size=11;
        cb.saveState();
        cb.beginText();
        cb.setFontAndSize(bf, titleSize);
//        cb.showText(txt);
        cb.showTextAligned(cb.ALIGN_LEFT, txt, x, y, 0.0f);
        cb.endText();
        cb.restoreState();
	}
	
	private static void createRectangle(float x, float y, float width, float height, PdfContentByte canvas) {
        Rectangle rect = new Rectangle(x, y, width, height);
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(1);
        rect.setBorderColor(BaseColor.BLACK);
        canvas.rectangle(rect);
	}
	
	
	private static void createRectangle(RettangoloPDF rect, PdfContentByte canvas, float pWidth, float pHeight) {
	 	   float lx;
	 	   float ly;
	 	   float ux;
	 	   float uy;
			   lx=(float) rect.getX();
			   ly = (float) (pHeight-rect.getHeight());
			   ly-= (rect.getY());
			   
//			   ly=(float) (page.getHeight()-r.getY()-r.getHeight()+r.getTranslateY());
			   ux=(float) (lx+rect.getWidth());
			   uy=(float) (ly+rect.getHeight());
			   
				com.itextpdf.text.Rectangle innerR = new com.itextpdf.text.Rectangle(lx, ly, ux, uy);
				innerR.setBorder(com.itextpdf.text.Rectangle.BOX);
				innerR.setBorderWidth(1);
				innerR.setBorderColor(BaseColor.BLACK);
		        canvas.rectangle(innerR);
		        
		        
		        
		        BaseFont bf=null;
				try {
					bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
				} catch (DocumentException | IOException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				canvas.saveState();
				canvas.beginText();
				canvas.setFontAndSize(bf, 8.5f);
//		        cb.showText(txt);
				canvas.showTextAligned(canvas.ALIGN_LEFT, rect.getTitolo(), lx+2, uy-10, 0.0f);
				canvas.endText();
				canvas.restoreState();
		        
			   
		}
	
	public static void deletePDF(DTOBase kn) {
		// TODO Auto-generated method stub
		
//		FontFactory.register(fontUrl.toString(), "arialBold");
//		myBoldFont = FontFactory.getFont("arialBold");
		
			Documento n = (Documento) kn;
//		busObjDocumento.read(n);
		
//		Parametro param = (Parametro) busObjParametro.readAll().get(0);
 	   
// 	   Documento d = tblAziende.getItems().get(getTableRow().getIndex());
 	   
 	   
        try {    
     	   
            //now write the PDF content to the output stream
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-ddd")
                    .withLocale(Locale.ITALIAN);
//            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//                    .withLocale(Locale.ITALIAN);

                LocalDate date = formatter.parseLocalDate(n.getData());

//                System.out.println(date.getYear());  // 2012
//                System.out.println(date.getMonthOfYear()); // 8
//                System.out.println(date.getDayOfMonth());   // 18
            	   
          	   String filePath = getRootFolder();// + File.separator;
          	   
            	 filePath += n.getRiferimento().getAzienda().getNome() + File.separator;

          	filePath += n.getRiferimento().getAzienda().getNome() + "_" + date.getYear() + File.separator;

//       	  filePath="";
          	String fileName = "";
          	
          	
          	if (n.getRevisione()>0)
    	       	fileName += n.getDatarev() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
          	else
	       	fileName += n.getData() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
          	
	       	if (n.getRevisione()>0)
	       		fileName += " REV. " + n.getRevisione();
	       	
	       	fileName +=" x ";
//  	   		      
//       	fileName += n.getprodott1i().get(0).getProdotto().getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
       	fileName += n.getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
       	
       	
  	   		      
     	   fileName+= ".pdf";
     	   
     	   
     	   
     	    Files.delete(FileSystems.getDefault().getPath(filePath  + fileName));
     	   
        }catch(Exception e) {
//			RCMException.showException(e);
        }
		
	}


	public static void createPDF(DTOBase kn) {
		// TODO Auto-generated method stub
		
		FontFactory.register(fontUrl.toString(), "arialBold");
		myBoldFont = FontFactory.getFont("arialBold");
		
		if (kn instanceof Documento) {
			Documento n = (Documento) kn;
//		busObjDocumento.read(n);
		
//		Parametro param = (Parametro) busObjParametro.readAll().get(0);
 	   
// 	   Documento d = tblAziende.getItems().get(getTableRow().getIndex());
 	   
		 	   OutputStream outputStream = null;
		 	  SmbFileOutputStream outputStream2 = null;
 	   
        try {    
            //now write the PDF content to the output stream
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-ddd")
                    .withLocale(Locale.ITALIAN);
//            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//                    .withLocale(Locale.ITALIAN);

                LocalDate date = formatter.parseLocalDate(n.getData());

//                System.out.println(date.getYear());  // 2012
//                System.out.println(date.getMonthOfYear()); // 8
//                System.out.println(date.getDayOfMonth());   // 18	
            	   
          	   String filePath = getRootFolder();// + File.separator;
          	   
            	 filePath += n.getRiferimento().getAzienda().getNome() + File.separator;

          	filePath += n.getRiferimento().getAzienda().getNome() + "_" + date.getYear() + File.separator;

//       	  filePath="";
          	String fileName = "";
          	
          	
          	if (n.getRevisione()>0)
    	       	fileName += n.getDatarev() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
          	else
	       	fileName += n.getData() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
          	
	       	if (n.getRevisione()>0)
	       		fileName += " REV. " + n.getRevisione();
	       	
	       	fileName +=" x ";
//  	   		      
//       	fileName += n.getprodott1i().get(0).getProdotto().getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
       	fileName += n.getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
       	
       	
  	   		      
  	   		      
//  	   		      n.getprodott1i().get(0).getProdotto().getFornitore();
  	   		      
     	   
     	   
//     	   if (n.getRiferimento()!=null) {
//	        	   fileName += n.getRiferimento().getCognome();
//     		   
//     	   }
     	   fileName+= ".pdf";
//     	   String usrpsw = "gestionale:gestionale";
////      		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "gestionale", "gestionale");
//       		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(usrpsw);
//  	   SmbFile sambaFile = new SmbFile(filePath + "old" + fileName,auth);
//  	   
//  	   sambafi
//  	   
//  	   
//// 	   SmbFile sambaFile = new SmbFile(filePath,auth);
//  	 SmbFileOutputStream sfos = new SmbFileOutputStream(sambaFile);   
////     	   if (!sambaFile.exists()) {
////     		   sambaFile.mkdirs();
////     	   }
//// 		   sambaFile.createNewFile();
     	   
     	   
     	   
//     	   filePath="";//da rimuovere
           try {
////         	   outputStream = new FileOutputStream(filePath + "old" + fileName);
//         	   outputStream = sambaFile.getOutputStream();
////         	  outputStream2 = new SmbFileOutputStream(sambaFile.toString());
//         	   
////         	   File f =new File(filePath + fileName);
////         	   while (!f.canWrite()) {
////         		   if (!f.canWrite()) {
////     				  ButtonType btnYes = new ButtonType("OK");
////    				  Optional<ButtonType> scelta= null;
////       			
////    				  Alert alert= new Alert(AlertType.WARNING);
////    				  alert.setTitle("Attenzione!");
////    				  alert.setHeaderText("Per completare la registrazione è necessario");
//////    				  alert.setContentText("E' necessario selezionare un fornitore");
////    				  
////    				  
////    				  alert.getButtonTypes().setAll(btnYes);
////    				  
////
//////    				  scelta = alert.showAndWait();
////    				  alert.showAndWait();
////         		   }
////         	   }
//         	   
//////         	   outputStream = new FileOutputStream(filePath + fileName);
         	   outputStream = new FileOutputStream(filePath + "old" + fileName);
           } 
           catch(Exception e){
//        	   e.printStackTrace();
        	   try {
            	   new File(filePath).mkdirs();
             	   outputStream = new FileOutputStream(filePath + "old" + fileName);
        		   
        	   }
               catch(Exception e2){
            	   e2.printStackTrace();
//             	   outputStream = new FileOutputStream(filePath + fileName);
             }
//         	   outputStream = new FileOutputStream(filePath + fileName);
         }
 	   
     	   
// 	       public void writePdf(OutputStream outputStream) throws Exception {
    	   float lx;
    	   float ly;
    	   float ux;
    	   float uy;
    	   
    	   float imgWidth=50;
    	   float imgHeight=30;
    	   int level=0;
    	   
    	   float POINTS_PER_INCH = 72;
    	   float POINTS_PER_MM = 1 / (10 * 2.54f) * POINTS_PER_INCH;
//    	   Rectangle page = PageSize.A4.rotate();
    	   Rectangle page = new Rectangle(n.getTipo().getLayout().getPxlWidth(), n.getTipo().getLayout().getPxlHeight());
    	   Document doc = new Document(page);
    	   PdfWriter writer = PdfWriter.getInstance(doc, outputStream);
    	   doc.open();
    	   
    	   
    	   
    	   
//    	   newPage(doc, n);
//    	   int size=16;
    	   
    	   PdfContentByte cb = writer.getDirectContent();
//    	   doc.open();
    	   doc.newPage();
    	   
    	   
        PdfContentByte canvas = writer.getDirectContent();
        
//// 	   com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(ClassLoader.getSystemResource("b_tiers/c_integration/b_filesystem/logorcm.png").getPath());
//        
////        new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/resources/" + filename)))  
//        
//        
//        
//// 	   URL url = FS.class.getResource("/b_tiers/c_integration/b_filesystem/logorcm.png");
//        InputStreamReader input = new InputStreamReader(FS.class.getResourceAsStream("b_tiers/c_integration/b_filesystem/logorcm.png"));
        URL myUrl = FS.class.getResource("img/logorcm.png");
        
        Image img = Image.getInstance(myUrl);
    	   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
    	   img.scaleAbsolute(50, 50);
    	   doc.add(img);
    	   
    	   int countSplit=0;
    	   int[] columnsSize;
    	   ArrayList<RettangoloPDFText> columns = new ArrayList<>();
    	   for (RettangoloPDFText r : n.getTipo().getLayout().getListaTesto()) {
    		   if (r.isShowSplittable()) {
    			   countSplit++;
    			   columns.add(r);
    		   }
    		   
    	   }
//		   columns.addAll(n.getTipo().getLayout().getListaTesto());
		   
		   Collections.sort(columns);
   	    float tableYPos=page.getHeight() - (float) columns.get(0).getY();
		   
    	   		columnsSize=new int[countSplit];
    	   		for (int i=0; i< columnsSize.length;i++) {
    	   			columnsSize[i]=(int) columns.get(i).getWidth();
    	   		}
    	   
    	    PdfPTable tblProdottiBase2 = new PdfPTable(countSplit);
//    	    tblProdottiBase2.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
    	    tblProdottiBase2.setWidths(columnsSize);
    	    tblProdottiBase2.setTotalWidth(page.getWidth());
    	    tblProdottiBase2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
    	    tblProdottiBase2.getDefaultCell().setFixedHeight(cellHeight);
    	    tblProdottiBase2.setSplitLate(false);
   	   
    	   
    	    PdfPCell cell =null;
//    	    float tableHeight=page.getHeight()-(imgHeight*level)-1-imgHeight-12-imgHeight;
    	    float tableHeight=(float) columns.get(0).getHeight();
    	    float cellheight=0;
    	    
    	    HashMap<Integer, Integer> rowPerPage = new HashMap<>();
    	    int pagina=1;
    	    int nRiga=0;
    	    float totDocumento=0.0f;
    	    float totRiga=0.0f;
    	    
    	    
//    	    InputStream in = FS.class.getResourceAsStream("/addons/font/arial bold.ttf"); 
//    	    BufferedReader bufReader = new BufferedReader(new InputStreamReader(in));
//    	    byte[] fontBytes = IOUtils.toByteArray(in); // from Apache Commons IO
    	    
//    	    InputStream in=BaseFont.getResourceStream("/addons/font/arial bold.ttf");
    	    
//    	    Font fontCell = FontFactory.getFont("/addons/font/arial bold.ttf", size, Font.NORMAL);
//    	    fontCell.setColor(0, 0, 255);
//    	    Font fontCellWhite = FontFactory.getFont("/addons/font/arial bold.ttf", size, Font.NORMAL);
//    	    fontCellWhite.setColor(255, 255, 255);
//    	    File file = new File("");
    	    Font fontCell = null;
    	    Font fontCellWhite = null;
    	    String sep = File.separator;
    	    String fontPath ="font";
	    	File file = new File("");
    	    if (OSValidator.isMac()) {
//        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
        	    fontCell =FontFactory.getFont("arialBold");
        	    fontCell.setColor(0, 0, 255);
//        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
        	    fontCellWhite =FontFactory.getFont("arialBold");
        	    fontCellWhite.setColor(255, 255, 255);
    	    }
    	    else if (OSValidator.isWindows()) {
//        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
        	    fontCell =FontFactory.getFont("arialBold");
        	    fontCell.setColor(0, 0, 255);
//        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
        	    fontCellWhite =FontFactory.getFont("arialBold");
        	    fontCellWhite.setColor(255, 255, 255);
    	    	
    	    }
    	    
    	    
    	    
    	    
    	    
    	    
//    		public List<Riga> getRighe() {
//    		
//    		
    		List<RigaProdotto>  prodotti= n.getProdotti();
    		List<RigaTesto>  testo=n.getTesto();
  		
    		ArrayList<Riga> lista = new ArrayList<>();
    		
    		int z=0;
    		int j=0;
    		int k=0;
    		RigaProdotto rigaA;
    		RigaTesto rigaB;
    		
    		while (z< prodotti.size() && j< testo.size()) {
    			rigaA=prodotti.get(z);
    			rigaB=testo.get(j);
    			
    			if (rigaA.getProgressivo() < rigaB.getProgressivo()) {
    				lista.add(rigaA);
    				z++;
    			}
    			else {
    				lista.add(rigaB);
    				j++;
    			}
    		}
    		while (z< prodotti.size()) {
    			lista.add(prodotti.get(z++));
    		}
    		while (j< testo.size()) {
    			lista.add(testo.get(j++));
    		}
    		
    		
    		Collections.sort(lista);
    //	
//    		return lista;
//    	}
  	    
    	    
    	    
    	    
//    	    for (Riga r : n.getRighe()) {
    	    for (Riga r : lista) {
    	    	
    	    	
    	    	for (RettangoloPDFText str : columns) {
    	    		
  	    	      switch(str.getIDCampo()) {
    	        case PROGRESSIVO:
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            if (r instanceof RigaProdotto) {
//    	    	        	progressivo++;
	    		        cell.addElement(new Phrase(((RigaProdotto) r).getItem() + "", fontCell));
//    	    		        cell.addElement(new Phrase(((RigaProdotto) r).getItem() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//    	    		        cell.addElement(new Phrase(progressivo + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
    	            }
    	            else {
    	                cell.addElement(new Phrase("", fontCell));
    	            	
    	            }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            tblProdottiBase2.addCell(cell);
    	            break;
    	        case DESCRIZIONE:
    	            String sigla_descr="";
    	            String hexColor=null;
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            if (r instanceof RigaProdotto) {
    	            	sigla_descr = ((RigaProdotto) r).getProdotto().getNome() + "\n";
    	    	        	if (((RigaProdotto) r).getProdotto().getDescrizioni() != null && ((RigaProdotto) r).getProdotto().getDescrizioni().size()>0) {
    	    	        		sigla_descr+= ((Descrizione)((RigaProdotto) r).getProdotto().getDescrizioni().get(0)).getDescrizione();
    	    	        	}
    	    	        	
//    	    	        	if (((RigaProdotto) r).getTempo()!=null) {
//    	    	        		sigla_descr+= "\n" + ((RigaProdotto) r).getTempo().getNome();
//    	    	        	}
    	    	        	
    	    	        	
    	    	            cell.addElement(new Phrase(sigla_descr, fontCell));
    	    	    }
    	    	    else {
    	        		sigla_descr+= ((RigaTesto) r).getText();
    	        		hexColor = ((RigaTesto)r).getColorHex();
    	        		
        	            if (sigla_descr.length()==0) {
        	            	sigla_descr="_";
        	            cell.addElement(new Phrase(sigla_descr, fontCellWhite));
        	            }
        	            else {
            	            cell.addElement(new Phrase(sigla_descr, fontCell));
        	            	
        	            }
    	    	    }
    	        	
//    	            	cell.setMinimumHeight(cellHeight);
    	            
    	            if (hexColor!=null) {
    	            	int rr,gg,bb;
    	            	rr=Integer.valueOf( hexColor.substring( 1, 3 ), 16 );
    	            gg=Integer.valueOf( hexColor.substring( 3, 5 ), 16 );
    	            	bb=Integer.valueOf( hexColor.substring( 5, 7 ), 16 );
    	            	cell.setBackgroundColor(new BaseColor(rr,gg,bb));
    	            }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            tblProdottiBase2.addCell(cell);
    	            break;
    	        case QUANTITA:
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            if (r instanceof RigaProdotto) {
//    	            	progressivo++;
    	            cell.addElement(new Phrase(((RigaProdotto) r).getQuantita() + "", fontCell));
    	    	    }
    	    	    else {
    	    	        cell.addElement(new Phrase("", fontCell));
    	    	    	
    	    	    }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            tblProdottiBase2.addCell(cell);
    	            break;
    	        case PREZZO:
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            
    	            if (r instanceof RigaProdotto) {
//    	            	progressivo++;
    	            cell.addElement(new Phrase(NumberFormat.getCurrencyInstance(Locale.ITALY).format(((RigaProdotto) r).getPrezzo()) + "", fontCell));
    	    	    }
    	    	    else {
    	    	        cell.addElement(new Phrase("", fontCell));
    	    	    	
    	    	    }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            tblProdottiBase2.addCell(cell);
    	            break;
//    	        case SCONTO:
//    	            break;
    	        case TOTRIGA:
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            if (r instanceof RigaProdotto) {
        	        	totRiga=(float) (((RigaProdotto) r).getQuantita() * ((RigaProdotto) r).getPrezzo());
        	        	totDocumento+=totRiga;
//    	            	progressivo++;
//        	            cell.addElement(new Phrase(((RigaProdotto) r).getQuantita() * ((RigaProdotto) r).getPrezzo() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
        	            cell.addElement(new Phrase(NumberFormat.getCurrencyInstance(Locale.ITALY).format(totRiga) + "", fontCell));
    	    	    }
    	    	    else {
    	    	        cell.addElement(new Phrase("", fontCell));
    	    	    	
    	    	    }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            
    	            
    	            tblProdottiBase2.addCell(cell);
    	            break;
    	        case TEMPI:
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            if (r instanceof RigaProdotto) {
    	            	TempoConsegna tempo = ((RigaProdotto)r).getTempo();
    	            	
    	            	if (tempo!=null)
        	            cell.addElement(new Phrase(tempo.getNome() + "", fontCell));
        	    	    else 
        	    	        cell.addElement(new Phrase("", fontCell));
    	    	    }
    	    	    else {
    	    	        cell.addElement(new Phrase("", fontCell));
    	    	    	
    	    	    }
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            
    	            
    	            tblProdottiBase2.addCell(cell);
    	            break;
    	        case TOTMERCE:
    	            break;
    	        case IMPONIBILE:
    	            break;
    	        case TOTSCONTO:
    	            break;
    	        case IVA:
    	            break;
    	        case TOTIVA:
    	            break;
    	        case TOTALE:
    	        		break;
    	        default:
    	        	//campo vuoto
    	            cell = new PdfPCell();
    	            cell.setBorder(0);
    	            cell.addElement(new Phrase("", fontCell));
//    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//    	            cell.setPadding(5);
    	            tblProdottiBase2.addCell(cell);
    	            break;
  	    	      
  	    	      }
    	        	
    	    	}
    	    	
        	
            
            
            
            
            
            
            
            
            
            
            cellheight+=tblProdottiBase2.getRowHeight(nRiga++);
//            if (r instanceof RigaTesto) {
//            	//ricavo l'altezza della riga precedente (il cursore già si è spostato)
//                cellheight+=tblProdottiBase.getRowHeight(nRiga-1);
//            }
            if (cellheight < tableHeight) {
            		Integer row =rowPerPage.get(pagina);
            		if (row==null) {
            			rowPerPage.put(pagina, 1);
            		}
            		else {
            			row++;
            			rowPerPage.put(pagina, row);
            		}
            		
            }
            else {
                cellheight=tblProdottiBase2.getRowHeight(nRiga-1);
                
            	pagina++;
        		Integer row =rowPerPage.get(pagina);
        		if (row==null) {
        			row=rowPerPage.get(pagina-1)+1;
        			rowPerPage.put(pagina, row);
        		}
        		else {
        			row++;
        			rowPerPage.put(pagina, row);
        		}
            }
        	
        	
//            PdfPTable tblProdotti = new PdfPTable(6);
//            //Per rimuovere i bordi dalle celle
//            tblProdotti.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//            
//            tblProdotti.setTotalWidth(page.getWidth()-2);
//            tblProdotti.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
//            PdfPCell tblCell = new PdfPCell();
//        	tblProdotti.addCell(r.getProgressivo() + "");
//        	String sigla_descr = r.getProdotto().getNome() + "\n";
//        	if (r.getProdotto().getDescrizioni() != null && r.getProdotto().getDescrizioni().size()>0) {
//        		sigla_descr+= ((Descrizione)r.getProdotto().getDescrizioni().get(0)).getDescrizione();
//        	}
////        	tblProdotti.addCell(r.getProdotto().getNome() + "\n" + r.getProdotto().getDescrizioni().get(0));
//        	tblProdotti.addCell(sigla_descr);
//        	tblProdotti.addCell(r.getQuantita() + "");
//        	tblProdotti.addCell(r.getPrezzo() + "");
//        	tblProdotti.addCell("");
//        	tblProdotti.addCell("totale");
////          tblProdotti.completeRow();
//        	tblProdottiBase.addCell(tblProdotti);
        	
        }
    	   
    	    int start=-1;
    	    int end=0;
    	    Iterator<Entry<Integer, Integer>> it = rowPerPage.entrySet().iterator();
    	    
    	    
    		Entry<Integer, Integer> rowAtPage= it.next();
    	    while (it.hasNext()) {
    	    	start+=1;
    	    	end = rowAtPage.getValue();
////    	      tblProdottiBase2.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//        	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableHeight, canvas);
    	    	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableYPos, canvas);
//    	      doc.newPage();
    	      start=end-1;
    	  	rowAtPage = it.next();
    	    
    	    
    	  	for (RettangoloPDF rect: n.getTipo().getLayout().getListaRect()) {
    	    	   lx=(float) rect.getX();  
    	    	      ux=(float) (rect.getX()+rect.getWidth());
    	    	      
//    	    	      ly=page.getHeight()-(imgHeight*level)-1;
    	    	      ly=(float) (page.getHeight()-rect.getHeight()-rect.getY());
//    	    	      uy=page.getHeight()-1;
    	    	      uy=(float) (page.getHeight()-rect.getY());
        	    createRectangle(lx, ly, ux, uy,  canvas);
        	    createText(cb, rect.getTitolo() , lx+2,uy-7);
    	  	}
    	  	
    	  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
 	    	   lx=(float) rect2.getX();  
	    	      ux=(float) (rect2.getX()+rect2.getWidth());
	    	      
//	    	      ly=page.getHeight()-(imgHeight*level)-1;
	    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//	    	      uy=page.getHeight()-1;
	    	      uy=(float) (page.getHeight()-rect2.getY());
	    	      String txt="";
	    	      switch(rect2.getIDCampo()) {
	    	        case TIPO:
	    	        		txt=n.getTipo().getVocefile();
	    	            break;
	    	        case NUMERO:
	    	        	txt=n.getNumero();
	    	        	if (n.getRevisione()>0)
	    	        		txt+= " REV. " + n.getRevisione();
	    	            break;
	    	        case DATA://
	    	        	if (n.getRevisione()>0)
	    	        		txt=n.getDatarev();
	    	        	else
	    	        	txt=n.getData();
	    	        	
	    	            DateTimeFormatter formatter2 = DateTimeFormat.forPattern("yyyy-MM-ddd")
	    	                    .withLocale(Locale.ITALIAN);
//	    	            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//	    	                    .withLocale(Locale.ITALIAN);

	    	                LocalDate date2 = formatter2.parseLocalDate(txt);
    	        	
	    				String anno = String.valueOf(date2.getYear());
	    				String mese = String.valueOf(date2.getMonthOfYear());
	    				if (Integer.parseInt(mese)<10){
	    					mese= "0" + mese;
	    				}
	    				String giorno = String.valueOf(date2.getDayOfMonth());
	    				if (Integer.parseInt(giorno)<10){
	    					giorno= "0" + giorno;
	    				}
	    	        	
	    	        	
	    	        	txt=giorno + "/" + mese + "/" + anno;
    	        	
	    	        	
	    	        	
	    	            break;
//	    	        case PAGINA:
//	    	        	txt="/";
//	    	            break;
	    	        case PAGAMENTO:
	    	        	txt=n.getPagamento().getNome();
	    	            break;
	    	        case TRASPORTO:
	    	        	txt=n.getTrasporto().getNome();
	    	            break;
	    	        case RIFERIMENTO:
	    	        	Titolo t = n.getRiferimento().getTitolo();
	    	        	
	    	        	if (t!=null)
	    	        		txt=n.getRiferimento().getTitolo() + " " + n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
	    	        	else
		    	        	txt=n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
	    	            break;
	    	        case CLIENTE:
	    	        	txt=n.getRiferimento().getAzienda().toString();
	    	            break;
	    	        case FORNITORE:
//	    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
	    	        	txt=n.getFornitore().toString();
	    	            break;
	    	        case PROGRESSIVO:
	    	            break;
	    	        case DESCRIZIONE:
	    	            break;
	    	        case QUANTITA:
	    	            break;
	    	        case PREZZO:
	    	            break;
	    	        case SCONTO:
	    	            break;
	    	        case TOTRIGA:
	    	            break;
//	    	        case TOTMERCE:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//	    	            break;
//	    	        case IMPONIBILE:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//	    	            break;
//	    	        case TOTSCONTO:
//	    	            break;
//	    	        case IVA:
//	    	        	txt="22 %";
//	    	            break;
//	    	        case TOTIVA:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
//	    	            break;
	    	        default:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
	    	            break;
	    	      }
	    	      
	    	      
// 	    createRectangle(lx, ly, ux, uy,  canvas);
 	    createTextElement(cb, txt ,uy,rect2);
    	  	}
    	  	
    	  	doc.newPage();
    	  	
    	  	level=0;
    	  	
//    		   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//    		   img.scaleAbsolute(50, 50);
//    		   doc.add(img);

    	//writer.close();
    	 

    	    }
    	    
    	    
    	  	for (RettangoloPDF rect: n.getTipo().getLayout().getListaRect()) {
 	    	   lx=(float) rect.getX();  
 	    	      ux=(float) (rect.getX()+rect.getWidth());
 	    	      
// 	    	      ly=page.getHeight()-(imgHeight*level)-1;
 	    	      ly=(float) (page.getHeight()-rect.getHeight()-rect.getY());
// 	    	      uy=page.getHeight()-1;
 	    	      uy=(float) (page.getHeight()-rect.getY());
     	    createRectangle(lx, ly, ux, uy,  canvas);
     	    createText(cb, rect.getTitolo() , lx+2,uy-7);
 	  	}
    	    
    		start+=1;
    		end = rowAtPage.getValue();
////      	  tblProdottiBase2.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//      	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableHeight, canvas);
   	   
    	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableYPos, canvas);
   	   
    	   
    	   
  	  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
	    	   lx=(float) rect2.getX();  
	    	      ux=(float) (rect2.getX()+rect2.getWidth());
	    	      
//	    	      ly=page.getHeight()-(imgHeight*level)-1;
	    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//	    	      uy=page.getHeight()-1;
	    	      uy=(float) (page.getHeight()-rect2.getY());
	    	      String txt="";
	    	      switch(rect2.getIDCampo()) {
	    	        case TIPO:
	    	        		txt=n.getTipo().getVocefile();
	    	            break;
	    	        case NUMERO:
	    	        	txt=n.getNumero();
	    	        	if (n.getRevisione()>0)
	    	        		txt+= " REV. " + n.getRevisione();
	    	            break;
	    	        case DATA:
	    	        	
	    	        	System.out.print("");
	    	        	System.out.print("");
	    	        	
	    	        	if (n.getRevisione()>0)
	    	        		txt=n.getDatarev();
	    	        	else
	    	        	txt=n.getData();
	    	        	
	    	            DateTimeFormatter formatter2 = DateTimeFormat.forPattern("yyyy-MM-ddd")
	    	                    .withLocale(Locale.ITALIAN);
//	    	            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//	    	                    .withLocale(Locale.ITALIAN);

	    	                LocalDate date2 = formatter2.parseLocalDate(txt);
    	        	
	    				String anno = String.valueOf(date2.getYear());
	    				String mese = String.valueOf(date2.getMonthOfYear());
	    				if (Integer.parseInt(mese)<10){
	    					mese= "0" + mese;
	    				}
	    				String giorno = String.valueOf(date2.getDayOfMonth());
	    				if (Integer.parseInt(giorno)<10){
	    					giorno= "0" + giorno;
	    				}
	    	        	
	    	        	
	    	        	txt=giorno + "/" + mese + "/" + anno;
	    	            break;
//	    	        case PAGINA:
//	    	        	txt="/";
//	    	            break;
	    	        case PAGAMENTO:
	    	        	txt=n.getPagamento().getNome();
	    	            break;
	    	        case TRASPORTO:
	    	        	txt=n.getTrasporto().getNome();
	    	            break;
	    	        case RIFERIMENTO:
	    	        	Titolo t = n.getRiferimento().getTitolo();
	    	        	
	    	        	if (t!=null)
	    	        		txt=n.getRiferimento().getTitolo() + " " + n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
	    	        	else
		    	        	txt=n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
	    	            break;
	    	        case CLIENTE:
	    	        	txt=n.getRiferimento().getAzienda().toString();
	    	            break;
	    	        case FORNITORE:
//	    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
	    	        	txt=n.getFornitore().toString();
	    	            break;
	    	        case PROGRESSIVO:
	    	            break;
	    	        case DESCRIZIONE:
	    	            break;
	    	        case QUANTITA:
	    	            break;
	    	        case PREZZO:
	    	            break;
	    	        case SCONTO:
	    	            break;
	    	        case TOTRIGA:
	    	            break;
//	    	        case TOTMERCE:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//	    	            break;
//	    	        case IMPONIBILE:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//	    	            break;
//	    	        case TOTSCONTO:
//	    	            break;
//	    	        case IVA:
//	    	        	txt="22 %";
//	    	            break;
//	    	        case TOTIVA:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
//	    	            break;
	    	        default:
//	    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
	    	            break;
	    	      }
	    	      
	    	      
//	    createRectangle(lx, ly, ux, uy,  canvas);
	    createTextElement(cb, txt ,uy,rect2);
 	  	}
    	   
    	   
    	   
    	   
//    	   for (RettangoloPDF r : n.getTipo().getLayout().getListaRect()) {
//			   createRectangle(r, canvas, page.getWidth(), page.getHeight());
//
////    		   createRectangle2(r,canvas, n.getTipo().getLayout().getPxlWidth(), n.getTipo().getLayout().getPxlHeight());
//    	   }
    	   
    	   
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   /********************************************************************/
    	   
    	   
    	   
    	   
    	   
    	   
    	   
//    	   level++;
//    //primo rettangolo in cima 
//    	   lx=imgWidth*1.1f;  
//     ly=page.getHeight()-(imgHeight*level)-1;
//     ux=page.getWidth()-1;
//     uy=page.getHeight()-1;
//     createRectangle(lx, ly, ux, uy,  canvas);
//     
//     
//    
//       
//     //tipo documento
//     level++;
//    lx=imgWidth*1.1f;  
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=page.getWidth()/2;
//    uy=page.getHeight()-imgHeight-1;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Tipo documento", lx+2,uy-7);
//    createTextElement(cb, n.getTipo().getVocefile(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//    
//    //writer.close();
//        
//     //numero documento   
//    lx=(page.getWidth()/2);  
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Numero", lx+2,uy-7);
//    createTextElement(cb, n.getNumero(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//    
//    //data  
//    lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Data", lx+2,uy-7);
////    createTextElement(cb, n.getData(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//    DecimalFormat df = new DecimalFormat("00");
//    createTextElement(cb, df.format(date.getDayOfMonth()) + "/" + df.format(date.getMonthOfYear()) + "/" + date.getYear(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//    
//    	   
//    //num pagina  
//    lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=(page.getWidth()-1);
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Pagina", lx+2,uy-7);
//    
//    
//    
//    
//    
//    level++;
//    //pagamento
//    lx=1;  
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=page.getWidth()/2;
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//    createTextElement(cb, n.getPagamento().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//   
//    
//    //trasporto
//    lx=page.getWidth()/2;  
//    ly=page.getHeight()-(imgHeight*level)-1;
//    ux=(page.getWidth()-1);
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Modalità di trasporto", lx+2,uy-7);
//    createTextElement(cb, n.getTrasporto().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//    
//    
//    //cliente
//    level++;
//    lx=1;  
//    ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    ux=(page.getWidth()/3)+1;
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//       createText(cb, "Offerta riservata a:", lx+2,uy-7);
//    createTextElement(cb, n.getRiferimento().getAzienda().getNome(), 2+lx,-17+uy,cb.ALIGN_LEFT);
//    String txtRiferimento="";
//    if (n.getRiferimento().getTitolo()!=null)
//    		txtRiferimento+=n.getRiferimento().getTitolo().getTitolo();
//    
//    if(n.getRiferimento().getCognome()!=null) 
//    	txtRiferimento+=n.getRiferimento().getCognome();
//    
//    if(n.getRiferimento().getNome()!=null) 
//    	txtRiferimento+=n.getRiferimento().getNome();
//    
//////    createTextElement(cb, n.getRiferimento().getTitolo().getTitolo() + " " + n.getRiferimento().getCognome() + " " + n.getRiferimento().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_RIGHT);
////    createTextElement(cb, txtRiferimento, (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_RIGHT);
//    
//    //nfornitore
//    lx=page.getWidth()/3+1;  
//    ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    ux=(page.getWidth()/3)*2;
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Riferimento:", lx+2,uy-7);
////    
////    ColumnText	ct = new ColumnText(cb);
////    
////    
//////    Phrase ph = new Phrase(txtRiferimento, BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 10);
////    Font f =new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
////    f.setSize(10);
////    f.setColor(BaseColor.BLUE);
////    Phrase ph = new Phrase(txtRiferimento, f);
////    ct.setSimpleColumn(ph, 2+lx, 2+lx, ly+1,ux-2,uy-1,0);
////    ct.setAlignment(Element.ALIGN_LEFT);
////    ct.setText(ph);
////    ct.go();
////    
////    
////    
//    createTextElement(cb, txtRiferimento, 2+lx,-17+uy,cb.ALIGN_LEFT);
//    //nfornitore
//    lx=(page.getWidth()/3)*2;  
//    ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    ux=(page.getWidth()-1);
//    uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Ordine da intestare a:", lx+2,uy-7);
//    createTextElement(cb, n.getprodott1i().get(0).getProdotto().getFornitore().getNome(), 2+lx,-17+uy,cb.ALIGN_LEFT);
////    createTextElement(cb, n.getRiferimento().getAzienda().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_LEFT);
//    
//    
////    PdfPTable tblProdottiBase = new PdfPTable(1);
//    PdfPTable tblProdottiBase = new PdfPTable(6);
//    tblProdottiBase.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
////    tblProdottiBase.setWidthPercentage(99);
//    tblProdottiBase.setTotalWidth(page.getWidth()-1);
//    tblProdottiBase.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//    tblProdottiBase.setSplitLate(false);
//    PdfPCell cell =null;
//    float tableHeight=page.getHeight()-(imgHeight*level)-1-imgHeight-12-imgHeight;
//    float cellheight=0;
//    
//    HashMap<Integer, Integer> rowPerPage = new HashMap<>();
//    int pagina=1;
//    int nRiga=0;
//    
////    int progressivo=0;
//    
//    
//    for (Riga r : n.getRighe()) {
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        if (r instanceof RigaProdotto) {
////	        	progressivo++;
//		        cell.addElement(new Phrase(((RigaProdotto) r).getItem() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
////		        cell.addElement(new Phrase(progressivo + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//        }
//        else {
//            cell.addElement(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//        	
//        }
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        tblProdottiBase.addCell(cell);
//    	
//    	
//        String sigla_descr="";
//        String hexColor=null;
//        if (r instanceof RigaProdotto) {
//        	sigla_descr = ((RigaProdotto) r).getProdotto().getNome() + "\n";
//	        	if (((RigaProdotto) r).getProdotto().getDescrizioni() != null && ((RigaProdotto) r).getProdotto().getDescrizioni().size()>0) {
//	        		sigla_descr+= ((Descrizione)((RigaProdotto) r).getProdotto().getDescrizioni().get(0)).getDescrizione();
//	        	}
//	    }
//	    else {
//    		sigla_descr+= ((RigaTesto) r).getText();
//    		hexColor = ((RigaTesto)r).getColorHex();
//	    }
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        cell.addElement(new Phrase(sigla_descr, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//        if (sigla_descr.length()==0)
//        	cell.setFixed1Height(12);
//        
//        if (hexColor!=null) {
//        	int rr,gg,bb;
//        	rr=Integer.valueOf( hexColor.substring( 1, 3 ), 16 );
//        gg=Integer.valueOf( hexColor.substring( 3, 5 ), 16 );
//        	bb=Integer.valueOf( hexColor.substring( 5, 7 ), 16 );
//        	cell.setBackgroundColor(new BaseColor(rr,gg,bb));
//        }
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        tblProdottiBase.addCell(cell);
//    	
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        if (r instanceof RigaProdotto) {
////        	progressivo++;
//        cell.addElement(new Phrase(((RigaProdotto) r).getQuantita() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    }
//	    else {
//	        cell.addElement(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    	
//	    }
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        tblProdottiBase.addCell(cell);
//    	
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        
//        if (r instanceof RigaProdotto) {
////        	progressivo++;
//        cell.addElement(new Phrase(((RigaProdotto) r).getPrezzo() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    }
//	    else {
//	        cell.addElement(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    	
//	    }
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        tblProdottiBase.addCell(cell);
//    	
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        cell.addElement(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        tblProdottiBase.addCell(cell);
//    	
//    	
//        cell = new PdfPCell();
//        cell.setBorder(0);
//        if (r instanceof RigaProdotto) {
////        	progressivo++;
//        cell.addElement(new Phrase(((RigaProdotto) r).getQuantita() * ((RigaProdotto) r).getPrezzo() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    }
//	    else {
//	        cell.addElement(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    	
//	    }
////        cell.setBorderColor(BaseColor.LIGHT_GRAY);
////        cell.setPadding(5);
//        
//        
//        tblProdottiBase.addCell(cell);
//        
//        cellheight+=tblProdottiBase.getRowHeight(nRiga++);
////        if (r instanceof RigaTesto) {
////        	//ricavo l'altezza della riga precedente (il cursore già si è spostato)
////            cellheight+=tblProdottiBase.getRowHeight(nRiga-1);
////        }
//        if (cellheight < tableHeight) {
//        		Integer row =rowPerPage.get(pagina);
//        		if (row==null) {
//        			rowPerPage.put(pagina, 1);
//        		}
//        		else {
//        			row++;
//        			rowPerPage.put(pagina, row);
//        		}
//        		
//        }
//        else {
//            cellheight=tblProdottiBase.getRowHeight(nRiga-1);
//            
//        	pagina++;
//    		Integer row =rowPerPage.get(pagina);
//    		if (row==null) {
//    			row=rowPerPage.get(pagina-1)+1;
//    			rowPerPage.put(pagina, row);
//    		}
//    		else {
//    			row++;
//    			rowPerPage.put(pagina, row);
//    		}
//        }
//    	
//    	
////        PdfPTable tblProdotti = new PdfPTable(6);
////        //Per rimuovere i bordi dalle celle
////        tblProdotti.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
////        
////        tblProdotti.setTotalWidth(page.getWidth()-2);
////        tblProdotti.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
////        PdfPCell tblCell = new PdfPCell();
////    	tblProdotti.addCell(r.getProgressivo() + "");
////    	String sigla_descr = r.getProdotto().getNome() + "\n";
////    	if (r.getProdotto().getDescrizioni() != null && r.getProdotto().getDescrizioni().size()>0) {
////    		sigla_descr+= ((Descrizione)r.getProdotto().getDescrizioni().get(0)).getDescrizione();
////    	}
//////    	tblProdotti.addCell(r.getProdotto().getNome() + "\n" + r.getProdotto().getDescrizioni().get(0));
////    	tblProdotti.addCell(sigla_descr);
////    	tblProdotti.addCell(r.getQuantita() + "");
////    	tblProdotti.addCell(r.getPrezzo() + "");
////    	tblProdotti.addCell("");
////    	tblProdotti.addCell("totale");
//////      tblProdotti.completeRow();
////    	tblProdottiBase.addCell(tblProdotti);
//    	
//    	
//    	
//    }
//    
//    
//    int start=-1;
//    int end=0;
//    Iterator<Entry<Integer, Integer>> it = rowPerPage.entrySet().iterator();
//    
//    
//	Entry<Integer, Integer> rowAtPage= it.next();
//    while (it.hasNext()) {
//    	start+=1;
//    	end = rowAtPage.getValue();
//      tblProdottiBase.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
////      doc.newPage();
//      start=end-1;
//  	rowAtPage = it.next();
//  	
//    //colonna posizione
//    lx=1;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/16;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Item", lx+2,uy-7);
//    
//    //colonna sigla + descrizione
//    lx=(page.getWidth()-2)/16;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+1;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Sigla", lx+2,uy-7);
//    createText(cb, "Descrizione", lx+2,uy-7-7);
//    //colonna quantità + UM
//    lx=(page.getWidth()-2)/2+1;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Quantità", lx+2,uy-7);
//    //colonna prezzo
//    lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Prezzo", lx+2,uy-7);
//    //colonna sconto
//    lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createText(cb, "Sconto", lx+2,uy-7);
//    createRectangle(lx, ly, ux, uy,  canvas);
//    
//    //colonna totale riga
//    lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-1);
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale riga", lx+2,uy-7);
//    
//    
//    
//    
//    
//    
//    //base
//    lx=1;  
//    ly=1;
//    ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    uy=imgHeight+1;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale merce", lx+2,uy-7);
//    
//    //colonne base
//    //int col=1;
//    lx=ux;  
//    ly=1;
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    uy=imgHeight+1;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Sconto", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Imponibile", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)/16)-0.5f;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "IVA", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale IVA", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale da pagare", lx+2,uy-7);
// 	
//  	
//  	
//  	
//  	
//  	
//  	doc.newPage();
//  	
//  	level=0;
//  	
//	   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//	   img.scaleAbsolute(50, 50);
//	   doc.add(img);
//	   level++;
////primo rettangolo in cima 
//	   lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//
//
//
//
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, n.getTipo().getVocefile(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//
////writer.close();
// 
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//createTextElement(cb, n.getNumero(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
////createTextElement(cb, n.getData(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
////DecimalFormat df = new DecimalFormat("00");
//createTextElement(cb, df.format(date.getDayOfMonth()) + "/" + df.format(date.getMonthOfYear()) + "/" + date.getYear(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//
//	   
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//createTextElement(cb, n.getPagamento().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//createTextElement(cb, n.getTrasporto().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_CENTER);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/3)+1;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7);
//createTextElement(cb, n.getRiferimento().getAzienda().getNome(), 2+lx,-17+uy,cb.ALIGN_LEFT);
////String
//txtRiferimento="";
//if (n.getRiferimento().getTitolo()!=null)
//		txtRiferimento+=n.getRiferimento().getTitolo().getTitolo();
//
//if(n.getRiferimento().getCognome()!=null) 
//	txtRiferimento+=n.getRiferimento().getCognome();
//
//if(n.getRiferimento().getNome()!=null) 
//	txtRiferimento+=n.getRiferimento().getNome();
//
//////createTextElement(cb, n.getRiferimento().getTitolo().getTitolo() + " " + n.getRiferimento().getCognome() + " " + n.getRiferimento().getNome(), (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_RIGHT);
////createTextElement(cb, txtRiferimento, (ux-lx)/2+lx,(uy-ly)/2+ly,cb.ALIGN_RIGHT);
//
////nfornitore
//lx=page.getWidth()/3+1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/3)*2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Riferimento:", lx+2,uy-7);
////
////ColumnText	ct = new ColumnText(cb);
////
////
//////Phrase ph = new Phrase(txtRiferimento, BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 10);
////Font f =new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
////f.setSize(10);
////f.setColor(BaseColor.BLUE);
////Phrase ph = new Phrase(txtRiferimento, f);
////ct.setSimpleColumn(ph, 2+lx, 2+lx, ly+1,ux-2,uy-1,0);
////ct.setAlignment(Element.ALIGN_LEFT);
////ct.setText(ph);
////ct.go();
////
////
////
//createTextElement(cb, txtRiferimento, 2+lx,-17+uy,cb.ALIGN_LEFT);
////nfornitore
//lx=(page.getWidth()/3)*2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7);
//createTextElement(cb, n.getprodott1i().get(0).getProdotto().getFornitore().getNome(), 2+lx,-17+uy,cb.ALIGN_LEFT);
//  	
//  	
//  	
//  	
//  	
//  	
//    }
//	start+=1;
//	end = rowAtPage.getValue();
//  tblProdottiBase.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//    
////    for (Integer rowAtPage: rowPerPage.values()) {
////	    	start+=1;
////	    	end = rowAtPage;
////	      tblProdottiBase.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
////	      doc.newPage();
////	      start=end-1;
////    }
//    
//    
//    
//    
////    tblProdottiBase.writeSelectedRows(rowStart, rowEnd, xPos, yPos, canvas)
////    doc.add(tblProdottiBase);
////    tblProdottiBase.writeSelectedRows(0, -1, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//    
////    tblProdottiBase.writeSelectedRows(rowStart, rowEnd, xPos, yPos, canvases)
//    
//    
//    
////    //per splittare subito la tabella alla pagina successiva
////    tblProdotti.setSplitLate(false);
//   
//    //colonna posizione
//    lx=1;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/16;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Item", lx+2,uy-7);
//    
//    //colonna sigla + descrizione
//    lx=(page.getWidth()-2)/16;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+1;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Sigla", lx+2,uy-7);
//    createText(cb, "Descrizione", lx+2,uy-7-7);
//    //colonna quantità + UM
//    lx=(page.getWidth()-2)/2+1;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Quantità", lx+2,uy-7);
//    //colonna prezzo
//    lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Prezzo", lx+2,uy-7);
//    //colonna sconto
//    lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createText(cb, "Sconto", lx+2,uy-7);
//    createRectangle(lx, ly, ux, uy,  canvas);
//    
//    //colonna totale riga
//    lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//    ly=imgHeight+1;
//    ux=(page.getWidth()-1);
//    uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale riga", lx+2,uy-7);
//    
//    
//    
//    
//    
//    
//    //base
//    lx=1;  
//    ly=1;
//    ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    uy=imgHeight+1;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale merce", lx+2,uy-7);
//    
//    //colonne base
//    //int col=1;
//    lx=ux;  
//    ly=1;
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    uy=imgHeight+1;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Sconto", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Imponibile", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)/16)-0.5f;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "IVA", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale IVA", lx+2,uy-7);
//    
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//    createRectangle(lx, ly, ux, uy,  canvas);
//    createText(cb, "Totale da pagare", lx+2,uy-7);
    
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
	   /********************************************************************/
    
    doc.close();
    
    
    PdfReader reader = new PdfReader(filePath + "old" + fileName);
    int pages = reader.getNumberOfPages();
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(filePath + fileName));
//    int countPage=1;
    boolean found =false;
//	RettangoloPDFText r = null;
//   
//    for (int i=0; i<n.getTipo().getLayout().getListaTesto().size() && !found; i++){
//    	r = n.getTipo().getLayout().getListaTesto().get(i);
//    		if (r.getIDCampo()==IDCampo.PAGINA) {
//    			found=true;
//  	    	   lx=(float) r.getX();  
//	    	      ux=(float) (r.getX()+r.getWidth());
//	    	      
////	    	      ly=page.getHeight()-(imgHeight*level)-1;
//	    	      ly=(float) (page.getHeight()-r.getHeight()-r.getY());
////	    	      uy=page.getHeight()-1;
//	    	      uy=(float) (page.getHeight()-r.getY());
//    		}
//    }
//    
////    createTextElement(cb, txt ,uy,rect2);
    
    
    lx=0;
    ux=0;
    uy=0;
    ly=0;
    
  for (int i=0;i<pages;) {
	  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
	    	   lx=(float) rect2.getX();  
	    	      ux=(float) (rect2.getX()+rect2.getWidth());
	    	      
//	    	      ly=page.getHeight()-(imgHeight*level)-1;
	    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//	    	      uy=page.getHeight()-1;
	    	      uy=(float) (page.getHeight()-rect2.getY());
	    	      String txt="";
	    	      switch(rect2.getIDCampo()) {
//	    	        case TIPO:
//	    	        		txt=n.getTipo().getVocefile();
//	    	            break;
//	    	        case NUMERO:
//	    	        	txt=n.getNumero();
//	    	            break;
//	    	        case DATA:
//	    	        	txt=n.getData();
//	    	            break;
	    	        case PAGINA:
	    	        	txt= (++i) + " / " + pages;
	    	        	

	    	        	
	    	    	    Font font = getFont();
//	    	    	    Font fontCellWhite = null;
//	    	    	    String sep = File.separator;
//	    	    	    String fontPath ="font";
//	    		    	File file = new File("");
//	    	    	    if (OSValidator.isMac()) {
//		    	        	font = new Font(BaseFont.createFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	    	    	    }
//	    	    	    else if (OSValidator.isWindows()) {
//		    	        	font = new Font(BaseFont.createFont(file.getAbsolutePath() +sep+sep+ fontPath + sep +sep+ "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	    	    	    }
//	    	        	font = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
	    	        	
	    	        	font.setColor(BaseColor.BLUE);
	    	        	font.setSize(size);
	    	        	Phrase ph = new Phrase(txt, font);
//	    	        	countPage++;
	    	        	switch(rect2.getTitleAlignment()) {
	    	        	case LEFT:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph, (float) lx+2, uy-(size/2), 0.0f);
	    	        		break;
	    	        	case CENTER:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
	    	        		break;
	    	        	default:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
	    	        		break;
	    	        	}
	    	        	
	    	        	
	    	            break;
//	    	        case PAGAMENTO:
//	    	        	txt=n.getPagamento().getNome();
//	    	            break;
//	    	        case TRASPORTO:
//	    	        	txt=n.getTrasporto().getNome();
//	    	            break;
//	    	        case RIFERIMENTO:
//	    	        	txt=n.getRiferimento().getCognome() + n.getRiferimento().getNome();
//	    	            break;
//	    	        case CLIENTE:
//	    	        	txt=n.getRiferimento().getAzienda().toString();
//	    	            break;
//	    	        case FORNITORE:
//	    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
//	    	            break;
//	    	        case PROGRESSIVO:
//	    	            break;
//	    	        case DESCRIZIONE:
//	    	            break;
//	    	        case QUANTITA:
//	    	            break;
//	    	        case PREZZO:
//	    	            break;
//	    	        case SCONTO:
//	    	            break;
//	    	        case TOTRIGA:
//	    	            break;
	    	        case TOTMERCE:
	    	        	if (i==pages) {
		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	        	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	Font f = getFont();
		    	        	f.setColor(BaseColor.BLUE);
		    	        	f.setSize(size);
		    	        	Phrase ph2 = new Phrase(txt, f);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
	    	        	}
	    	            break;
	    	        case IMPONIBILE:
	    	        	if (i==pages) {
		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	        	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	Font f = getFont();

		    	        	f.setColor(BaseColor.BLUE);
		    	        	f.setSize(size);
		    	        	Phrase ph2 = new Phrase(txt, f);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
	    	        	}
	    	            break;
	    	        case TOTSCONTO:
	    	            break;
	    	        case IVA:
	    	        	if (i==pages) {
		    	        	txt="22 %";
//		    	        	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	Font f = getFont();
		    	        	f.setColor(BaseColor.BLUE);
		    	        	f.setSize(size);
		    	        	Phrase ph2 = new Phrase(txt, f);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
	    	        	}
	    	            break;
	    	        case TOTIVA:
	    	        	if (i==pages) {
		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
//		    	        	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	Font f = getFont();
		    	        	f.setColor(BaseColor.BLUE);
		    	        	f.setSize(size);
		    	        	Phrase ph2 = new Phrase(txt, f);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
	    	        	}
	    	            break;
	    	        case TOTALE:
	    	        	if (i==pages) {
		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
	    	        	}
	    	        	else {
	    	        		txt="continua a pag. " + (i+1);
	    	        	}
//	    	        	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
	    	        	Font f = getFont();
	    	        	f.setColor(BaseColor.BLUE);
	    	        	f.setSize(size);
	    	        	Phrase ph2 = new Phrase(txt, f);
//	    	        	countPage++;
	    	        	switch(rect2.getTitleAlignment()) {
	    	        	case LEFT:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
	    	        		break;
	    	        	case CENTER:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
	    	        		break;
	    	        	default:
		    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
	    	        		break;
	    	        	}
	    	            break;
	    	        default:
	    	        	txt="";
	    	            break;
	    	      }
	    	      
	    	      
////	    createRectangle(lx, ly, ux, uy,  canvas);
//	    createTextElement(cb, txt ,uy,rect2);
	      }
	      }
   
    

//    for (int i=0;i<pages-1;) {
//    	
//    	
//    	
//    	
//        lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//        ly=page.getHeight()-(imgHeight*2)-1;
//        ux=(page.getWidth()-1);
//        uy=page.getHeight()-(imgHeight*2)-1+imgHeight;
//   	
//    	
//    	
//    	
//    	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//    	f.setColor(BaseColor.BLUE);
//    	f.setSize(12);
//    	Phrase ph = new Phrase(String.format("%s / %s", ++i, pages), f);
//    	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph, (ux-lx)/2+lx, (uy-ly-12)/2+ly, 0.0f);
//        ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//        lx=ux;  
//        ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//    	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, new Phrase("..."), 2+lx, -17+uy, 0.0f);
//    }
//    
//    
//    
//    
//	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	f.setColor(BaseColor.BLUE);
//	f.setSize(12);
//	Phrase ph = new Phrase(String.format("%s / %s", pages, pages), f);
//	ColumnText.showTextAligned(stamper.getOverContent(pages), Element.ALIGN_CENTER, ph, (ux-lx)/2+lx, (uy-ly-12)/2+ly, 0.0f);
//	
//	
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//    lx=ux;  
//    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//	ColumnText.showTextAligned(stamper.getOverContent(pages), Element.ALIGN_LEFT, new Phrase("totale"), 2+lx, -17+uy, 0.0f);


    stamper.close();
    reader.close();
    
    Files.delete(FileSystems.getDefault().getPath(filePath + "old" + fileName));
//    Desktop.getDesktop().open(new File(filePath + fileName));

        
        
        }catch(Exception e) {
			RCMException.showException(e);
        }
	   
		
			
		}
		else {
			DocumentoSub n = (DocumentoSub) kn;
//			busObjDocumento.read(n);
			
//			Parametro param = (Parametro) busObjParametro.readAll().get(0);
	 	   
//	 	   Documento d = tblAziende.getItems().get(getTableRow().getIndex());
	 	   
	 	   OutputStream outputStream = null;
	 	   
	        try {    
	     	   
	            //now write the PDF content to the output stream
	            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-ddd")
	                    .withLocale(Locale.ITALIAN);
//	            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//	                    .withLocale(Locale.ITALIAN);

	                LocalDate date = formatter.parseLocalDate(n.getData());

//	                System.out.println(date.getYear());  // 2012
//	                System.out.println(date.getMonthOfYear()); // 8
//	                System.out.println(date.getDayOfMonth());   // 18
	            	   
	          	   String filePath = getRootFolder() + File.separator;
	          	   
	            	 filePath += n.getRiferimento().getAzienda().getNome() + File.separator;

	          	filePath += n.getRiferimento().getAzienda().getNome() + "_" + date.getYear() + File.separator;

//	       	  filePath="";
	          	String fileName = "";
	          	if (n.getRevisione()>0)
	    	       	fileName += n.getDatarev() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
	          	else
		       	fileName += n.getData() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
	          	
		       	if (n.getRevisione()>0)
		       		fileName += " REV. " + n.getRevisione();
		       	
		       	fileName +=" x ";
//	  	   		      
//	       	fileName += n.getprodott1i().get(0).getProdotto().getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
	       	fileName += n.getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
	       	
	       	
	  	   		      
	  	   		      
//	  	   		      n.getprodott1i().get(0).getProdotto().getFornitore();
	  	   		      
	     	   
	     	   
//	     	   if (n.getRiferimento()!=null) {
//		        	   fileName += n.getRiferimento().getCognome();
//	     		   
//	     	   }
	     	   fileName+= ".pdf";
//	     	   filePath="";//da rimuovere
	           try {
	         	   outputStream = new FileOutputStream(filePath + "old" + fileName);
	         	   
//	         	   File f =new File(filePath + fileName);
//	         	   while (!f.canWrite()) {
//	         		   if (!f.canWrite()) {
//	     				  ButtonType btnYes = new ButtonType("OK");
//	    				  Optional<ButtonType> scelta= null;
//	       			
//	    				  Alert alert= new Alert(AlertType.WARNING);
//	    				  alert.setTitle("Attenzione!");
//	    				  alert.setHeaderText("Per completare la registrazione è necessario");
////	    				  alert.setContentText("E' necessario selezionare un fornitore");
//	    				  
//	    				  
//	    				  alert.getButtonTypes().setAll(btnYes);
//	    				  
	//
////	    				  scelta = alert.showAndWait();
//	    				  alert.showAndWait();
//	         		   }
//	         	   }
	         	   
////	         	   outputStream = new FileOutputStream(filePath + fileName);
	           } 
	           catch(Exception e){
//	        	   e.printStackTrace();
	        	   new File(filePath).mkdirs();
	         	   outputStream = new FileOutputStream(filePath + "old" + fileName);
//	         	   outputStream = new FileOutputStream(filePath + fileName);
	         }
	 	   
	     	   
//	 	       public void writePdf(OutputStream outputStream) throws Exception {
	    	   float lx;
	    	   float ly;
	    	   float ux;
	    	   float uy;
	    	   
	    	   float imgWidth=50;
	    	   float imgHeight=30;
	    	   int level=0;
	    	   
	    	   float POINTS_PER_INCH = 72;
	    	   float POINTS_PER_MM = 1 / (10 * 2.54f) * POINTS_PER_INCH;
//	    	   Rectangle page = PageSize.A4.rotate();
	    	   Rectangle page = new Rectangle(n.getTipo().getLayout().getPxlWidth(), n.getTipo().getLayout().getPxlHeight());
	    	   Document doc = new Document(page);
	    	   PdfWriter writer = PdfWriter.getInstance(doc, outputStream);
	    	   doc.open();
	    	   
	    	   
	    	   
	    	   
//	    	   newPage(doc, n);
//	    	   int size=16;
	    	   
	    	   PdfContentByte cb = writer.getDirectContent();
//	    	   doc.open();
	    	   doc.newPage();
	    	   
	    	   
	        PdfContentByte canvas = writer.getDirectContent();
	        
	    	   com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(ClassLoader.getSystemResource("b_tiers/c_integration/b_filesystem/logorcm.png").getPath());
	    	   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
	    	   img.scaleAbsolute(50, 50);
	    	   doc.add(img);
	    	   
	    	   int countSplit=0;
	    	   int[] columnsSize;
	    	   ArrayList<RettangoloPDFText> columns = new ArrayList<>();
	    	   for (RettangoloPDFText r : n.getTipo().getLayout().getListaTesto()) {
	    		   if (r.isShowSplittable()) {
	    			   countSplit++;
	    			   columns.add(r);
	    		   }
	    		   
	    	   }
//			   columns.addAll(n.getTipo().getLayout().getListaTesto());
			   
			   Collections.sort(columns);
	   	    float tableYPos=page.getHeight() - (float) columns.get(0).getY();
			   
	    	   		columnsSize=new int[countSplit];
	    	   		for (int i=0; i< columnsSize.length;i++) {
	    	   			columnsSize[i]=(int) columns.get(i).getWidth();
	    	   		}
	    	   
	    	    PdfPTable tblProdottiBase2 = new PdfPTable(countSplit);
//	    	    tblProdottiBase2.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
	    	    tblProdottiBase2.setWidths(columnsSize);
	    	    tblProdottiBase2.setTotalWidth(page.getWidth());
	    	    tblProdottiBase2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
	    	    tblProdottiBase2.getDefaultCell().setFixedHeight(cellHeight);
	    	    tblProdottiBase2.setSplitLate(false);
	   	   
	    	   
	    	    PdfPCell cell =null;
//	    	    float tableHeight=page.getHeight()-(imgHeight*level)-1-imgHeight-12-imgHeight;
	    	    float tableHeight=(float) columns.get(0).getHeight();
	    	    float cellheight=0;
	    	    
	    	    HashMap<Integer, Integer> rowPerPage = new HashMap<>();
	    	    int pagina=1;
	    	    int nRiga=0;
	    	    float totDocumento=0.0f;
	    	    float totRiga=0.0f;
	    	   
//	    	    Font fontCell = FontFactory.getFont(x"addons/font/arial bold.ttf", size, Font.NORMAL);
//	    	    fontCell.setColor(0, 0, 255);
//	    	    Font fontCellWhite = FontFactory.getFont(x"addons/font/arial bold.ttf", size, Font.NORMAL);
//	    	    fontCellWhite.setColor(255, 255, 255);
	    	    
	    	    Font fontCell = null;
	    	    Font fontCellWhite = null;
	    	    String sep = File.separator;
	    	    String fontPath ="font";
		    	File file = new File("");
	    	    if (OSValidator.isMac()) {
//	        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
	        	    fontCell =FontFactory.getFont("arialBold");
	        	    fontCell.setColor(0, 0, 255);
//	        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
	        	    fontCellWhite =FontFactory.getFont("arialBold");
	        	    fontCellWhite.setColor(255, 255, 255);
	    	    }
	    	    else if (OSValidator.isWindows()) {
//	        	    fontCell = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
	        	    fontCell =FontFactory.getFont("arialBold");
	        	    fontCell.setColor(0, 0, 255);
//	        	    fontCellWhite = FontFactory.getFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL);
	        	    fontCellWhite =FontFactory.getFont("arialBold");
	        	    fontCellWhite.setColor(255, 255, 255);
	    	    }
	    	    
	    	    
	    	    
	    	    
	    	    
//	    		public List<Riga> getRighe() {
//	    		
//	    		
	    		List<RigaProdottoSub>  prodotti= n.getProdotti();
	    		List<RigaTestoSub>  testo=n.getTesto();
	  		
	    		ArrayList<Riga> lista = new ArrayList<>();
	    		
	    		int z=0;
	    		int j=0;
	    		int k=0;
	    		RigaProdottoSub rigaA;
	    		RigaTestoSub rigaB;
	    		
	    		while (z< prodotti.size() && j< testo.size()) {
	    			rigaA=prodotti.get(z);
	    			rigaB=testo.get(j);
	    			
	    			if (rigaA.getProgressivo() < rigaB.getProgressivo()) {
	    				lista.add(rigaA);
	    				z++;
	    			}
	    			else {
	    				lista.add(rigaB);
	    				j++;
	    			}
	    		}
	    		while (z< prodotti.size()) {
	    			lista.add(prodotti.get(z++));
	    		}
	    		while (j< testo.size()) {
	    			lista.add(testo.get(j++));
	    		}
	    		
	    		
	    		Collections.sort(lista);
	    //	
//	    		return lista;
//	    	}
	  	    
	    	    
	    	    
	    	    
//	    	    for (Riga r : n.getRighe()) {
	    	    for (Riga r : lista) {
	    	    	
	    	    	
	    	    	for (RettangoloPDFText str : columns) {
	    	    		
	  	    	      switch(str.getIDCampo()) {
	    	        case PROGRESSIVO:
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            if (r instanceof RigaProdottoSub) {
//	    	    	        	progressivo++;
		    		        cell.addElement(new Phrase(((RigaProdottoSub) r).getItem() + "", fontCell));
//	    	    		        cell.addElement(new Phrase(((RigaProdottoSub) r).getItem() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
//	    	    		        cell.addElement(new Phrase(progressivo + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
	    	            }
	    	            else {
	    	                cell.addElement(new Phrase("", fontCell));
	    	            	
	    	            }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	    	        case DESCRIZIONE:
	    	            String sigla_descr="";
	    	            String hexColor=null;
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            if (r instanceof RigaProdottoSub) {
	    	            	sigla_descr = ((RigaProdottoSub) r).getProdotto().getNome() + "\n";
	    	    	        	if (((RigaProdottoSub) r).getProdotto().getDescrizioni() != null && ((RigaProdottoSub) r).getProdotto().getDescrizioni().size()>0) {
	    	    	        		sigla_descr+= ((Descrizione)((RigaProdottoSub) r).getProdotto().getDescrizioni().get(0)).getDescrizione();
	    	    	        	}
	    	    	        	
//	    	    	        	if (((RigaProdottoSub) r).getTempo()!=null) {
//	    	    	        		sigla_descr+= "\n" + ((RigaProdottoSub) r).getTempo().getNome();
//	    	    	        	}
	    	    	        	
	    	    	        	
	    	    	            cell.addElement(new Phrase(sigla_descr, fontCell));
	    	    	    }
	    	    	    else {
	    	        		sigla_descr+= ((RigaTestoSub) r).getText();
	    	        		hexColor = ((RigaTestoSub)r).getColorHex();
	    	        		
	        	            if (sigla_descr.length()==0) {
	        	            	sigla_descr="_";
	        	            cell.addElement(new Phrase(sigla_descr, fontCellWhite));
	        	            }
	        	            else {
	            	            cell.addElement(new Phrase(sigla_descr, fontCell));
	        	            	
	        	            }
	    	    	    }
	    	        	
//	    	            	cell.setMinimumHeight(cellHeight);
	    	            
	    	            if (hexColor!=null) {
	    	            	int rr,gg,bb;
	    	            	rr=Integer.valueOf( hexColor.substring( 1, 3 ), 16 );
	    	            gg=Integer.valueOf( hexColor.substring( 3, 5 ), 16 );
	    	            	bb=Integer.valueOf( hexColor.substring( 5, 7 ), 16 );
	    	            	cell.setBackgroundColor(new BaseColor(rr,gg,bb));
	    	            }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	    	        case QUANTITA:
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            if (r instanceof RigaProdottoSub) {
//	    	            	progressivo++;
	    	            cell.addElement(new Phrase(((RigaProdottoSub) r).getQuantita() + "", fontCell));
	    	    	    }
	    	    	    else {
	    	    	        cell.addElement(new Phrase("", fontCell));
	    	    	    	
	    	    	    }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	    	        case PREZZO:
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            
	    	            if (r instanceof RigaProdottoSub) {
//	    	            	progressivo++;
	    	            cell.addElement(new Phrase(NumberFormat.getCurrencyInstance(Locale.ITALY).format(((RigaProdottoSub) r).getPrezzo()) + "", fontCell));
	    	    	    }
	    	    	    else {
	    	    	        cell.addElement(new Phrase("", fontCell));
	    	    	    	
	    	    	    }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
//	    	        case SCONTO:
//	    	            break;
	    	        case TOTRIGA:
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            if (r instanceof RigaProdottoSub) {
	        	        	totRiga=(float) (((RigaProdottoSub) r).getQuantita() * ((RigaProdottoSub) r).getPrezzo());
	        	        	totDocumento+=totRiga;
//	    	            	progressivo++;
//	        	            cell.addElement(new Phrase(((RigaProdottoSub) r).getQuantita() * ((RigaProdottoSub) r).getPrezzo() + "", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
	        	            cell.addElement(new Phrase(NumberFormat.getCurrencyInstance(Locale.ITALY).format(totRiga) + "", fontCell));
	    	    	    }
	    	    	    else {
	    	    	        cell.addElement(new Phrase("", fontCell));
	    	    	    	
	    	    	    }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            
	    	            
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	    	        case TEMPI:
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            if (r instanceof RigaProdottoSub) {
	    	            	TempoConsegna tempo = ((RigaProdottoSub)r).getTempo();
	    	            	
	    	            	if (tempo!=null)
	        	            cell.addElement(new Phrase(tempo.getNome() + "", fontCell));
	        	    	    else 
	        	    	        cell.addElement(new Phrase("", fontCell));
	    	    	    }
	    	    	    else {
	    	    	        cell.addElement(new Phrase("", fontCell));
	    	    	    	
	    	    	    }
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            
	    	            
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	    	        case TOTMERCE:
	    	            break;
	    	        case IMPONIBILE:
	    	            break;
	    	        case TOTSCONTO:
	    	            break;
	    	        case IVA:
	    	            break;
	    	        case TOTIVA:
	    	            break;
	    	        case TOTALE:
	    	        		break;
	    	        default:
	    	        	//campo vuoto
	    	            cell = new PdfPCell();
	    	            cell.setBorder(0);
	    	            cell.addElement(new Phrase("", fontCell));
//	    	            cell.setBorderColor(BaseColor.LIGHT_GRAY);
//	    	            cell.setPadding(5);
	    	            tblProdottiBase2.addCell(cell);
	    	            break;
	  	    	      
	  	    	      }
	    	        	
	    	    	}
	    	    	
	        	
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            cellheight+=tblProdottiBase2.getRowHeight(nRiga++);
//	            if (r instanceof RigeTestoSub) {
//	            	//ricavo l'altezza della riga precedente (il cursore già si è spostato)
//	                cellheight+=tblProdottiBase.getRowHeight(nRiga-1);
//	            }
	            if (cellheight < tableHeight) {
	            		Integer row =rowPerPage.get(pagina);
	            		if (row==null) {
	            			rowPerPage.put(pagina, 1);
	            		}
	            		else {
	            			row++;
	            			rowPerPage.put(pagina, row);
	            		}
	            		
	            }
	            else {
	                cellheight=tblProdottiBase2.getRowHeight(nRiga-1);
	                
	            	pagina++;
	        		Integer row =rowPerPage.get(pagina);
	        		if (row==null) {
	        			row=rowPerPage.get(pagina-1)+1;
	        			rowPerPage.put(pagina, row);
	        		}
	        		else {
	        			row++;
	        			rowPerPage.put(pagina, row);
	        		}
	            }
	        	
	        	
//	            PdfPTable tblProdotti = new PdfPTable(6);
//	            //Per rimuovere i bordi dalle celle
//	            tblProdotti.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//	            
//	            tblProdotti.setTotalWidth(page.getWidth()-2);
//	            tblProdotti.setWidths(new int[] {(int) ((page.getWidth()-2)/16)+1,(int) (((page.getWidth()-2)/2+1)-((page.getWidth()-2)/16)),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4),(int) (((page.getWidth()-2)/2)/4)});
//	            PdfPCell tblCell = new PdfPCell();
//	        	tblProdotti.addCell(r.getProgressivo() + "");
//	        	String sigla_descr = r.getProdotto().getNome() + "\n";
//	        	if (r.getProdotto().getDescrizioni() != null && r.getProdotto().getDescrizioni().size()>0) {
//	        		sigla_descr+= ((Descrizione)r.getProdotto().getDescrizioni().get(0)).getDescrizione();
//	        	}
////	        	tblProdotti.addCell(r.getProdotto().getNome() + "\n" + r.getProdotto().getDescrizioni().get(0));
//	        	tblProdotti.addCell(sigla_descr);
//	        	tblProdotti.addCell(r.getQuantita() + "");
//	        	tblProdotti.addCell(r.getPrezzo() + "");
//	        	tblProdotti.addCell("");
//	        	tblProdotti.addCell("totale");
////	          tblProdotti.completeRow();
//	        	tblProdottiBase.addCell(tblProdotti);
	        	
	        }
	    	   
	    	    int start=-1;
	    	    int end=0;
	    	    Iterator<Entry<Integer, Integer>> it = rowPerPage.entrySet().iterator();
	    	    
	    	    
	    		Entry<Integer, Integer> rowAtPage= it.next();
	    	    while (it.hasNext()) {
	    	    	start+=1;
	    	    	end = rowAtPage.getValue();
////	    	      tblProdottiBase2.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//	        	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableHeight, canvas);
	    	    	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableYPos, canvas);
//	    	      doc.newPage();
	    	      start=end-1;
	    	  	rowAtPage = it.next();
	    	    
	    	    
	    	  	for (RettangoloPDF rect: n.getTipo().getLayout().getListaRect()) {
	    	    	   lx=(float) rect.getX();  
	    	    	      ux=(float) (rect.getX()+rect.getWidth());
	    	    	      
//	    	    	      ly=page.getHeight()-(imgHeight*level)-1;
	    	    	      ly=(float) (page.getHeight()-rect.getHeight()-rect.getY());
//	    	    	      uy=page.getHeight()-1;
	    	    	      uy=(float) (page.getHeight()-rect.getY());
	        	    createRectangle(lx, ly, ux, uy,  canvas);
	        	    createText(cb, rect.getTitolo() , lx+2,uy-7);
	    	  	}
	    	  	
	    	  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
	 	    	   lx=(float) rect2.getX();  
		    	      ux=(float) (rect2.getX()+rect2.getWidth());
		    	      
//		    	      ly=page.getHeight()-(imgHeight*level)-1;
		    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//		    	      uy=page.getHeight()-1;
		    	      uy=(float) (page.getHeight()-rect2.getY());
		    	      String txt="";
		    	      switch(rect2.getIDCampo()) {
		    	        case TIPO:
		    	        		txt=n.getTipo().getVocefile();
		    	            break;
		    	        case NUMERO:
		    	        	txt=n.getNumero();
		    	        	if (n.getRevisione()>0)
		    	        		txt+= " REV. " + n.getRevisione();
		    	            break;
		    	        case DATA:
		    	        	if (n.getRevisione()>0)
		    	        		txt=n.getDatarev();
		    	        	else
		    	        	txt=n.getData();
		    	            DateTimeFormatter formatter2 = DateTimeFormat.forPattern("yyyy-MM-ddd")
		    	                    .withLocale(Locale.ITALIAN);
//		    	            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//		    	                    .withLocale(Locale.ITALIAN);

		    	                LocalDate date2 = formatter2.parseLocalDate(txt);
	    	        	
		    				String anno = String.valueOf(date2.getYear());
		    				String mese = String.valueOf(date2.getMonthOfYear());
		    				if (Integer.parseInt(mese)<10){
		    					mese= "0" + mese;
		    				}
		    				String giorno = String.valueOf(date2.getDayOfMonth());
		    				if (Integer.parseInt(giorno)<10){
		    					giorno= "0" + giorno;
		    				}
		    	        	
		    	        	
		    	        	txt=giorno + "/" + mese + "/" + anno;
		    	            break;
//		    	        case PAGINA:
//		    	        	txt="/";
//		    	            break;
		    	        case PAGAMENTO:
		    	        	txt=n.getPagamento().getNome();
		    	            break;
		    	        case TRASPORTO:
		    	        	txt=n.getTrasporto().getNome();
		    	            break;
		    	        case RIFERIMENTO:
		    	        	Titolo t = n.getRiferimento().getTitolo();
		    	        	
		    	        	if (t!=null)
		    	        		txt=n.getRiferimento().getTitolo() + " " + n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
		    	        	else
			    	        	txt=n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
		    	            break;
		    	        case CLIENTE:
		    	        	txt=n.getRiferimento().getAzienda().toString();
		    	            break;
		    	        case FORNITORE:
//		    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
		    	        	txt=n.getFornitore().toString();
		    	            break;
		    	        case PROGRESSIVO:
		    	            break;
		    	        case DESCRIZIONE:
		    	            break;
		    	        case QUANTITA:
		    	            break;
		    	        case PREZZO:
		    	            break;
		    	        case SCONTO:
		    	            break;
		    	        case TOTRIGA:
		    	            break;
//		    	        case TOTMERCE:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	            break;
//		    	        case IMPONIBILE:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	            break;
//		    	        case TOTSCONTO:
//		    	            break;
//		    	        case IVA:
//		    	        	txt="22 %";
//		    	            break;
//		    	        case TOTIVA:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
//		    	            break;
		    	        default:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
		    	            break;
		    	      }
		    	      
		    	      
//	 	    createRectangle(lx, ly, ux, uy,  canvas);
	 	    createTextElement(cb, txt ,uy,rect2);
	    	  	}
	    	  	
	    	  	doc.newPage();
	    	  	
	    	  	level=0;
	    	  	
	    		   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
	    		   img.scaleAbsolute(50, 50);
	    		   doc.add(img);

	    	//writer.close();
	    	 

	    	    }
	    	    
	    	    
	    	  	for (RettangoloPDF rect: n.getTipo().getLayout().getListaRect()) {
	 	    	   lx=(float) rect.getX();  
	 	    	      ux=(float) (rect.getX()+rect.getWidth());
	 	    	      
//	 	    	      ly=page.getHeight()-(imgHeight*level)-1;
	 	    	      ly=(float) (page.getHeight()-rect.getHeight()-rect.getY());
//	 	    	      uy=page.getHeight()-1;
	 	    	      uy=(float) (page.getHeight()-rect.getY());
	     	    createRectangle(lx, ly, ux, uy,  canvas);
	     	    createText(cb, rect.getTitolo() , lx+2,uy-7);
	 	  	}
	    	    
	    		start+=1;
	    		end = rowAtPage.getValue();
////	      	  tblProdottiBase2.writeSelectedRows(start, end, 1, page.getHeight()-(imgHeight*level)-1-imgHeight-12, canvas);
//	      	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableHeight, canvas);
	   	   
	    	  tblProdottiBase2.writeSelectedRows(start, end, 1, tableYPos, canvas);
	   	   
	    	   
	    	   
	  	  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
		    	   lx=(float) rect2.getX();  
		    	      ux=(float) (rect2.getX()+rect2.getWidth());
		    	      
//		    	      ly=page.getHeight()-(imgHeight*level)-1;
		    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//		    	      uy=page.getHeight()-1;
		    	      uy=(float) (page.getHeight()-rect2.getY());
		    	      String txt="";
		    	      switch(rect2.getIDCampo()) {
		    	        case TIPO:
		    	        		txt=n.getTipo().getVocefile();
		    	            break;
		    	        case NUMERO:
		    	        	txt=n.getNumero();
		    	        	if (n.getRevisione()>0)
		    	        		txt+= " REV. " + n.getRevisione();
		    	            break;
		    	        case DATA:
		    	        	if (n.getRevisione()>0)
		    	        		txt=n.getDatarev();
		    	        	else
		    	        	txt=n.getData();
		    	            DateTimeFormatter formatter2 = DateTimeFormat.forPattern("yyyy-MM-ddd")
		    	                    .withLocale(Locale.ITALIAN);
//		    	            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//		    	                    .withLocale(Locale.ITALIAN);

		    	                LocalDate date2 = formatter2.parseLocalDate(txt);
	    	        	
		    				String anno = String.valueOf(date2.getYear());
		    				String mese = String.valueOf(date2.getMonthOfYear());
		    				if (Integer.parseInt(mese)<10){
		    					mese= "0" + mese;
		    				}
		    				String giorno = String.valueOf(date2.getDayOfMonth());
		    				if (Integer.parseInt(giorno)<10){
		    					giorno= "0" + giorno;
		    				}
		    	        	
		    	        	
		    	        	txt=giorno + "/" + mese + "/" + anno;
		    	            break;
//		    	        case PAGINA:
//		    	        	txt="/";
//		    	            break;
		    	        case PAGAMENTO:
		    	        	txt=n.getPagamento().getNome();
		    	            break;
		    	        case TRASPORTO:
		    	        	txt=n.getTrasporto().getNome();
		    	            break;
		    	        case RIFERIMENTO:
		    	        	Titolo t = n.getRiferimento().getTitolo();
		    	        	
		    	        	if (t!=null)
		    	        		txt=n.getRiferimento().getTitolo() + " " + n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
		    	        	else
			    	        	txt=n.getRiferimento().getCognome() + " " +  n.getRiferimento().getNome();
		    	            break;
		    	        case CLIENTE:
		    	        	txt=n.getRiferimento().getAzienda().toString();
		    	            break;
		    	        case FORNITORE:
//		    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
		    	        	txt=n.getFornitore().toString();
		    	            break;
		    	        case PROGRESSIVO:
		    	            break;
		    	        case DESCRIZIONE:
		    	            break;
		    	        case QUANTITA:
		    	            break;
		    	        case PREZZO:
		    	            break;
		    	        case SCONTO:
		    	            break;
		    	        case TOTRIGA:
		    	            break;
//		    	        case TOTMERCE:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	            break;
//		    	        case IMPONIBILE:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
//		    	            break;
//		    	        case TOTSCONTO:
//		    	            break;
//		    	        case IVA:
//		    	        	txt="22 %";
//		    	            break;
//		    	        case TOTIVA:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
//		    	            break;
		    	        default:
//		    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
		    	            break;
		    	      }
		    	      
		    	      
//		    createRectangle(lx, ly, ux, uy,  canvas);
		    createTextElement(cb, txt ,uy,rect2);
	 	  	}
	    	   
	    	   
	    	   
	    	   
//	    	   for (RettangoloPDF r : n.getTipo().getLayout().getListaRect()) {
//				   createRectangle(r, canvas, page.getWidth(), page.getHeight());
	//
////	    		   createRectangle2(r,canvas, n.getTipo().getLayout().getPxlWidth(), n.getTipo().getLayout().getPxlHeight());
//	    	   }
	    	   
	    	   
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   /********************************************************************/
	    	   
	    
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
		   /********************************************************************/
	    
	    doc.close();
	    
	    
	    PdfReader reader = new PdfReader(filePath + "old" + fileName);
	    int pages = reader.getNumberOfPages();
	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(filePath + fileName));
//	    int countPage=1;
	    boolean found =false;
//		RettangoloPDFText r = null;
	//   
//	    for (int i=0; i<n.getTipo().getLayout().getListaTesto().size() && !found; i++){
//	    	r = n.getTipo().getLayout().getListaTesto().get(i);
//	    		if (r.getIDCampo()==IDCampo.PAGINA) {
//	    			found=true;
//	  	    	   lx=(float) r.getX();  
//		    	      ux=(float) (r.getX()+r.getWidth());
//		    	      
////		    	      ly=page.getHeight()-(imgHeight*level)-1;
//		    	      ly=(float) (page.getHeight()-r.getHeight()-r.getY());
////		    	      uy=page.getHeight()-1;
//		    	      uy=(float) (page.getHeight()-r.getY());
//	    		}
//	    }
	//    
////	    createTextElement(cb, txt ,uy,rect2);
	    
	    
	    lx=0;
	    ux=0;
	    uy=0;
	    ly=0;
	    
	  for (int i=0;i<pages;) {
		  	for (RettangoloPDFText rect2: n.getTipo().getLayout().getListaTesto()) {
		    	   lx=(float) rect2.getX();  
		    	      ux=(float) (rect2.getX()+rect2.getWidth());
		    	      
//		    	      ly=page.getHeight()-(imgHeight*level)-1;
		    	      ly=(float) (page.getHeight()-rect2.getHeight()-rect2.getY());
//		    	      uy=page.getHeight()-1;
		    	      uy=(float) (page.getHeight()-rect2.getY());
		    	      String txt="";
		    	      switch(rect2.getIDCampo()) {
//		    	        case TIPO:
//		    	        		txt=n.getTipo().getVocefile();
//		    	            break;
//		    	        case NUMERO:
//		    	        	txt=n.getNumero();
//		    	            break;
//		    	        case DATA:
//		    	        	txt=n.getData();
//		    	            break;
		    	        case PAGINA:
		    	        	txt= (++i) + " / " + pages;
		    	        	
		    	        	Font font = getFont();
//		    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	font.setColor(BaseColor.BLUE);
		    	        	font.setSize(size);
		    	        	Phrase ph = new Phrase(txt, font);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
		    	        	
		    	        	
		    	            break;
//		    	        case PAGAMENTO:
//		    	        	txt=n.getPagamento().getNome();
//		    	            break;
//		    	        case TRASPORTO:
//		    	        	txt=n.getTrasporto().getNome();
//		    	            break;
//		    	        case RIFERIMENTO:
//		    	        	txt=n.getRiferimento().getCognome() + n.getRiferimento().getNome();
//		    	            break;
//		    	        case CLIENTE:
//		    	        	txt=n.getRiferimento().getAzienda().toString();
//		    	            break;
//		    	        case FORNITORE:
//		    	        	txt=n.getprodott1i().get(0).getProdotto().getFornitore().toString();
//		    	            break;
//		    	        case PROGRESSIVO:
//		    	            break;
//		    	        case DESCRIZIONE:
//		    	            break;
//		    	        case QUANTITA:
//		    	            break;
//		    	        case PREZZO:
//		    	            break;
//		    	        case SCONTO:
//		    	            break;
//		    	        case TOTRIGA:
//		    	            break;
		    	        case TOTMERCE:
		    	        	if (i==pages) {
			    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
			    	        	Font f = getFont();
//			    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
			    	        	f.setColor(BaseColor.BLUE);
			    	        	f.setSize(size);
			    	        	Phrase ph2 = new Phrase(txt, f);
//			    	        	countPage++;
			    	        	switch(rect2.getTitleAlignment()) {
			    	        	case LEFT:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
			    	        		break;
			    	        	case CENTER:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
			    	        		break;
			    	        	default:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
			    	        		break;
			    	        	}
		    	        	}
		    	            break;
		    	        case IMPONIBILE:
		    	        	if (i==pages) {
			    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento);
			    	        	Font f = getFont();
//			    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
			    	        	f.setColor(BaseColor.BLUE);
			    	        	f.setSize(size);
			    	        	Phrase ph2 = new Phrase(txt, f);
//			    	        	countPage++;
			    	        	switch(rect2.getTitleAlignment()) {
			    	        	case LEFT:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
			    	        		break;
			    	        	case CENTER:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
			    	        		break;
			    	        	default:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
			    	        		break;
			    	        	}
		    	        	}
		    	            break;
		    	        case TOTSCONTO:
		    	            break;
		    	        case IVA:
		    	        	if (i==pages) {
			    	        	txt="22 %";
			    	        	Font f = getFont();
//			    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
			    	        	f.setColor(BaseColor.BLUE);
			    	        	f.setSize(size);
			    	        	Phrase ph2 = new Phrase(txt, f);
//			    	        	countPage++;
			    	        	switch(rect2.getTitleAlignment()) {
			    	        	case LEFT:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
			    	        		break;
			    	        	case CENTER:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
			    	        		break;
			    	        	default:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
			    	        		break;
			    	        	}
		    	        	}
		    	            break;
		    	        case TOTIVA:
		    	        	if (i==pages) {
			    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento*0.22);
			    	        	Font f = getFont();
//			    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
			    	        	f.setColor(BaseColor.BLUE);
			    	        	f.setSize(size);
			    	        	Phrase ph2 = new Phrase(txt, f);
//			    	        	countPage++;
			    	        	switch(rect2.getTitleAlignment()) {
			    	        	case LEFT:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
			    	        		break;
			    	        	case CENTER:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
			    	        		break;
			    	        	default:
				    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
			    	        		break;
			    	        	}
		    	        	}
		    	            break;
		    	        case TOTALE:
		    	        	if (i==pages) {
			    	        	txt=NumberFormat.getCurrencyInstance(Locale.ITALY).format(totDocumento *1.22);
		    	        	}
		    	        	else {
		    	        		txt="continua a pag. " + (i+1);
		    	        	}
		    	        	Font f = getFont();
//		    	        	new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
		    	        	f.setColor(BaseColor.BLUE);
		    	        	f.setSize(size);
		    	        	Phrase ph2 = new Phrase(txt, f);
//		    	        	countPage++;
		    	        	switch(rect2.getTitleAlignment()) {
		    	        	case LEFT:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, ph2, (float) lx+2, uy-(size/2), 0.0f);
		    	        		break;
		    	        	case CENTER:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph2, (float) (lx+(rect2.getWidth()/2)), uy-(size/2), 0.0f);
		    	        		break;
		    	        	default:
			    	        	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_RIGHT, ph2, (float) (lx+(rect2.getWidth())), uy-(size/2), 0.0f);
		    	        		break;
		    	        	}
		    	            break;
		    	        default:
		    	        	txt="";
		    	            break;
		    	      }
		    	      
		    	      
////		    createRectangle(lx, ly, ux, uy,  canvas);
//		    createTextElement(cb, txt ,uy,rect2);
		      }
		      }
	   
	    

//	    for (int i=0;i<pages-1;) {
//	    	
//	    	
//	    	
//	    	
//	        lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//	        ly=page.getHeight()-(imgHeight*2)-1;
//	        ux=(page.getWidth()-1);
//	        uy=page.getHeight()-(imgHeight*2)-1+imgHeight;
	//   	
//	    	
//	    	
//	    	
//	    	Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	    	f.setColor(BaseColor.BLUE);
//	    	f.setSize(12);
//	    	Phrase ph = new Phrase(String.format("%s / %s", ++i, pages), f);
//	    	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph, (ux-lx)/2+lx, (uy-ly-12)/2+ly, 0.0f);
//	        ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//	        lx=ux;  
//	        ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//	    	ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_LEFT, new Phrase("..."), 2+lx, -17+uy, 0.0f);
//	    }
	//    
	//    
	//    
	//    
//		Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//		f.setColor(BaseColor.BLUE);
//		f.setSize(12);
//		Phrase ph = new Phrase(String.format("%s / %s", pages, pages), f);
//		ColumnText.showTextAligned(stamper.getOverContent(pages), Element.ALIGN_CENTER, ph, (ux-lx)/2+lx, (uy-ly-12)/2+ly, 0.0f);
	//	
	//	
//	    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//	    lx=ux;  
//	    ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//		ColumnText.showTextAligned(stamper.getOverContent(pages), Element.ALIGN_LEFT, new Phrase("totale"), 2+lx, -17+uy, 0.0f);


	    stamper.close();
	    reader.close();
	    
	    Files.delete(FileSystems.getDefault().getPath(filePath + "old" + fileName));
//	    Desktop.getDesktop().open(new File(filePath + fileName));

	        
	        
	        }catch(Exception e) {
				RCMException.showException(e);
	        }
		   
			
				
		}
		
	}

private static Font getFont() {
	
	return myBoldFont;
	
//    String sep = File.separator;
//    String fontPath ="font";
//	File file = new File("");
//	
//	Font font=null;
//	try {
//	    if (OSValidator.isMac()) {
//	    	font = new Font(BaseFont.createFont(file.getAbsolutePath() +sep+ fontPath + sep + "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	    }
//	    else if (OSValidator.isWindows()) {
//	    	font = new Font(BaseFont.createFont(file.getAbsolutePath() +sep+sep+ fontPath + sep +sep+ "arial bold.ttf"x, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//	    }
//	}
//	catch(Exception e) {
//		
//	}
//	return font;
	}

//private static void writeTable(PdfPTable tblProdottiBase) {
//		// TODO Auto-generated method stub
//		
//	}

private static Parametro rootFolder=null;

public static String getRootFolder() {
	String folder=null;
	if (rootFolder!=null) {
		if (OSValidator.isMac())
			folder= rootFolder.getRootMac();
		else if(OSValidator.isWindows()) {
			folder=rootFolder.getRootWindows();
			
			String[] folders = folder.split("/");
			String root = folders[0];
			
			File[] paths;
			FileSystemView fsv = FileSystemView.getFileSystemView();
			
			// returns pathnames for files and directory
			paths = File.listRoots();

			String percorso="";
			// for each pathname in pathname array
			for(File path:paths)
			{
//			    // prints file and directory paths
//			    System.out.println("Drive Name: "+path);
//			    System.out.println("Description: "+fsv.getSystemTypeDescription(path));
//			    System.out.println("Description: "+fsv.getSystemDisplayName(path));
			    
			    if (fsv.getSystemDisplayName(path).toLowerCase().contains(root.toLowerCase())) {
//			    	System.out.print("trovato + " + path);
			    	percorso+=path;
			    	
			    	for (int i=1;i<folders.length;i++) {
				    	percorso+=folders[i]+"\\";
			    	}
			    	
			    	folder=percorso;
			    }
			    
			    
			    
			}		
		}
	}
	
	return folder;
}

public static void setRootFolder(Parametro dtoBase) {
	rootFolder = dtoBase;
}



@SuppressWarnings("resource")
public static void createXLS(DTOBase d) {
	// TODO Auto-generated method stub
	WritableWorkbook wrkbk= null;
	
	Documento n = (Documento) d;
    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-ddd")
            .withLocale(Locale.ITALIAN);
//    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM//yyyy")
//            .withLocale(Locale.ITALIAN);

        LocalDate date = formatter.parseLocalDate(n.getData());
	   String filePath = getRootFolder() + File.separator;
  	   
 	 filePath += n.getRiferimento().getAzienda().getNome() + File.separator;

	filePath += n.getRiferimento().getAzienda().getNome() + "_" + date.getYear() + File.separator;
	
  	String fileName = "";
  	
  	
  	if (n.getRevisione()>0)
       	fileName += n.getDatarev() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
  	else
   	fileName += n.getData() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear();
  	
   	if (n.getRevisione()>0)
   		fileName += " REV. " + n.getRevisione();
   	
   	fileName +=" x ";
// 		      
//	fileName += n.getprodott1i().get(0).getProdotto().getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
	fileName += n.getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
	
	
 		      
 		      
// 		      n.getprodott1i().get(0).getProdotto().getFornitore();
 		      
	   
	   
//	   if (n.getRiferimento()!=null) {
//    	   fileName += n.getRiferimento().getCognome();
//		   
//	   }
	
	   OutputStream outputStream = null;

	   fileName+= ".xlsx";
//	   filePath="";//da rimuovere
 	   try {
		outputStream = new FileOutputStream(filePath + fileName);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
 	   new File(filePath).mkdirs();
 	   try {
 			outputStream = new FileOutputStream(filePath + fileName);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 	   
 	   
 	   
 	   
	}
 	   
 	  try {
 	 	  wrkbk = Workbook.createWorkbook(outputStream);   
 	 	  
 	 	  
 	 	  String nomeFoglio = null;
 	 	  
 	 	  if (n.getRevisione()>0) {
 	 		nomeFoglio = "Analisi su " + n.getTipo().getCategoria().getNome() + " " + n.getNumero() + " REV. " + n.getRevisione() + " del " + n.getDatarev();
 	 	  }
 	 	  else {
 	 	 		nomeFoglio = "Analisi su " + n.getTipo().getCategoria().getNome() + " " + n.getNumero() + " del " + n.getData();
 	 	  }
 	 	  
 	 	  
          // create an Excel sheet
          WritableSheet excelSheet = wrkbk.createSheet(nomeFoglio, 0);
          
          
          
          
          
 	 	  
          
          
          wrkbk.write();
          wrkbk.close();
 	 	  
 	 	  
//		wrkbk.write(outputStream);
		outputStream.close();
		
//	    Desktop.getDesktop().open(new File(filePath + fileName));
		
	} catch (IOException | WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	   
 	   
}
}


//
//
//Documento d = tblAziende.getItems().get(getTableRow().getIndex());
//
//
//Command cmd = new NetworkCommand();
//cmd.setService(ServiceType.leggi);
//cmd.setDto(d);
////stkClienti.push(c);
//
//d=(Documento) execute(cmd);
//
//
//
//
//
//cmd = new NetworkCommand();
//cmd.setService(ServiceType.elenco);
//cmd.setDto(new Parametro());
////stkClienti.push(c);
//
//Parametro param=((ArrayList<Parametro>) execute(cmd)).get(0);
//
//
//OutputStream outputStream = null;
//
//try {    
//	   
//    //now write the PDF content to the output stream
//    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
//            .withLocale(Locale.ITALIAN);
//
//        LocalDate date = formatter.parseLocalDate(d.getData());
//	   String fileName = "";
//
//	   fileName="prova.pdf";
//	   
// 	   outputStream = new FileOutputStream("old" + fileName);
//
// 	   
// 	   
//// 	   PDFPageable pageable;
// 	   float lx;
// 	   float ly;
// 	   float ux;
// 	   float uy;
// 	   
// 	   float imgWidth=50;
// 	   float imgHeight=30;
// 	   int level=0;
// 	   
// 	   float POINTS_PER_INCH = 72;
// 	   float POINTS_PER_MM = 1 / (10 * 2.54f) * POINTS_PER_INCH;
// 	   Rectangle page = PageSize.A4.rotate();
// 	   
// 	   
//	   Document doc = new Document(page);
//	   PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("old" + fileName));
//	   doc.open();
//	   PdfContentByte cb = writer.getDirectContent();
////	   doc.open();
//	   doc.newPage();
//	   
//	   
//    PdfContentByte canvas = writer.getDirectContent();
//    
//	   com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(ClassLoader.getSystemResource("b_tiers/a_presentation/b_dispatcher/img/logorcm.png").getPath());
//	   img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//	   img.scaleAbsolute(50, 50);
//	   doc.add(img);
//	   level++;
////primo rettangolo in cima 
//	   lx=imgWidth*1.1f;  
// ly=page.getHeight()-(imgHeight*level)-1;
// ux=page.getWidth()-1;
// uy=page.getHeight()-1;
// createRectangle(lx, ly, ux, uy,  canvas);
// 
// 
//
//   
// //tipo documento
// level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "OFFERTA (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//    
// //numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//createTextElement(cb, "127", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//createTextElement(cb, "31/12/2017", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//	   
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//
//
//
//doc.newPage();
//
////PdfContentByte canvas = writer.getDirectContent();
//
////com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(ClassLoader.getSystemResource("b_tiers/a_presentation/b_dispatcher/img/logorcm.png").getPath());
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//
//
//
//
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "DETTAGLIO ORDINE (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//
//
//
//doc.newPage();
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//
//
//
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "ORDINE A FORNITORE (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//
//doc.newPage();
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//
//
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "FATTURA DEL FORNITORE (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//doc.newPage();
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//
//
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "FATTURA AL FORNITORE (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//doc.newPage();
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "CONFERMA ORDINE (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//doc.newPage();
//imgWidth=50;
//imgHeight=30;
//level=0;
//img.setAbsolutePosition(0, page.getHeight()-(50*(level+1)));
//img.scaleAbsolute(50, 50);
//doc.add(img);
//level++;
////primo rettangolo in cima 
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()-1;
//uy=page.getHeight()-1;
//createRectangle(lx, ly, ux, uy,  canvas);
////tipo documento
//level++;
//lx=imgWidth*1.1f;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-imgHeight-1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Tipo documento", lx+2,uy-7);
//createTextElement(cb, "DDT IN/OUT (+ Lingua)", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
////writer.close();
//
////numero documento   
//lx=(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()/2)/3+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Numero", lx+2,uy-7);
//
////data  
//lx=(page.getWidth()/2)/3+(page.getWidth()/2);  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Data", lx+2,uy-7);
//
//
////num pagina  
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Pagina", lx+2,uy-7);
////createTextElement(cb, doc.getPageNumber() + " / ", (ux-lx)/2+lx,(uy-ly)/2+ly);
//
//
//
//
//
//level++;
////pagamento
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=page.getWidth()/2;
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Condizioni di pagamento", lx+2,uy-7);
//
//
////trasporto
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Modalità di trasporto", lx+2,uy-7);
//
//
////cliente
//level++;
//lx=1;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()/2);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Offerta riservata a:", lx+2,uy-7-imgHeight);
//
////nfornitore
//lx=page.getWidth()/2;  
//ly=page.getHeight()-(imgHeight*level)-1-imgHeight;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1+imgHeight*2;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Ordine da intestare a:", lx+2,uy-7-imgHeight);
//
//
////colonna posizione
//lx=1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/16;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Item", lx+2,uy-7);
//
////colonna sigla + descrizione
//lx=(page.getWidth()-2)/16;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+1;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sigla", lx+2,uy-7);
//createText(cb, "Descrizione", lx+2,uy-7-7);
////colonna quantità + UM
//lx=(page.getWidth()-2)/2+1;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Quantità", lx+2,uy-7);
////colonna prezzo
//lx=(page.getWidth()-2)/2 + ((page.getWidth()-2)/2)/4;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Prezzo", lx+2,uy-7);
////colonna sconto
//lx=(page.getWidth()-2)/2+ ((page.getWidth()-2)/2)/2;  
//ly=imgHeight+1;
//ux=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createText(cb, "Sconto", lx+2,uy-7);
//createRectangle(lx, ly, ux, uy,  canvas);
//
////colonna totale riga
//lx=(page.getWidth()-2)/2+ (((page.getWidth()-2)/2)/4)*3;  
//ly=imgHeight+1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*level)-1-imgHeight;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale riga", lx+2,uy-7);
//
//
//
//
////base
//lx=1;  
//ly=1;
//ux=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale merce", lx+2,uy-7);
//
////colonne base
////int col=1;
//lx=ux;  
//ly=1;
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//uy=imgHeight+1;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Sconto", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Imponibile", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)/16)-0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale IVA", lx+2,uy-7);
//
//lx=ux;  
//ux+=((page.getWidth()-1)-((page.getWidth()-1)/16))/5+0.5f;
//createRectangle(lx, ly, ux, uy,  canvas);
//createText(cb, "Totale da pagare", lx+2,uy-7);
//
//
//	   
////il numero di pagine viene aggiunto DOPO AVER CHIUSO IL FILE ed aver inserito tutti i dati che servivano
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*2)-1;
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*2)-1+imgHeight;
//
//
//
//
//
//lx=((page.getWidth()/2)/3)*2+(page.getWidth()/2);
//ly=page.getHeight()-(imgHeight*2);
//ux=(page.getWidth()-1);
//uy=page.getHeight()-(imgHeight*2)+imgHeight;
//doc.close();
//
//
//
//PdfReader reader = new PdfReader("old" + fileName);
//int pages = reader.getNumberOfPages();
//PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fileName));
//
//for (int i=0;i<pages;) {
//Font f = new Font(BaseFont.createFont(x"addons/font/arial bold.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED));
//f.setColor(BaseColor.BLUE);
//f.setSize(12);
//Phrase ph = new Phrase(String.format("%s / %s", ++i, pages), f);
//ColumnText.showTextAligned(stamper.getOverContent(i), Element.ALIGN_CENTER, ph, (ux-lx)/2+lx, (uy-ly-12)/2+ly, 0.0f);
//}
//
//
//stamper.close();
//reader.close();
//
//
//       Desktop.getDesktop().open(new File(fileName));
//}catch(Exception e) {
//	e.printStackTrace();
//}
//



