package com.trungtam.dao.impl;
import com.trungtam.dao.ThanhToanDao; import com.trungtam.model.ThanhToan; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class ThanhToanDaoImpl implements ThanhToanDao {
    public ThanhToan tao(ThanhToan o){
        String sql="INSERT INTO thanhtoan(dangky_id, sotien, phuongthuc, ghichu) VALUES(?, ?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, o.getDangkyId()); ps.setDouble(2, o.getSotien()); ps.setString(3, o.getPhuongthuc()); ps.setString(4, o.getGhichu()); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(ThanhToan o){
        String sql="UPDATE thanhtoan SET dangky_id=?, sotien=?, phuongthuc=?, ghichu=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1, o.getDangkyId()); ps.setDouble(2, o.getSotien()); ps.setString(3, o.getPhuongthuc()); ps.setString(4, o.getGhichu()); ps.setInt(5, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM thanhtoan WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public ThanhToan timTheoId(int id){
        String sql="SELECT * FROM thanhtoan WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<ThanhToan> timTatCa(){
        String sql="SELECT * FROM thanhtoan ORDER BY id DESC";
        java.util.List<ThanhToan> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private ThanhToan map(ResultSet rs) throws SQLException {
        ThanhToan o=new ThanhToan(); o.setId(rs.getInt("id")); o.setDangkyId(rs.getInt("dangky_id")); o.setSotien(rs.getDouble("sotien")); o.setPhuongthuc(rs.getString("phuongthuc")); o.setGhichu(rs.getString("ghichu")); return o;
    }
}
