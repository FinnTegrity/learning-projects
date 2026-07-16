package com.trungtam.service;
import com.trungtam.dao.DangKyDao; import com.trungtam.dao.impl.DangKyDaoImpl; import com.trungtam.model.DangKy; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class DangKyService {
    private final DangKyDao dao=new DangKyDaoImpl();
    public DangKy tao(DangKy o){ var kq=dao.tao(o); KenhSuKien.phat("dangky.changed", kq); return kq; }
    public void capNhat(DangKy o){ dao.capNhat(o); KenhSuKien.phat("dangky.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("dangky.changed", id); }
    public DangKy timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<DangKy> timTatCa(){ return dao.timTatCa(); }
}
