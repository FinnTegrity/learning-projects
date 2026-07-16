package com.trungtam.ui.panels;
import javax.swing.*;
import com.trungtam.ui.panels.hocvien.HocVienPanel;
import com.trungtam.ui.panels.giaovien.GiaoVienPanel;
import com.trungtam.ui.panels.monhoc.MonHocPanel;
import com.trungtam.ui.panels.lophoc.LopHocPanel;
import com.trungtam.ui.panels.dangky.DangKyPanel;
import com.trungtam.ui.panels.thanhtoan.ThanhToanPanel;
import com.trungtam.ui.panels.baocao.BaoCaoPanel;
// Man hinh chinh
public class ManHinhChinh extends JFrame {
    public ManHinhChinh(String tenDangNhap, String vaiTro){
        setTitle("QL Trung tam - "+tenDangNhap+" ("+vaiTro+")");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JTabbedPane tabs=new JTabbedPane();
        tabs.addTab("Hoc vien", new HocVienPanel());
        tabs.addTab("Giao vien", new GiaoVienPanel());
        tabs.addTab("Mon hoc", new MonHocPanel());
        tabs.addTab("Lop hoc", new LopHocPanel());
        tabs.addTab("Dang ky", new DangKyPanel());
        tabs.addTab("Thanh toan", new ThanhToanPanel());
        tabs.addTab("Bao cao", new BaoCaoPanel());
        setContentPane(tabs); pack(); setLocationRelativeTo(null);
    }
}
