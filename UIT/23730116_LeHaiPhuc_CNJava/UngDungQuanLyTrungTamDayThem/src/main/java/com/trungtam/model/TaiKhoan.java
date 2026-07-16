package com.trungtam.model;
public class TaiKhoan { private Integer id; private String tendangnhap; private String matkhauHash; private String hovaten; private Integer vaitroId;
public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
public String getTendangnhap(){return tendangnhap;} public void setTendangnhap(String tendangnhap){this.tendangnhap=tendangnhap;}
public String getMatkhauHash(){return matkhauHash;} public void setMatkhauHash(String matkhauHash){this.matkhauHash=matkhauHash;}
public String getHovaten(){return hovaten;} public void setHovaten(String hovaten){this.hovaten=hovaten;}
public Integer getVaitroId(){return vaitroId;} public void setVaitroId(Integer vaitroId){this.vaitroId=vaitroId;} }