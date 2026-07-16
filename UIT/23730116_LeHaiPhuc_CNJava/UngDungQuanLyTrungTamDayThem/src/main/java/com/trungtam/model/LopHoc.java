package com.trungtam.model; import java.time.LocalDate;
public class LopHoc { private Integer id; private Integer monhocId; private Integer giaovienId; private String phong; private String lich; private LocalDate ngaybatdau; private LocalDate ngayketthuc;
public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
public Integer getMonhocId(){return monhocId;} public void setMonhocId(Integer monhocId){this.monhocId=monhocId;}
public Integer getGiaovienId(){return giaovienId;} public void setGiaovienId(Integer giaovienId){this.giaovienId=giaovienId;}
public String getPhong(){return phong;} public void setPhong(String phong){this.phong=phong;}
public String getLich(){return lich;} public void setLich(String lich){this.lich=lich;}
public LocalDate getNgaybatdau(){return ngaybatdau;} public void setNgaybatdau(LocalDate ngaybatdau){this.ngaybatdau=ngaybatdau;}
public LocalDate getNgayketthuc(){return ngayketthuc;} public void setNgayketthuc(LocalDate ngayketthuc){this.ngayketthuc=ngayketthuc;} }