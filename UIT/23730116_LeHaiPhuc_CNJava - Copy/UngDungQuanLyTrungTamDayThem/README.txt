UngDungQuanLyTrungTamDayThem
Quan ly trung tam day them – Java Swing + MySQL (MVC, DAO, JDBC, Maven)

Tac gia – UIT:
23730116_LeHaiPhuc
23730115_NguyenLeQuyPhat
23730064_NguyenThienTramAnh

1) Muc tieu
Ung dung desktop quan ly: hoc vien, giao vien, khoa hoc, lop hoc, dang ky, thu hoc phi, diem danh, bao cao.
Ap dung OOP, DAO pattern, JDBC ket noi MySQL, kien truc MVC, dong goi JAR.

2) Tinh nang chinh
- Xac thuc & phan quyen: Admin/Staff (bang taikhoan).
- Quan ly: HocVien, GiaoVien, KhoaHoc, LopHoc, PhongHoc, CaHoc.
- Nghiep vu: Dang ky lop, thu hoc phi (hoa don), diem danh, lich hoc.
- Tra cuu & loc: tim kiem theo ten/SDT/ma.
- Bao cao: doanh thu thang/quy.
- Giao dien: Java Swing, form dang nhap, dashboard, menu, dialog CRUD.
- Dong goi: mvn package tao fat JAR: UngDungQuanLyTrungTamDayThem-1.0.0-jar-with-dependencies.jar.

3) Cong nghe
- JDK 17+ (khuyen nghi 21 LTS), Maven 3.9+, MySQL 8.0+
- JDBC: MySQL Connector/J 8.3+
- OS: Windows/Linux/macOS

4) Cai dat truoc (Prerequisites)
- Cai JDK 17+ va Maven 3.9+, them PATH (java -version, mvn -version).
- Cai MySQL Server 8.0+ va (tuy chon) Workbench.
- Import schema + seed:
  mysql -u root -p < database/mysql_schema.sql
  mysql -u root -p trungtamdaythem < database/mysql_seed.sql
- Cau hinh config/db.properties:
  db.host=localhost
  db.port=3306
  db.name=trungtamdaythem
  db.user=root
  db.password=YOUR_PASSWORD
  db.params=?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false

5) Cach chay
- IDE: Mo project Maven, sua config/db.properties, run ui.App.
- Dong goi:
  mvn clean package -DskipTests
  Windows: java -jar target\UngDungQuanLyTrungTamDayThem-1.0.0-jar-with-dependencies.jar
  Linux/macOS: java -jar target/UngDungQuanLyTrungTamDayThem-1.0.0-jar-with-dependencies.jar

6) Tai khoan demo
- Xem database/mysql_seed.sql (vi du: admin/admin, staff/staff).

7) Cau truc thu muc
UngDungQuanLyTrungTamDayThem/
├─ src/
│  └─ main/
│     ├─ java/
│     │  └─ com/
│     │     └─ trungtam/
│     │        ├─ app/
│     │        │  └─ UngDung.java
│     │        ├─ dao/
│     │        │  ├─ impl/
│     │        │  │  ├─ DangKyDaoImpl.java
│     │        │  │  ├─ GiaoVienDaoImpl.java
│     │        │  │  ├─ HocVienDaoImpl.java
│     │        │  │  ├─ LopHocDaoImpl.java
│     │        │  │  ├─ MonHocDaoImpl.java
│     │        │  │  ├─ TaiKhoanDaoImpl.java
│     │        │  │  └─ ThanhToanDaoImpl.java
│     │        │  ├─ DangKyDao.java
│     │        │  ├─ GiaoVienDao.java
│     │        │  ├─ HocVienDao.java
│     │        │  ├─ LopHocDao.java
│     │        │  ├─ MonHocDao.java
│     │        │  ├─ TaiKhoanDao.java
│     │        │  └─ ThanhToanDao.java
│     │        ├─ model/
│     │        │  ├─ DangKy.java
│     │        │  ├─ GiaoVien.java
│     │        │  ├─ HocVien.java
│     │        │  ├─ LopHoc.java
│     │        │  ├─ MonHoc.java
│     │        │  ├─ TaiKhoan.java
│     │        │  ├─ ThanhToan.java
│     │        │  └─ VaiTro.java
│     │        ├─ patterns/
│     │        │  ├─ observer/
│     │        │  │  ├─ KenhSuKien.java
│     │        │  │  └─ SuKienLangNghe.java
│     │        │  └─ strategy/
│     │        │     ├─ ChienLuocHocPhi.java
│     │        │     ├─ GiamAnhEm.java
│     │        │     ├─ GiamCombo.java
│     │        │     └─ KhongGiamGia.java
│     │        ├─ service/
│     │        │  ├─ DangKyService.java
│     │        │  ├─ GiaoVienService.java
│     │        │  ├─ HocVienService.java
│     │        │  ├─ LopHocService.java
│     │        │  ├─ MonHocService.java
│     │        │  ├─ TaiKhoanService.java
│     │        │  └─ ThanhToanService.java
│     │        ├─ ui/
│     │        │  ├─ panels/
│     │        │  │  ├─ baocao/
│     │        │  │  │  └─ BaoCaoPanel.java
│     │        │  │  ├─ dangky/
│     │        │  │  │  └─ DangKyPanel.java
│     │        │  │  ├─ giaovien/
│     │        │  │  │  └─ GiaoVienPanel.java
│     │        │  │  ├─ hocvien/
│     │        │  │  │  └─ HocVienPanel.java
│     │        │  │  ├─ lophoc/
│     │        │  │  │  └─ LopHocPanel.java
│     │        │  │  ├─ monhoc/
│     │        │  │  │  └─ MonHocPanel.java
│     │        │  │  ├─ thanhtoan/
│     │        │  │  │  └─ ThanhToanPanel.java
│     │        │  │  └─ ManHinhChinh.java
│     │        │  └─ DangNhapForm.java
│     │        └─ util/
│     │           ├─ KetNoiDB.java
│     │           ├─ MaHoa.java
│     │           ├─ XuatCSV.java
│     │           └─ XuatPDF.java
│     └─ resources/
│        └─ config.properties
├─ target/
│  ├─ archive-tmp/
│  ├─ classes/
│  │  ├─ com/
│  │  │  └─ trungtam/
│  │  │     ├─ app/
│  │  │     │  └─ UngDung.class
│  │  │     ├─ dao/
│  │  │     │  ├─ impl/
│  │  │     │  │  ├─ DangKyDaoImpl.class
│  │  │     │  │  ├─ GiaoVienDaoImpl.class
│  │  │     │  │  ├─ HocVienDaoImpl.class
│  │  │     │  │  ├─ LopHocDaoImpl.class
│  │  │     │  │  ├─ MonHocDaoImpl.class
│  │  │     │  │  ├─ TaiKhoanDaoImpl.class
│  │  │     │  │  └─ ThanhToanDaoImpl.class
│  │  │     │  ├─ DangKyDao.class
│  │  │     │  ├─ GiaoVienDao.class
│  │  │     │  ├─ HocVienDao.class
│  │  │     │  ├─ LopHocDao.class
│  │  │     │  ├─ MonHocDao.class
│  │  │     │  ├─ TaiKhoanDao.class
│  │  │     │  └─ ThanhToanDao.class
│  │  │     ├─ model/
│  │  │     │  ├─ DangKy.class
│  │  │     │  ├─ GiaoVien.class
│  │  │     │  ├─ HocVien.class
│  │  │     │  ├─ LopHoc.class
│  │  │     │  ├─ MonHoc.class
│  │  │     │  ├─ TaiKhoan.class
│  │  │     │  ├─ ThanhToan.class
│  │  │     │  └─ VaiTro.class
│  │  │     ├─ patterns/
│  │  │     │  ├─ observer/
│  │  │     │  │  ├─ KenhSuKien.class
│  │  │     │  │  └─ SuKienLangNghe.class
│  │  │     │  └─ strategy/
│  │  │     │     ├─ ChienLuocHocPhi.class
│  │  │     │     ├─ GiamAnhEm.class
│  │  │     │     ├─ GiamCombo.class
│  │  │     │     └─ KhongGiamGia.class
│  │  │     ├─ service/
│  │  │     │  ├─ DangKyService.class
│  │  │     │  ├─ GiaoVienService.class
│  │  │     │  ├─ HocVienService.class
│  │  │     │  ├─ LopHocService.class
│  │  │     │  ├─ MonHocService.class
│  │  │     │  ├─ TaiKhoanService.class
│  │  │     │  └─ ThanhToanService.class
│  │  │     ├─ ui/
│  │  │     │  ├─ panels/
│  │  │     │  │  ├─ baocao/
│  │  │     │  │  │  ├─ BaoCaoPanel$1.class
│  │  │     │  │  │  └─ BaoCaoPanel.class
│  │  │     │  │  ├─ dangky/
│  │  │     │  │  │  ├─ DangKyPanel$1.class
│  │  │     │  │  │  └─ DangKyPanel.class
│  │  │     │  │  ├─ giaovien/
│  │  │     │  │  │  ├─ GiaoVienPanel$1.class
│  │  │     │  │  │  ├─ GiaoVienPanel$2.class
│  │  │     │  │  │  └─ GiaoVienPanel.class
│  │  │     │  │  ├─ hocvien/
│  │  │     │  │  │  ├─ HocVienPanel$1.class
│  │  │     │  │  │  ├─ HocVienPanel$2.class
│  │  │     │  │  │  ├─ HocVienPanel$3.class
│  │  │     │  │  │  ├─ HocVienPanel$4.class
│  │  │     │  │  │  └─ HocVienPanel.class
│  │  │     │  │  ├─ lophoc/
│  │  │     │  │  │  ├─ LopHocPanel$1.class
│  │  │     │  │  │  ├─ LopHocPanel$2.class
│  │  │     │  │  │  ├─ LopHocPanel$3.class
│  │  │     │  │  │  └─ LopHocPanel.class
│  │  │     │  │  ├─ monhoc/
│  │  │     │  │  │  ├─ MonHocPanel$1.class
│  │  │     │  │  │  ├─ MonHocPanel$2.class
│  │  │     │  │  │  ├─ MonHocPanel$3.class
│  │  │     │  │  │  ├─ MonHocPanel$4.class
│  │  │     │  │  │  └─ MonHocPanel.class
│  │  │     │  │  ├─ thanhtoan/
│  │  │     │  │  │  ├─ ThanhToanPanel$1.class
│  │  │     │  │  │  └─ ThanhToanPanel.class
│  │  │     │  │  └─ ManHinhChinh.class
│  │  │     │  └─ DangNhapForm.class
│  │  │     └─ util/
│  │  │        ├─ KetNoiDB$Holder.class
│  │  │        ├─ KetNoiDB.class
│  │  │        ├─ MaHoa.class
│  │  │        ├─ XuatCSV.class
│  │  │        └─ XuatPDF.class
│  │  └─ config.properties
│  ├─ generated-sources/
│  │  └─ annotations/
│  ├─ maven-archiver/
│  │  └─ pom.properties
│  ├─ maven-status/
│  │  └─ maven-compiler-plugin/
│  │     └─ compile/
│  │        └─ default-compile/
│  │           ├─ createdFiles.lst
│  │           └─ inputFiles.lst
│  └─ UngDungQuanLyTrungTamDayThem-1.0.0-jar-with-dependencies.jar
├─ mysql_schema.sql
├─ pom.xml
└─ UngDungQuanLyTrungTamDayThem-1.0.0-jar-with-dependencies.jar



