package com.trungtam.dao.impl;
import com.trungtam.dao.DangKyDao; import com.trungtam.model.DangKy; import com.trungtam.util.KetNoiDB;
import java.sql.*; import java.util.*;
// DAO trien khai
public class DangKyDaoImpl implements DangKyDao {
    public DangKy tao(DangKy o){
        String sql="INSERT INTO dangky(hocvien_id, lophoc_id, trangthai) VALUES(?, ?, ?)";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, o.getHocvienId()); ps.setInt(2, o.getLophocId()); ps.setString(3, o.getTrangthai()); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) o.setId(rs.getInt(1)); } return o;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void capNhat(DangKy o){
        String sql="UPDATE dangky SET hocvien_id=?, lophoc_id=?, trangthai=? WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1, o.getHocvienId()); ps.setInt(2, o.getLophocId()); ps.setString(3, o.getTrangthai()); ps.setInt(4, o.getId()); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public void xoa(int id){
        String sql="DELETE FROM dangky WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); ps.executeUpdate();
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public DangKy timTheoId(int id){
        String sql="SELECT * FROM dangky WHERE id=?";
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs=ps.executeQuery()){ if(rs.next()) return map(rs); } return null;
        } catch(SQLException e){ throw new RuntimeException(e); }
    }
    public java.util.List<DangKy> timTatCa(){
        String sql="SELECT * FROM dangky ORDER BY id DESC";
        java.util.List<DangKy> list=new java.util.ArrayList<>();
        try(Connection c=KetNoiDB.layKetNoi(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){ while(rs.next()) list.add(map(rs)); }
        catch(SQLException e){ throw new RuntimeException(e); }
        return list;
    }
    private DangKy map(ResultSet rs) throws SQLException {
        DangKy o=new DangKy(); o.setId(rs.getInt("id")); o.setHocvienId(rs.getInt("hocvien_id")); o.setLophocId(rs.getInt("lophoc_id")); o.setTrangthai(rs.getString("trangthai")); return o;
    }
}
