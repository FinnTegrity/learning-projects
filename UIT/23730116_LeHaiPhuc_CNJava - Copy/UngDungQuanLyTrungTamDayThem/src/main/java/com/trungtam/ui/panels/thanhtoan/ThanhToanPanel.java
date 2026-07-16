package com.trungtam.ui.panels.thanhtoan;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*;
import com.trungtam.model.*; import com.trungtam.service.*; import com.trungtam.patterns.strategy.*; import com.trungtam.patterns.observer.KenhSuKien; import com.trungtam.util.XuatCSV;
// Thanh toan
public class ThanhToanPanel extends JPanel {
    private JTable table; private DefaultTableModel model; private ThanhToanService service=new ThanhToanService();
    private DangKyService dangKyService=new DangKyService(); private MonHocService monHocService=new MonHocService(); private LopHocService lopHocService=new LopHocService();
    private JComboBox<Object> cbDangKy; private JComboBox<String> cbChienLuoc; private JTextField txtSoTien, txtPhuongThuc, txtGhiChu;
    public ThanhToanPanel(){ setLayout(new BorderLayout(10,10)); add(taoForm(), BorderLayout.NORTH); add(taoBang(), BorderLayout.CENTER); napBang();
        KenhSuKien.dangKy("dangky.changed",(c,d)-> napComboDangKy()); KenhSuKien.dangKy("thanhtoan.changed",(c,d)-> napBang()); }
    private void napComboDangKy(){ cbDangKy.removeAllItems(); for(DangKy dk: dangKyService.timTatCa()) cbDangKy.addItem(dk.getId()+" - HV "+dk.getHocvienId()+" - LH "+dk.getLophocId()); }
    private JPanel taoForm(){ JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints(); g.insets=new Insets(5,5,5,5); g.fill=GridBagConstraints.HORIZONTAL; int r=0;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Dang ky"),g); cbDangKy=new JComboBox<>(); g.gridx=1; p.add(cbDangKy,g); r++;
        napComboDangKy();
        g.gridx=0; g.gridy=r; p.add(new JLabel("Chien luoc hoc phi"),g); cbChienLuoc=new JComboBox<>(new String[]{"KhongGiamGia","GiamAnhEm","GiamCombo"}); g.gridx=1; p.add(cbChienLuoc,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("So tien"),g); txtSoTien=new JTextField(); g.gridx=1; p.add(txtSoTien,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Phuong thuc"),g); txtPhuongThuc=new JTextField("TIENMAT"); g.gridx=1; p.add(txtPhuongThuc,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Ghi chu"),g); txtGhiChu=new JTextField(); g.gridx=1; p.add(txtGhiChu,g); r++;
        JPanel a=new JPanel(); JButton bTinh=new JButton("Tinh hoc phi tu mon"), bThem=new JButton("Thanh toan"), bTai=new JButton("Tai lai"), bCSV=new JButton("Xuat CSV"); a.add(bTinh); a.add(bThem); a.add(bTai); a.add(bCSV);
        g.gridx=0; g.gridy=r; g.gridwidth=2; p.add(a,g);
        bTinh.addActionListener(e->tinhHocPhi()); bThem.addActionListener(e->them()); bTai.addActionListener(e->napBang()); bCSV.addActionListener(e->xuatCSV()); return p; }
    private JScrollPane taoBang(){ model=new DefaultTableModel(new Object[]{"ID","DangKyID","SoTien","PhuongThuc","GhiChu"},0){ public boolean isCellEditable(int r,int c){return false;} }; table=new JTable(model); return new JScrollPane(table); }
    private void napBang(){ model.setRowCount(0); for(ThanhToan tt: service.timTatCa()) model.addRow(new Object[]{ tt.getId(), tt.getDangkyId(), tt.getSotien(), tt.getPhuongthuc(), tt.getGhichu() }); }
    private Integer parseId(Object item){ if(item==null) return null; String s=item.toString(); int i=s.indexOf(" - "); return Integer.parseInt(i>0? s.substring(0,i): s); }
    private ChienLuocHocPhi layChienLuoc(){ String s=(String)cbChienLuoc.getSelectedItem(); if("GiamAnhEm".equals(s)) return new GiamAnhEm(); if("GiamCombo".equals(s)) return new GiamCombo(); return new KhongGiamGia(); }
    private void tinhHocPhi(){ try{ Integer dkId=parseId(cbDangKy.getSelectedItem()); if(dkId==null){ JOptionPane.showMessageDialog(this,"Chon dang ky"); return; } DangKy dk=dangKyService.timTheoId(dkId); LopHoc lh=lopHocService.timTheoId(dk.getLophocId()); Double hocPhiCoBan=monHocService.timTheoId(lh.getMonhocId()).getHocphi(); double soTien=layChienLuoc().apDung(hocPhiCoBan); txtSoTien.setText(String.valueOf(soTien)); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi tinh: "+ex.getMessage()); } }
    private void them(){ try{ ThanhToan tt=new ThanhToan(); tt.setDangkyId(parseId(cbDangKy.getSelectedItem())); tt.setSotien(Double.parseDouble(txtSoTien.getText().trim())); tt.setPhuongthuc(txtPhuongThuc.getText().trim()); tt.setGhichu(txtGhiChu.getText().trim()); service.tao(tt); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi thanh toan: "+ex.getMessage()); } }
    private void xuatCSV(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("thanhtoan.csv")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ XuatCSV.xuatBang(table, ch.getSelectedFile()); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } } catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi xuat: "+ex.getMessage()); } }
}

