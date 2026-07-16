package com.trungtam.service;
import com.trungtam.dao.ThanhToanDao; import com.trungtam.dao.impl.ThanhToanDaoImpl; import com.trungtam.model.ThanhToan; import com.trungtam.patterns.observer.KenhSuKien;
// Tang nghiep vu
public class ThanhToanService {
    private final ThanhToanDao dao=new ThanhToanDaoImpl();
    public ThanhToan tao(ThanhToan o){ var kq=dao.tao(o); KenhSuKien.phat("thanhtoan.changed", kq); return kq; }
    public void capNhat(ThanhToan o){ dao.capNhat(o); KenhSuKien.phat("thanhtoan.changed", o); }
    public void xoa(int id){ dao.xoa(id); KenhSuKien.phat("thanhtoan.changed", id); }
    public ThanhToan timTheoId(int id){ return dao.timTheoId(id); }
    public java.util.List<ThanhToan> timTatCa(){ return dao.timTatCa(); }
}
