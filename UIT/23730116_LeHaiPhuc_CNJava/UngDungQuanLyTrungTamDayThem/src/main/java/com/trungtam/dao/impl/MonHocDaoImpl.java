package com.trungtam.dao.impl;
import com.trungtam.dao.MonHocDao; import com.trungtam.model.MonHoc; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class MonHocDaoImpl implements MonHocDao {
    public MonHoc tao(MonHoc o){
        String sql="INSERT INTO monhoc(ma, ten, hocphi, sotuantu) VALUES(?, ?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, o.getMa()); ps.setString(2, o.getTen()); ps.setDouble(3, o.getHocphi()); ps.setDouble(4, o.getSotuantu()); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(MonHoc o){
        String sql="UPDATE monhoc SET ma=?, ten=?, hocphi=?, sotuantu=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, o.getMa()); ps.setString(2, o.getTen()); ps.setDouble(3, o.getHocphi()); ps.setDouble(4, o.getSotuantu()); ps.setInt(5, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM monhoc WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public MonHoc timTheoId(int id){
        String sql="SELECT * FROM monhoc WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<MonHoc> timTatCa(){
        String sql="SELECT * FROM monhoc ORDER BY id DESC";
        java.util.List<MonHoc> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private MonHoc map(ResultSet rs) throws SQLException {
        MonHoc o=new MonHoc(); o.setId(rs.getInt("id")); o.setMa(rs.getString("ma")); o.setTen(rs.getString("ten")); o.setHocphi(rs.getDouble("hocphi")); o.setSotuantu(rs.getDouble("sotuantu")); return o;
    }
}
