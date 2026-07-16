package com.trungtam.dao.impl;
import com.trungtam.dao.TaiKhoanDao; import com.trungtam.model.TaiKhoan; import com.trungtam.util.KetNoiDB;
import java.sql.*;
// Truy van tai khoan
public class TaiKhoanDaoImpl implements TaiKhoanDao {
    public TaiKhoan timTheoTenDangNhap(String u){
        String sql="SELECT * FROM taikhoan WHERE tendangnhap=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,u); try(ResultSet rs=ps.executeQuery()){ if(rs.next()){ TaiKhoan t=new TaiKhoan(); t.setId(rs.getInt("id")); t.setTendangnhap(rs.getString("tendangnhap")); t.setMatkhauHash(rs.getString("matkhau_hash")); t.setHovaten(rs.getString("hovaten")); t.setVaitroId(rs.getInt("vaitro_id")); return t; } } return null;
        }catch(SQLException e){ throw new RuntimeException(e); }
    }
    public String timVaiTroTheoTenDangNhap(String u){
        String sql="SELECT v.ten FROM taikhoan t JOIN vaitro v ON t.vaitro_id=v.id WHERE t.tendangnhap=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){ ps.setString(1,u); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return rs.getString(1); } return "UNKNOWN"; }
        catch(SQLException e){ throw new RuntimeException(e); }
    }
}
