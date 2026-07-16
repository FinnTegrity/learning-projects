package com.trungtam.dao;
import com.trungtam.model.ThanhToan; import java.util.List;
// DAO giao tiep
public interface ThanhToanDao {
    ThanhToan tao(ThanhToan o); void capNhat(ThanhToan o); void xoa(int id); ThanhToan timTheoId(int id); java.util.List<ThanhToan> timTatCa();
}
