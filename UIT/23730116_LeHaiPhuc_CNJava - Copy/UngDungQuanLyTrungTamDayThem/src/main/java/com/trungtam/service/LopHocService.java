package com.trungtam.service;
import com.trungtam.dao.LopHocDao; import com.trungtam.dao.impl.LopHocDaoImpl; import com.trungtam.model.LopHoc; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class LopHocService {
    private final LopHocDao dao=new LopHocDaoImpl();
    public LopHoc tao(LopHoc o){ var kq=dao.tao(o); KenhSuKien.phat("lophoc.changed", kq); return kq; }
    public void capNhat(LopHoc o){ dao.capNhat(o); KenhSuKien.phat("lophoc.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("lophoc.changed", id); }
    public LopHoc timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<LopHoc> timTatCa(){ return dao.timTatCa(); }
}
