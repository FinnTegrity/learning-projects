package com.trungtam.ui.panels.giaovien;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*; import com.trungtam.service.GiaoVienService; import com.trungtam.model.GiaoVien; import com.trungtam.patterns.observer.KenhSuKien; import com.trungtam.util.XuatCSV;
// Panel GiaoVien CRUD + tim kiem + loc nang cao + auto refresh
public class GiaoVienPanel extends JPanel {
    private GiaoVienService service=new GiaoVienService(); private JTable table; private DefaultTableModel model; private JTextField txtTimKiem; private JButton btnXuatCSV;  private JTextField txt_hovaten; private JTextField txt_sdt; private JTextField txt_email; private JTextField txt_chunghiem;
    public GiaoVienPanel(){
        setLayout(new BorderLayout(10,10)); add(taoForm(), BorderLayout.NORTH); add(taoBang(), BorderLayout.CENTER); napBang();
        KenhSuKien.dangKy("giaovien.changed", (c,d)-> napBang());
    }
    private JPanel taoForm(){
        JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints(); g.insets=new Insets(5,5,5,5); g.fill=GridBagConstraints.HORIZONTAL; int r=0;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Tim kiem"), g); txtTimKiem=new JTextField(); g.gridx=1; p.add(txtTimKiem,g); r++;
        
        g.gridx=0; g.gridy=r; p.add(new JLabel("Ho va ten"), g); txt_hovaten=new JTextField(); g.gridx=1; p.add(txt_hovaten, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("SDT"), g); txt_sdt=new JTextField(); g.gridx=1; p.add(txt_sdt, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("Email"), g); txt_email=new JTextField(); g.gridx=1; p.add(txt_email, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("Chuyen mon"), g); txt_chunghiem=new JTextField(); g.gridx=1; p.add(txt_chunghiem, g); r++;
        JPanel actions=new JPanel(); JButton bThem=new JButton("Them"), bSua=new JButton("Sua"), bXoa=new JButton("Xoa"), bTai=new JButton("Tai lai"); btnXuatCSV=new JButton("Xuat CSV");
        actions.add(bThem); actions.add(bSua); actions.add(bXoa); actions.add(bTai); actions.add(btnXuatCSV);
        g.gridx=0; g.gridy=r; g.gridwidth=2; p.add(actions,g);
        bThem.addActionListener(e->them()); bSua.addActionListener(e->sua()); bXoa.addActionListener(e->xoa()); bTai.addActionListener(e->napBang()); btnXuatCSV.addActionListener(e->xuatCSV());
        txtTimKiem.addActionListener(e->napBang()); 
        txtTimKiem.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){ public void insertUpdate(javax.swing.event.DocumentEvent e){napBang();} public void removeUpdate(javax.swing.event.DocumentEvent e){napBang();} public void changedUpdate(javax.swing.event.DocumentEvent e){napBang();} });
        return p;
    }
    private JScrollPane taoBang(){
        model=new DefaultTableModel(new Object[]{ "ID", "Ho va ten", "SDT", "Email", "Chuyen mon" },0){ public boolean isCellEditable(int r,int c){return false;} };
        table=new JTable(model); table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(e->chon()); return new JScrollPane(table);
    }
    private void chon(){ int i=table.getSelectedRow(); if(i<0) return; int idx=1; txt_hovaten.setText(String.valueOf(model.getValueAt(i,idx++))); txt_sdt.setText(String.valueOf(model.getValueAt(i,idx++))); txt_email.setText(String.valueOf(model.getValueAt(i,idx++))); txt_chunghiem.setText(String.valueOf(model.getValueAt(i,idx++))); }
    private void xuatCSV(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("export.csv")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ XuatCSV.xuatBang(table, ch.getSelectedFile()); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi xuat: "+ex.getMessage()); } }
    private boolean phuHopTuKhoa(String s, String q){ if(q==null||q.isEmpty()) return true; if(s==null) return false; return s.toLowerCase().contains(q.toLowerCase()); }
    private boolean kiemTraBoLoc(GiaoVien o){ String q=txtTimKiem==null?"":txtTimKiem.getText().trim(); return ((phuHopTuKhoa(o.getHovaten(), q) || phuHopTuKhoa(o.getSdt(), q) || phuHopTuKhoa(o.getEmail(), q) || phuHopTuKhoa(o.getChunghiem(), q)) && (true)); }
    private void napBang(){ model.setRowCount(0); java.util.List<GiaoVien> list=service.timTatCa(); for(GiaoVien o: list){ if(kiemTraBoLoc(o)) model.addRow(new Object[]{ o.getId(), o.getHovaten(), o.getSdt(), o.getEmail(), o.getChunghiem() }); } }
    private void them(){ try{ GiaoVien o=new GiaoVien(); o.setHovaten(txt_hovaten.getText().trim()); o.setSdt(txt_sdt.getText().trim()); o.setEmail(txt_email.getText().trim()); o.setChunghiem(txt_chunghiem.getText().trim()); service.tao(o); }catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi them: "+ex.getMessage()); } }
    private void sua(){ int i=table.getSelectedRow(); if(i<0){JOptionPane.showMessageDialog(this,"Chon dong de sua");return;} try{ GiaoVien o=new GiaoVien(); o.setId((Integer)model.getValueAt(i,0)); o.setHovaten(txt_hovaten.getText().trim()); o.setSdt(txt_sdt.getText().trim()); o.setEmail(txt_email.getText().trim()); o.setChunghiem(txt_chunghiem.getText().trim()); service.capNhat(o); }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi sua: "+ex.getMessage()); } }
    private void xoa(){ int i=table.getSelectedRow(); if(i<0){JOptionPane.showMessageDialog(this,"Chon dong de xoa");return;} if(JOptionPane.showConfirmDialog(this,"Xoa?","Xac nhan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ try{ service.xoa((Integer)model.getValueAt(i,0)); }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi xoa: "+ex.getMessage()); } } }
}

