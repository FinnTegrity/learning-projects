package com.trungtam.util;
import java.io.InputStream; import java.sql.*; import java.util.Properties;
// Ket noi DB (Singleton + doc vendor)
public class KetNoiDB {
    private static Connection ketNoi;
    private static class Holder{ static final KetNoiDB I=new KetNoiDB(); }
    private final String url,user,pass;
    private KetNoiDB(){
        try{
            Properties props=new Properties();
            try(InputStream in=KetNoiDB.class.getClassLoader().getResourceAsStream("config.properties")){ props.load(in); }
            String vendor=props.getProperty("db.vendor","mysql").trim();
            if("mssql".equalsIgnoreCase(vendor)){ Class.forName(props.getProperty("db.mssql.driver")); url=props.getProperty("db.mssql.url"); user=props.getProperty("db.mssql.user"); pass=props.getProperty("db.mssql.password"); }
            else { Class.forName(props.getProperty("db.mysql.driver")); url=props.getProperty("db.mysql.url"); user=props.getProperty("db.mysql.user"); pass=props.getProperty("db.mysql.password"); }
        }catch(Exception e){ throw new RuntimeException("Loi doc cau hinh DB: "+e.getMessage(), e); }
    }
    public static Connection layKetNoi(){
        try{ if(ketNoi==null||ketNoi.isClosed()){ KetNoiDB k=Holder.I; ketNoi=DriverManager.getConnection(k.url,k.user,k.pass); } return ketNoi; }
        catch(Exception e){ throw new RuntimeException("Khong ket noi duoc DB: "+e.getMessage(), e); }
    }
}
