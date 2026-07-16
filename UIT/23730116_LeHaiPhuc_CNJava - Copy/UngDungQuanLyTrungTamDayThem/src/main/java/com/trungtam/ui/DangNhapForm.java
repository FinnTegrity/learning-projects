package com.trungtam.ui;
import com.trungtam.service.TaiKhoanService;
import com.trungtam.ui.panels.ManHinhChinh;
import javax.swing.*; import java.awt.*;
// Form dang nhap
public class DangNhapForm extends JFrame {
    private JTextField txtTenDangNhap; private JPasswordField txtMatKhau;
    private final TaiKhoanService taiKhoanService = new TaiKhoanService();
    public DangNhapForm(){
        setTitle("Dang nhap - Quan ly trung tam"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,220); setLocationRelativeTo(null); taoUI();
    }
    private void taoUI(){
        JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints();
        g.insets=new Insets(8,8,8,8); g.fill=GridBagConstraints.HORIZONTAL;
        JLabel t=new JLabel("Dang nhap",SwingConstants.CENTER); t.setFont(t.getFont().deriveFont(Font.BOLD,18f));
        g.gridx=0; g.gridy=0; g.gridwidth=2; p.add(t,g);
        g.gridwidth=1; g.gridx=0; g.gridy=1; p.add(new JLabel("Ten dang nhap"),g);
        txtTenDangNhap=new JTextField("admin"); g.gridx=1; p.add(txtTenDangNhap,g);
        g.gridx=0; g.gridy=2; p.add(new JLabel("Mat khau"),g);
        txtMatKhau=new JPasswordField("admin"); g.gridx=1; p.add(txtMatKhau,g);
        JButton btn=new JButton("Dang nhap"); btn.addActionListener(e->dangNhap());
        g.gridx=0; g.gridy=3; g.gridwidth=2; p.add(btn,g);
        setContentPane(p);
    }
    private void dangNhap(){
        String u=txtTenDangNhap.getText().trim(); String p=new String(txtMatKhau.getPassword());
        if(taiKhoanService.kiemTraDangNhap(u,p)){ dispose(); new ManHinhChinh(u, taiKhoanService.timVaiTro(u)).setVisible(true); }
        else JOptionPane.showMessageDialog(this,"Sai ten dang nhap hoac mat khau");
    }
}
