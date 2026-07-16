package com.trungtam.dao;
import com.trungtam.model.HocVien; import java.util.List;
// DAO giao tiep
public interface HocVienDao {
    HocVien tao(HocVien o); void capNhat(HocVien o); void xoa(int id); HocVien timTheoId(int id); java.util.List<HocVien> timTatCa();
}
