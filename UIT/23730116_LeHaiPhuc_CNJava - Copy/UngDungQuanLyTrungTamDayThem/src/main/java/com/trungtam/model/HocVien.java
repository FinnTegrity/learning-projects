package com.trungtam.model; import java.time.LocalDate;
public class HocVien { private Integer id; private String ma; private String hovaten; private String sdt; private String email; private String diachi; private LocalDate ngaysinh;
public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
public String getMa(){return ma;} public void setMa(String ma){this.ma=ma;}
public String getHovaten(){return hovaten;} public void setHovaten(String hovaten){this.hovaten=hovaten;}
public String getSdt(){return sdt;} public void setSdt(String sdt){this.sdt=sdt;}
public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
public String getDiachi(){return diachi;} public void setDiachi(String diachi){this.diachi=diachi;}
public LocalDate getNgaysinh(){return ngaysinh;} public void setNgaysinh(LocalDate ngaysinh){this.ngaysinh=ngaysinh;} }