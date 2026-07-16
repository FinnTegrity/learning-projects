package com.trungtam.ui.panels.baocao;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*; import java.sql.*; import com.trungtam.util.KetNoiDB; import com.trungtam.util.XuatCSV;
import org.jfree.data.category.DefaultCategoryDataset; import org.jfree.chart.ChartFactory; import org.jfree.chart.JFreeChart; import org.jfree.chart.ChartPanel; import java.awt.image.BufferedImage; import com.trungtam.util.XuatPDF;
// Bao cao doanh thu theo thang + Chart + Xuat CSV/PDF
public class BaoCaoPanel extends JPanel {
    private JTable table; private DefaultTableModel model; private JTextField txtNam; private JButton btnXuatCSV; private JButton btnXuatPDF; private JPanel chartHolder; private JFreeChart chart;
    public BaoCaoPanel(){ setLayout(new BorderLayout(10,10)); add(taoForm(), BorderLayout.NORTH);
        JPanel center=new JPanel(new BorderLayout(10,10)); chartHolder=new JPanel(new BorderLayout()); center.add(chartHolder, BorderLayout.NORTH); center.add(taoBang(), BorderLayout.CENTER); add(center, BorderLayout.CENTER);
    }
    private JPanel taoForm(){ JPanel p=new JPanel(new FlowLayout(FlowLayout.LEFT)); p.add(new JLabel("Nam")); txtNam=new JTextField("2025",6); p.add(txtNam);
        JButton b=new JButton("Thong ke"); b.addActionListener(e->thongKe()); p.add(b);
        btnXuatCSV=new JButton("Xuat CSV"); btnXuatCSV.addActionListener(e->xuatCSV()); p.add(btnXuatCSV);
        btnXuatPDF=new JButton("Xuat PDF"); btnXuatPDF.addActionListener(e->xuatPDF()); p.add(btnXuatPDF);
        return p; }
    private JScrollPane taoBang(){ model=new DefaultTableModel(new Object[]{"Thang","Tong thu"},0){ public boolean isCellEditable(int r,int c){return false;} }; table=new JTable(model); return new JScrollPane(table); }
    private void thongKe(){ model.setRowCount(0); String nam=txtNam.getText().trim();
        String sqlMy="SELECT MONTH(ngaytt) thang, SUM(sotien) tong FROM thanhtoan WHERE YEAR(ngaytt)=? GROUP BY MONTH(ngaytt) ORDER BY thang";
        String sqlMs="SELECT DATEPART(MONTH, ngaytt) thang, SUM(sotien) tong FROM thanhtoan WHERE DATEPART(YEAR, ngaytt)=? GROUP BY DATEPART(MONTH, ngaytt) ORDER BY thang";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sqlMy)){ ps.setInt(1, Integer.parseInt(nam)); try(ResultSet rs=ps.executeQuery()){ while(rs.next()) model.addRow(new Object[]{ rs.getInt(1), rs.getDouble(2)}); } }
        catch(Exception e){ try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sqlMs)){ ps.setInt(1, Integer.parseInt(nam)); try(ResultSet rs=ps.executeQuery()){ while(rs.next()) model.addRow(new Object[]{ rs.getInt(1), rs.getDouble(2)}); } } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi thong ke: "+ex.getMessage()); } }
        veBieuDo();
    }
    private void veBieuDo(){ DefaultCategoryDataset ds = new DefaultCategoryDataset(); for(int r=0;r<model.getRowCount();r++){ Number thang=(Number)model.getValueAt(r,0); Number tong=(Number)model.getValueAt(r,1); ds.addValue(tong.doubleValue(),"Doanh thu","T"+thang.intValue()); }
        chart = ChartFactory.createBarChart("Doanh thu theo thang ("+txtNam.getText().trim()+")","Thang","So tien", ds);
        chartHolder.removeAll(); chartHolder.add(new ChartPanel(chart), BorderLayout.CENTER); chartHolder.revalidate(); chartHolder.repaint(); }
    private void xuatCSV(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("baocao.csv")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ XuatCSV.xuatBang(table, ch.getSelectedFile()); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } } catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi xuat: "+ex.getMessage()); } }
    private void xuatPDF(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("baocao.pdf")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ BufferedImage img=null; if(chart!=null) img=chart.createBufferedImage(800,400); XuatPDF.xuatBaoCao(table, img, ch.getSelectedFile(), "Bao cao doanh thu theo thang"); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } } catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi xuat PDF: "+ex.getMessage()); } }
}

