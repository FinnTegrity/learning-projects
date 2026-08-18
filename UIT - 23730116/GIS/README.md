# UIT Academic Projects — README Collection

## 🇻🇳 Giới thiệu

Đây là thư mục tổng hợp các **bài tập lớn, đồ án môn học và project thực hành** trong quá trình học tại **Trường Đại học Công nghệ Thông tin – ĐHQG TP.HCM (UIT)**.  
Mỗi thư mục con tương ứng với một môn học và tập trung vào những kiến thức, kỹ năng và sản phẩm thực tế đã thực hành.

## 🇬🇧 About

This repository contains selected **course projects, major assignments, and practical projects** completed during my studies at the **University of Information Technology – Vietnam National University Ho Chi Minh City (UIT)**.  
Each subfolder represents a course and highlights the knowledge, practical skills, and deliverables developed through the project.

> **Note:** This file is intentionally written as a collection of smaller README sections. Each section can be copied into the `README.md` of its corresponding subject folder.

---

# 01. Bảo đảm và an ninh thông tin / Information Assurance & Security

## 🇻🇳 Mini Phishing Inspector

**Dự án:** Xây dựng công cụ Python hỗ trợ phát hiện email lừa đảo (phishing).

**Đã làm được**
- Phân tích các dấu hiệu phishing từ **link, header và attachment**.
- Xây dựng cả **CLI** và **GUI** để quét và tổng hợp kết quả.
- Phân loại chỉ báo, cảnh báo và xuất kết quả phục vụ kiểm tra.

**Học được**
- Tư duy phân tích một mối đe dọa theo chuỗi tấn công phishing.
- Kiểm tra URL, email header và chính sách attachment bằng Python.
- Thiết kế công cụ security nhỏ có thể sử dụng trực tiếp.

**Điểm nổi bật**
- Kết hợp kiến thức an toàn thông tin với lập trình ứng dụng thực tế.
- Chú trọng khả năng giải thích kết quả thay vì chỉ trả về một nhãn “an toàn/nguy hiểm”.

## 🇬🇧 Mini Phishing Inspector

**Project:** A Python-based tool for inspecting and identifying phishing emails.

**Built**
- Inspect **URLs, email headers, and attachments** for suspicious indicators.
- Implemented both **CLI and GUI** workflows.
- Organized findings into indicators, warnings, and scan results.

**Learned**
- Practical phishing-threat analysis and security thinking.
# GIS / Geographic Information Systems

## 🇻🇳 GIS 2D, 3D và WebGIS thời tiết

**Dự án:** Thực hành trực quan hóa dữ liệu địa lý 2D/3D và xây dựng hệ thống WebGIS hỗ trợ phân tích thời tiết tại TP.HCM.

**Đã làm được**
- Xây dựng bản đồ **GIS 2D** với point, polyline, polygon và popup thông tin.
- Xây dựng mô hình **Dinh Độc Lập 3D** để quan sát nhiều góc nhìn.
- Phát triển WebGIS thời tiết với frontend/backend và database không gian.
- Hiển thị dữ liệu theo không gian và thời gian, bản đồ nhiệt và lưới nội suy.
- Áp dụng **IDW interpolation** cho dữ liệu thời tiết.
- Tối ưu quá trình sinh lưới: báo cáo project ghi nhận khoảng **1.635 ô lưới**, thời gian xử lý giảm từ hơn 8.5 giây xuống dưới 100 ms.
- Sử dụng PostgreSQL/PostGIS cho dữ liệu không gian và time-series.

**Học được**
- Mô hình dữ liệu không gian: Point, Polygon, Raster/Interpolation và 2.5D/3D.
- Thiết kế ERD/DFD/Sequence cho ứng dụng GIS.
- Kết hợp GIS với web application, API và database spatial.
- Tư duy tối ưu thuật toán và hiệu năng trong xử lý dữ liệu không gian.

**Điểm nổi bật**
- Đây là project thể hiện rõ khả năng kết hợp **GIS + Software Engineering + Data + Visualization** thay vì chỉ làm bản đồ tĩnh.

## 🇬🇧 GIS

**Project:** 2D/3D GIS exercises and a WebGIS platform for weather visualization and analysis in Ho Chi Minh City.

**Built**
- 2D GIS maps using points, polylines, polygons and interactive popups.
- A **3D reconstruction of Independence Palace** with multiple viewpoints.
- A full WebGIS architecture with frontend, backend and spatial database.
- Spatiotemporal weather visualization, heatmaps and interpolation grids.
- **IDW interpolation** for weather data.
- Performance optimization for an interpolation grid of about **1,635 cells**, reducing reported processing time from over 8.5 seconds to under 100 ms.
- PostgreSQL/PostGIS for spatial and time-series data.

**Learned**
- Spatial data modeling and 2D/3D GIS concepts.
- ERD/DFD/Sequence design for GIS systems.
- Integrating GIS, APIs, web applications and spatial databases.
- Performance optimization for spatial computation.

**Portfolio value**
- Demonstrates the ability to combine **GIS, backend systems, data processing and visualization** into one product-oriented project.