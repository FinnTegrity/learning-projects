package com.trungtam.dao;
import com.trungtam.model.GiaoVien; import java.util.List;
// DAO giao tiep
public interface GiaoVienDao {
    GiaoVien tao(GiaoVien o); void capNhat(GiaoVien o); void xoa(int id); GiaoVien timTheoId(int id); java.util.List<GiaoVien> timTatCa();
}
