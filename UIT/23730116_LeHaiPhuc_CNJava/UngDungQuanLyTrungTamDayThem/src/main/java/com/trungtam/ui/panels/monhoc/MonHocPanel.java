package com.trungtam.ui.panels.monhoc;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*; import com.trungtam.service.MonHocService; import com.trungtam.model.MonHoc; import com.trungtam.patterns.observer.KenhSuKien; import com.trungtam.util.XuatCSV;
// Panel MonHoc CRUD + tim kiem + loc nang cao + auto refresh
public class MonHocPanel extends JPanel {
    private MonHocService service=new MonHocService(); private JTable table; private DefaultTableModel model; private JTextField txtTimKiem; private JButton btnXuatCSV; private JTextField txtGiaMin; private JTextField txtGiaMax; private JTextField txt_ma; private JTextField txt_ten; private JTextField txt_hocphi; private JTextField txt_sotuantu;
    public MonHocPanel(){
        setLayout(new BorderLayout(10,10)); add(taoForm(), BorderLayout.NORTH); add(taoBang(), BorderLayout.CENTER); napBang();
        KenhSuKien.dangKy("monhoc.changed", (c,d)-> napBang());
    }
    private JPanel taoForm(){
        JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints(); g.insets=new Insets(5,5,5,5); g.fill=GridBagConstraints.HORIZONTAL; int r=0;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Tim kiem"), g); txtTimKiem=new JTextField(); g.gridx=1; p.add(txtTimKiem,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Hoc phi tu"), g); txtGiaMin=new JTextField(); g.gridx=1; p.add(txtGiaMin,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Hoc phi den"), g); txtGiaMax=new JTextField(); g.gridx=1; p.add(txtGiaMax,g); r++;
        g.gridx=0; g.gridy=r; p.add(new JLabel("Ma"), g); txt_ma=new JTextField(); g.gridx=1; p.add(txt_ma, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("Ten"), g); txt_ten=new JTextField(); g.gridx=1; p.add(txt_ten, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("Hoc phi"), g); txt_hocphi=new JTextField(); g.gridx=1; p.add(txt_hocphi, g); r++; g.gridx=0; g.gridy=r; p.add(new JLabel("So tuan tu"), g); txt_sotuantu=new JTextField(); g.gridx=1; p.add(txt_sotuantu, g); r++;
        JPanel actions=new JPanel(); JButton bThem=new JButton("Them"), bSua=new JButton("Sua"), bXoa=new JButton("Xoa"), bTai=new JButton("Tai lai"); btnXuatCSV=new JButton("Xuat CSV");
        actions.add(bThem); actions.add(bSua); actions.add(bXoa); actions.add(bTai); actions.add(btnXuatCSV);
        g.gridx=0; g.gridy=r; g.gridwidth=2; p.add(actions,g);
        bThem.addActionListener(e->them()); bSua.addActionListener(e->sua()); bXoa.addActionListener(e->xoa()); bTai.addActionListener(e->napBang()); btnXuatCSV.addActionListener(e->xuatCSV());
        txtTimKiem.addActionListener(e->napBang()); if(txtGiaMin!=null) txtGiaMin.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){ public void insertUpdate(javax.swing.event.DocumentEvent e){ napBang(); } public void removeUpdate(javax.swing.event.DocumentEvent e){ napBang(); } public void changedUpdate(javax.swing.event.DocumentEvent e){ napBang(); }});
        if(txtGiaMax!=null) txtGiaMax.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){ public void insertUpdate(javax.swing.event.DocumentEvent e){ napBang(); } public void removeUpdate(javax.swing.event.DocumentEvent e){ napBang(); } public void changedUpdate(javax.swing.event.DocumentEvent e){ napBang(); }});
        txtTimKiem.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){ public void insertUpdate(javax.swing.event.DocumentEvent e){napBang();} public void removeUpdate(javax.swing.event.DocumentEvent e){napBang();} public void changedUpdate(javax.swing.event.DocumentEvent e){napBang();} });
        return p;
    }
    private JScrollPane taoBang(){
        model=new DefaultTableModel(new Object[]{ "ID", "Ma", "Ten", "Hoc phi", "So tuan tu" },0){ public boolean isCellEditable(int r,int c){return false;} };
        table=new JTable(model); table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(e->chon()); return new JScrollPane(table);
    }
    private void chon(){ int i=table.getSelectedRow(); if(i<0) return; int idx=1; txt_ma.setText(String.valueOf(model.getValueAt(i,idx++))); txt_ten.setText(String.valueOf(model.getValueAt(i,idx++))); txt_hocphi.setText(String.valueOf(model.getValueAt(i,idx++))); txt_sotuantu.setText(String.valueOf(model.getValueAt(i,idx++))); }
    private void xuatCSV(){ try{ javax.swing.JFileChooser ch=new javax.swing.JFileChooser(); ch.setSelectedFile(new java.io.File("export.csv")); if(ch.showSaveDialog(this)==javax.swing.JFileChooser.APPROVE_OPTION){ XuatCSV.xuatBang(table, ch.getSelectedFile()); JOptionPane.showMessageDialog(this, "Da xuat: "+ch.getSelectedFile().getAbsolutePath()); } }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi xuat: "+ex.getMessage()); } }
    private boolean phuHopTuKhoa(String s, String q){ if(q==null||q.isEmpty()) return true; if(s==null) return false; return s.toLowerCase().contains(q.toLowerCase()); }
    private boolean kiemTraBoLoc(MonHoc o){ String q=txtTimKiem==null?"":txtTimKiem.getText().trim(); return ((phuHopTuKhoa(o.getMa(), q) || phuHopTuKhoa(o.getTen(), q)) && (( (txtGiaMin==null||txtGiaMin.getText().isEmpty()|| (o.getHocphi()!=null && o.getHocphi()>=Double.parseDouble(txtGiaMin.getText().trim()))) && (txtGiaMax==null||txtGiaMax.getText().isEmpty()|| (o.getHocphi()!=null && o.getHocphi()<=Double.parseDouble(txtGiaMax.getText().trim()))) ))); }
    private void napBang(){ model.setRowCount(0); java.util.List<MonHoc> list=service.timTatCa(); for(MonHoc o: list){ if(kiemTraBoLoc(o)) model.addRow(new Object[]{ o.getId(), o.getMa(), o.getTen(), o.getHocphi(), o.getSotuantu() }); } }
    private void them(){ try{ MonHoc o=new MonHoc(); o.setMa(txt_ma.getText().trim()); o.setTen(txt_ten.getText().trim()); if(!txt_hocphi.getText().trim().isEmpty()) o.setHocphi(Double.parseDouble(txt_hocphi.getText().trim())); if(!txt_sotuantu.getText().trim().isEmpty()) o.setSotuantu(Double.parseDouble(txt_sotuantu.getText().trim())); service.tao(o); }catch(Exception ex){ JOptionPane.showMessageDialog(this, "Loi them: "+ex.getMessage()); } }
    private void sua(){ int i=table.getSelectedRow(); if(i<0){JOptionPane.showMessageDialog(this,"Chon dong de sua");return;} try{ MonHoc o=new MonHoc(); o.setId((Integer)model.getValueAt(i,0)); o.setMa(txt_ma.getText().trim()); o.setTen(txt_ten.getText().trim()); if(!txt_hocphi.getText().trim().isEmpty()) o.setHocphi(Double.parseDouble(txt_hocphi.getText().trim())); if(!txt_sotuantu.getText().trim().isEmpty()) o.setSotuantu(Double.parseDouble(txt_sotuantu.getText().trim())); service.capNhat(o); }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi sua: "+ex.getMessage()); } }
    private void xoa(){ int i=table.getSelectedRow(); if(i<0){JOptionPane.showMessageDialog(this,"Chon dong de xoa");return;} if(JOptionPane.showConfirmDialog(this,"Xoa?","Xac nhan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ try{ service.xoa((Integer)model.getValueAt(i,0)); }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Loi xoa: "+ex.getMessage()); } } }
}

