package com.trungtam.service;
import com.trungtam.dao.GiaoVienDao; import com.trungtam.dao.impl.GiaoVienDaoImpl; import com.trungtam.model.GiaoVien; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class GiaoVienService {
    private final GiaoVienDao dao=new GiaoVienDaoImpl();
    public GiaoVien tao(GiaoVien o){ var kq=dao.tao(o); KenhSuKien.phat("giaovien.changed", kq); return kq; }
    public void capNhat(GiaoVien o){ dao.capNhat(o); KenhSuKien.phat("giaovien.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("giaovien.changed", id); }
    public GiaoVien timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<GiaoVien> timTatCa(){ return dao.timTatCa(); }
}
