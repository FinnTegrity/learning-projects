package com.trungtam.dao.impl;
import com.trungtam.dao.GiaoVienDao; import com.trungtam.model.GiaoVien; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class GiaoVienDaoImpl implements GiaoVienDao {
    public GiaoVien tao(GiaoVien o){
        String sql="INSERT INTO giaovien(hovaten, sdt, email, chunghiem) VALUES(?, ?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, o.getHovaten()); ps.setString(2, o.getSdt()); ps.setString(3, o.getEmail()); ps.setString(4, o.getChunghiem()); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(GiaoVien o){
        String sql="UPDATE giaovien SET hovaten=?, sdt=?, email=?, chunghiem=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, o.getHovaten()); ps.setString(2, o.getSdt()); ps.setString(3, o.getEmail()); ps.setString(4, o.getChunghiem()); ps.setInt(5, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM giaovien WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public GiaoVien timTheoId(int id){
        String sql="SELECT * FROM giaovien WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<GiaoVien> timTatCa(){
        String sql="SELECT * FROM giaovien ORDER BY id DESC";
        java.util.List<GiaoVien> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private GiaoVien map(ResultSet rs) throws SQLException {
        GiaoVien o=new GiaoVien(); o.setId(rs.getInt("id")); o.setHovaten(rs.getString("hovaten")); o.setSdt(rs.getString("sdt")); o.setEmail(rs.getString("email")); o.setChunghiem(rs.getString("chunghiem")); return o;
    }
}
