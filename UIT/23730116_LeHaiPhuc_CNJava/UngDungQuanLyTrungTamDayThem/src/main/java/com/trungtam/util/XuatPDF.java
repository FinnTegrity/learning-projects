package com.trungtam.util;
import org.apache.pdfbox.pdmodel.*; import org.apache.pdfbox.pdmodel.common.PDRectangle; import org.apache.pdfbox.pdmodel.font.PDType1Font; import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import javax.imageio.ImageIO; import javax.swing.*; import javax.swing.table.TableModel; import java.awt.image.BufferedImage; import java.io.File; import java.io.IOException; import java.time.LocalDateTime; import java.time.format.DateTimeFormatter;
// Xuat PDF bao cao (tieu de + bang + bieu do)
public class XuatPDF {
    public static void xuatBaoCao(JTable table, BufferedImage chartImage, File outFile, String tieuDe) throws IOException {
        try(PDDocument doc=new PDDocument()){
            PDPage page=new PDPage(PDRectangle.A4); doc.addPage(page);
            PDRectangle r=page.getMediaBox(); float margin=36; float y=r.getUpperRightY()-margin;
            try(PDPageContentStream cs=new PDPageContentStream(doc,page)){
                cs.beginText(); cs.setFont(PDType1Font.HELVETICA_BOLD,16); cs.newLineAtOffset(margin, y-20); cs.showText(tieuDe); cs.endText();
                cs.beginText(); cs.setFont(PDType1Font.HELVETICA,10); cs.newLineAtOffset(margin, y-40); cs.showText("Thoi gian xuat: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); cs.endText();
                TableModel m=table.getModel(); float tableTopY=y-60; float rowH=18; float colW=(r.getWidth()-2*margin)/m.getColumnCount(); float x=margin; float curY=tableTopY;
                cs.setFont(PDType1Font.HELVETICA_BOLD,11);
                for(int c=0;c<m.getColumnCount();c++){ cs.beginText(); cs.newLineAtOffset(x+2, curY-12); cs.showText(safe(m.getColumnName(c))); cs.endText(); x+=colW; }
                cs.moveTo(margin, curY-14); cs.lineTo(r.getWidth()-margin, curY-14); cs.stroke();
                cs.setFont(PDType1Font.HELVETICA,10); curY-=rowH;
                for(int rr=0; rr<m.getRowCount(); rr++){ x=margin; for(int c=0;c<m.getColumnCount();c++){ String val=String.valueOf(m.getValueAt(rr,c)); cs.beginText(); cs.newLineAtOffset(x+2, curY-12); cs.showText(safe(val)); cs.endText(); x+=colW; } curY-=rowH; if(curY < margin+220) break; }
                if(chartImage!=null){ File tmp=File.createTempFile("chart",".png"); javax.imageio.ImageIO.write(chartImage,"png",tmp); PDImageXObject img=PDImageXObject.createFromFile(tmp.getAbsolutePath(),doc); float chartW=r.getWidth()-2*margin, chartH=200; cs.drawImage(img, margin, margin, chartW, chartH); try{tmp.delete();}catch(Exception ignore){} }
            }
            doc.save(outFile);
        }
    }
    private static String safe(String s){ StringBuilder sb=new StringBuilder(); for(char ch: s.toCharArray()){ if(ch>=32 && ch<=126) sb.append(ch); else sb.append(' ');} return sb.toString(); }
}
