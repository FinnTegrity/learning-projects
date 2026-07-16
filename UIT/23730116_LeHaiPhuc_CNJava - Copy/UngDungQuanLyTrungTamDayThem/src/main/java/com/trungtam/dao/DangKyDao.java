package com.trungtam.dao;
import com.trungtam.model.DangKy; import java.util.List;
// DAO giao tiep
public interface DangKyDao {
    DangKy tao(DangKy o); void capNhat(DangKy o); void xoa(int id); DangKy timTheoId(int id); java.util.List<DangKy> timTatCa();
}
