package com.trungtam.dao.impl;
import com.trungtam.dao.HocVienDao; import com.trungtam.model.HocVien; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class HocVienDaoImpl implements HocVienDao {
    public HocVien tao(HocVien o){
        String sql="INSERT INTO hocvien(ma, hovaten, sdt, email, diachi, ngaysinh) VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, o.getMa()); ps.setString(2, o.getHovaten()); ps.setString(3, o.getSdt()); ps.setString(4, o.getEmail()); ps.setString(5, o.getDiachi()); if(o.getNgaysinh()!=null) ps.setDate(6, java.sql.Date.valueOf(o.getNgaysinh())); else ps.setNull(6, java.sql.Types.DATE); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(HocVien o){
        String sql="UPDATE hocvien SET ma=?, hovaten=?, sdt=?, email=?, diachi=?, ngaysinh=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, o.getMa()); ps.setString(2, o.getHovaten()); ps.setString(3, o.getSdt()); ps.setString(4, o.getEmail()); ps.setString(5, o.getDiachi()); if(o.getNgaysinh()!=null) ps.setDate(6, java.sql.Date.valueOf(o.getNgaysinh())); else ps.setNull(6, java.sql.Types.DATE); ps.setInt(7, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM hocvien WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public HocVien timTheoId(int id){
        String sql="SELECT * FROM hocvien WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<HocVien> timTatCa(){
        String sql="SELECT * FROM hocvien ORDER BY id DESC";
        java.util.List<HocVien> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private HocVien map(ResultSet rs) throws SQLException {
        HocVien o=new HocVien(); o.setId(rs.getInt("id")); o.setMa(rs.getString("ma")); o.setHovaten(rs.getString("hovaten")); o.setSdt(rs.getString("sdt")); o.setEmail(rs.getString("email")); o.setDiachi(rs.getString("diachi")); java.sql.Date d6=rs.getDate("ngaysinh"); if(d6!=null) o.setNgaysinh(d6.toLocalDate()); return o;
    }
}
