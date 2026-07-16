package com.trungtam.util;
import javax.swing.JTable; import javax.swing.table.TableModel; import java.io.*;
// Tien ich xuat bang JTable ra CSV (UTF-8 BOM)
public class XuatCSV {
    public static void xuatBang(JTable table, File file) throws IOException {
        try(FileOutputStream fos=new FileOutputStream(file);
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter w=new BufferedWriter(osw)){
            fos.write(0xEF); fos.write(0xBB); fos.write(0xBF);
            TableModel m=table.getModel();
            for(int c=0;c<m.getColumnCount();c++){ if(c>0) w.write(","); w.write(escape(m.getColumnName(c))); }
            w.write("\n");
            for(int r=0;r<m.getRowCount();r++){ for(int c=0;c<m.getColumnCount();c++){ if(c>0) w.write(","); Object v=m.getValueAt(r,c); w.write(escape(v==null?"":String.valueOf(v))); } w.write("\n"); }
        }
    }
    private static String escape(String s){ boolean need = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r"); s=s.replace("\"","\"\""); return need?("\""+s+"\""):s; }
}
