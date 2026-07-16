package com.trungtam.dao.impl;
import com.trungtam.dao.LopHocDao; import com.trungtam.model.LopHoc; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class LopHocDaoImpl implements LopHocDao {
    public LopHoc tao(LopHoc o){
        String sql="INSERT INTO lophoc(monhoc_id, giaovien_id, phong, lich, ngaybatdau, ngayketthuc) VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, o.getMonhocId()); ps.setInt(2, o.getGiaovienId()); ps.setString(3, o.getPhong()); ps.setString(4, o.getLich()); if(o.getNgaybatdau()!=null) ps.setDate(5, java.sql.Date.valueOf(o.getNgaybatdau())); else ps.setNull(5, java.sql.Types.DATE); if(o.getNgayketthuc()!=null) ps.setDate(6, java.sql.Date.valueOf(o.getNgayketthuc())); else ps.setNull(6, java.sql.Types.DATE); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(LopHoc o){
        String sql="UPDATE lophoc SET monhoc_id=?, giaovien_id=?, phong=?, lich=?, ngaybatdau=?, ngayketthuc=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1, o.getMonhocId()); ps.setInt(2, o.getGiaovienId()); ps.setString(3, o.getPhong()); ps.setString(4, o.getLich()); if(o.getNgaybatdau()!=null) ps.setDate(5, java.sql.Date.valueOf(o.getNgaybatdau())); else ps.setNull(5, java.sql.Types.DATE); if(o.getNgayketthuc()!=null) ps.setDate(6, java.sql.Date.valueOf(o.getNgayketthuc())); else ps.setNull(6, java.sql.Types.DATE); ps.setInt(7, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM lophoc WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public LopHoc timTheoId(int id){
        String sql="SELECT * FROM lophoc WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<LopHoc> timTatCa(){
        String sql="SELECT * FROM lophoc ORDER BY id DESC";
        java.util.List<LopHoc> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private LopHoc map(ResultSet rs) throws SQLException {
        LopHoc o=new LopHoc(); o.setId(rs.getInt("id")); o.setMonhocId(rs.getInt("monhoc_id")); o.setGiaovienId(rs.getInt("giaovien_id")); o.setPhong(rs.getString("phong")); o.setLich(rs.getString("lich")); java.sql.Date d5=rs.getDate("ngaybatdau"); if(d5!=null) o.setNgaybatdau(d5.toLocalDate()); java.sql.Date d6=rs.getDate("ngayketthuc"); if(d6!=null) o.setNgayketthuc(d6.toLocalDate()); return o;
    }
}
