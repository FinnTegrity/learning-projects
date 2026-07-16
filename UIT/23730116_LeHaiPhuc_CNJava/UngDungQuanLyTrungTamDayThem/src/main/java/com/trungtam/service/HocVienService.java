package com.trungtam.service;
import com.trungtam.dao.HocVienDao; import com.trungtam.dao.impl.HocVienDaoImpl; import com.trungtam.model.HocVien; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class HocVienService {
    private final HocVienDao dao=new HocVienDaoImpl();
    public HocVien tao(HocVien o){ var kq=dao.tao(o); KenhSuKien.phat("hocvien.changed", kq); return kq; }
    public void capNhat(HocVien o){ dao.capNhat(o); KenhSuKien.phat("hocvien.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("hocvien.changed", id); }
    public HocVien timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<HocVien> timTatCa(){ return dao.timTatCa(); }
}
