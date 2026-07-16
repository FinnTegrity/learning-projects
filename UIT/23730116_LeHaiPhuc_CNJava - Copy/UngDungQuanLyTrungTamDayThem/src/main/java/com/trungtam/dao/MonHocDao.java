package com.trungtam.dao;
import com.trungtam.model.MonHoc; import java.util.List;
// DAO giao tiep
public interface MonHocDao {
    MonHoc tao(MonHoc o); void capNhat(MonHoc o); void xoa(int id); MonHoc timTheoId(int id); java.util.List<MonHoc> timTatCa();
}
