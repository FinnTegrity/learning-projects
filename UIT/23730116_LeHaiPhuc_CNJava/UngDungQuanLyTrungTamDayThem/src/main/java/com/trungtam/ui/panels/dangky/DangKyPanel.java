package com.trungtam.ui.panels.dangky;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*;
import com.trungtam.model.*; import com.trungtam.service.*; import com.trungtam.patterns.observer.KenhSuKien; import com.trungtam.util.XuatCSV;
// Dang ky hoc
public class DangKyPanel extends JPanel {
    private JTable table; private DefaultTableModel model;
    private DangKyService dangKyService=new DangKyService(); private HocVienService hocVienService=new HocVienService(); private LopHocService lopHocService=new LopHocService();
    private JComboBox<Object> cbHocVien; private JComboBox<Object> cbLopHoc; private JTextField txtTrangThai;
    public DangKyPanel(){ setLayout(new BorderLayout(10,10)); add(taoForm(), BorderLayout.NORTH); add(taoBang(), BorderLayout.CENTER); napBang();
        KenhSuKien.dangKy("hocvien.changed",(c,d)-> napCombo()); KenhSuKien.dangKy("lophoc.changed",(c,d)-> napCombo()); KenhSuKien.dangKy("dangky.changed",(c,d)-> napBang()); }
    private void napCombo(){ cbHocVien.removeAllItems(); for(HocVien hv: hocVienService.timTatCa()) cbHocVien.addItem(hv.getId()+" - "+hv.getHovaten());
        cbLopHoc.removeAllItems(); for(LopHoc lh: lopHocService.timTatCa()) cbLopHoc.addItem(lh.getId()+" - MonID "+lh.getMonhocId()); }
    private JPanel taoForm(){ JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints(); g.insets=new Insets(5,5,5,5); g.fill=GridBagConstraints.HORIZONTAL; int r=0;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Hoc vien"),g); cbHocVien=new JComboBox<>(); g.gridx=1; p.add(cbHocVien,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Lop hoc"),g); cbLopHoc=new JComboBox<>(); g.gridx=1; p.add(cbLopHoc,g); r++;
        napCombo();
        g.gridx=0; g.gridy=r; p.add(new JLabel("Trang thai"),g); txtTrangThai=new JTextField("DANG_HOC"); g.gridx=1; p.add(txtTrangThai,g); r++;
        JPanel a=new JPanel(); JButton bThem=new JButton("Dang ky"), bXoa=new JButton("Xoa"), bTai=new JButton("Tai lai"), bCSV=new JButton("Xuat CSV");
        a.add(bThem); a.add(bXoa); a.add(bTai); a.add(bCSV);
        g.gridx=0; g.gridy=r; g.gridwidth=2; p.add(a,g);
        bThem.addActionListener(e->them()); bXoa.addActionListener(e->xoa()); bTai.addActionListener(e->napBang()); bCSV.addActionListener(e->xuatCSV()); return p; }
    private JScrollPane taoBang(){ model=new DefaultTableModel(new Object[]{"ID","HocVienID","LopHocID","TrangThai"},0){ public boolean isCellEditable(int r,int c){return false;} };
        table=new JTable(model); return new JScrollPane(table); }
    private void napBang(){ model.setRowCount(0); for(DangKy dk: dangKyService.timTatCa()) model.addRow(new Object[]{ dk.getId(), dk.getHocvienId(), dk.getLophocId(), dk.getTrangthai() }); }
    private Integer parseId(Object item){ if(item==null) return null; String s=item.toString(); int i=s.indexOf(" - "); return Integer.parseInt(i>0? s.substring(0,i): s); }
    private void them(){ try{ DangKy dk=new DangKy(); dk.setHocvienId(parseId(cbHocVien.getSelectedItem())); dk.setLophocId(parseId(cbLopHoc.getSelectedItem())); dk.setTrangthai(txtTrangThai.getText().trim()); dangKyService.tao(dk); }
        catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi dang ky: "+ex.getMessage()); } }
    private void xoa(){ int i=table.getSelectedRow(); if(i<0){ JOptionPane.showMessageDialog(this,"Chon dong de xoa"); return; } if(JOptionPane.showConfirmDialog(this,"Xoa?","Xac nhan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ try{ dangKyService.xoa((Integer)model.getValueAt(i,0)); } catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi xoa: "+ex.getMessage()); } } }
    private void xuatCSV(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("dangky.csv")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ XuatCSV.xuatBang(table, ch.getSelectedFile()); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } } catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi xuat: "+ex.getMessage()); } }
}

