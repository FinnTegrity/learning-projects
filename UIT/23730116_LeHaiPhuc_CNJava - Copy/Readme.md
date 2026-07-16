# Tutoring Center Management System
# Ứng Dụng Quản Lý Trung Tâm Dạy Thêm

A desktop application for managing a tutoring center, developed using **Java Swing**, **MySQL**, **JDBC**, and **Maven**.

Ứng dụng quản lý trung tâm dạy thêm được phát triển bằng **Java Swing**, **MySQL**, **JDBC** và **Maven**.

---

## Team Members | Thành viên

| Student ID | Full Name |
|------------|-----------|
| 23730116 | Le Hai Phuc |
| 23730115 | Nguyen Le Quy Phat |
| 23730064 | Nguyen Thien Tram Anh |

---

## Introduction | Giới thiệu

### English

This application helps manage the daily operations of a tutoring center, including student management, teacher management, course management, class scheduling, enrollment, tuition payment, and statistical reporting.

### Tiếng Việt

Phần mềm hỗ trợ quản lý toàn bộ hoạt động của trung tâm dạy thêm như quản lý học viên, giáo viên, môn học, lớp học, đăng ký học, thanh toán học phí và thống kê doanh thu.

---

## Technologies | Công nghệ sử dụng

- Java 17
- Java Swing
- Maven
- JDBC
- MySQL
- FlatLaf
- JFreeChart
- Apache PDFBox

---

## Architecture | Kiến trúc

The project is designed using:

Dự án được xây dựng theo các mô hình:

- MVC (Model - View - Controller)
- DAO Pattern
- Service Layer
- Observer Pattern
- Strategy Pattern

---

## Project Structure | Cấu trúc dự án

```
TutoringCenterManagement
│
├── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   │   └── ...
│
├── mysql_schema.sql
├── pom.xml
└── README.md
```

---

## Features | Chức năng

### Student Management | Quản lý học viên

- Add, edit, delete students
- Search students

- Thêm, sửa, xóa học viên
- Tìm kiếm học viên

---

### Teacher Management | Quản lý giáo viên

- Add, edit, delete teachers
- Search teachers

- Thêm, sửa, xóa giáo viên
- Tìm kiếm giáo viên

---

### Course Management | Quản lý môn học

- Add, edit, delete courses

- Thêm, sửa, xóa môn học

---

### Class Management | Quản lý lớp học

- Create classes
- Assign teachers
- Manage class capacity

- Tạo lớp học
- Phân công giáo viên
- Quản lý sĩ số

---

### Enrollment | Đăng ký học

- Register students
- Prevent duplicate enrollment

- Đăng ký học viên
- Kiểm tra đăng ký trùng

---

### Tuition Payment | Thanh toán học phí

- Collect tuition fees
- Apply discount strategies
- Store payment history

- Thu học phí
- Áp dụng chính sách giảm giá
- Lưu lịch sử thanh toán

---

### Reports | Báo cáo

- Revenue reports
- Statistics
- Export PDF
- Export CSV
- Revenue charts

- Báo cáo doanh thu
- Thống kê
- Xuất PDF
- Xuất CSV
- Biểu đồ doanh thu

---

## Installation | Cài đặt

### 1. Clone the repository

```bash
git clone <repository-url>
```

---

### 2. Create the database | Tạo cơ sở dữ liệu

Import:

```
mysql_schema.sql
```

Configure database connection in:

```
src/main/resources/config.properties
```

Example:

```properties
db.url=jdbc:mysql://localhost:3306/tutoring_center
db.username=root
db.password=your_password
```

---

### 3. Build the project

```bash
mvn clean package
```

---

### 4. Run the application | Chạy chương trình

Run the main class:

```
com.trungtam.app.UngDung
```

Or execute:

```bash
java -jar target/TutoringCenterManagement.jar
```

---

## Maven Dependencies

- MySQL Connector/J
- FlatLaf
- JFreeChart
- Apache PDFBox
- SLF4J

---

## Design Patterns

### MVC

Separates the Model, View, and Controller to improve maintainability.

Tách biệt Model, View và Controller giúp dễ bảo trì.

### DAO Pattern

Encapsulates all database access operations.

Đóng gói toàn bộ thao tác truy cập cơ sở dữ liệu.

### Strategy Pattern

Supports different tuition discount policies.

Hỗ trợ nhiều chính sách giảm học phí khác nhau.

### Observer Pattern

Automatically updates the user interface when data changes.

Tự động cập nhật giao diện khi dữ liệu thay đổi.

---

## Screenshots | Hình ảnh giao diện

Place screenshots in:

```
docs/images/login.png
docs/images/dashboard.png
docs/images/student-management.png
docs/images/payment.png
```

---

## System Requirements | Yêu cầu hệ thống

- Java 17 or later
- Maven 3.9 or later
- MySQL 8.0 or later

---

## License | Giấy phép

This project is developed for educational purposes only.

Dự án được phát triển phục vụ mục đích học tập.

---

## Acknowledgements | Lời cảm ơn

Special thanks to our instructor and all team members for their support throughout the project.

Xin chân thành cảm ơn giảng viên hướng dẫn và các thành viên trong nhóm đã hỗ trợ hoàn thành dự án.