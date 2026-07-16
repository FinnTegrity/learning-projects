package com.trungtam.service;
import com.trungtam.dao.TaiKhoanDao; import com.trungtam.dao.impl.TaiKhoanDaoImpl; import com.trungtam.model.TaiKhoan; import com.trungtam.util.MaHoa;
// Nghiep vu tai khoan
public class TaiKhoanService {
    private final TaiKhoanDao dao=new TaiKhoanDaoImpl();
    public boolean kiemTraDangNhap(String ten, String mk){ TaiKhoan t=dao.timTheoTenDangNhap(ten); if(t==null) return false; String hash=MaHoa.sha256(mk); return hash.equalsIgnoreCase(t.getMatkhauHash()); }
    public String timVaiTro(String ten){ return dao.timVaiTroTheoTenDangNhap(ten); }
}
