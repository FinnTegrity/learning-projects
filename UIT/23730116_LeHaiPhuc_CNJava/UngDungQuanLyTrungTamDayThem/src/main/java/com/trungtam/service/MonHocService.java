package com.trungtam.service;
import com.trungtam.dao.MonHocDao; import com.trungtam.dao.impl.MonHocDaoImpl; import com.trungtam.model.MonHoc; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class MonHocService {
    private final MonHocDao dao=new MonHocDaoImpl();
    public MonHoc tao(MonHoc o){ var kq=dao.tao(o); KenhSuKien.phat("monhoc.changed", kq); return kq; }
    public void capNhat(MonHoc o){ dao.capNhat(o); KenhSuKien.phat("monhoc.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("monhoc.changed", id); }
    public MonHoc timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<MonHoc> timTatCa(){ return dao.timTatCa(); }
}
