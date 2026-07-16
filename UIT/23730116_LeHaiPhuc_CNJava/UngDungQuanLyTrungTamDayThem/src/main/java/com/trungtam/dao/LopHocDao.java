package com.trungtam.dao;
import com.trungtam.model.LopHoc; import java.util.List;
// DAO giao tiep
public interface LopHocDao {
    LopHoc tao(LopHoc o); void capNhat(LopHoc o); void xoa(int id); LopHoc timTheoId(int id); java.util.List<LopHoc> timTatCa();
}
