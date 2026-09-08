package com.example.baitapkotlin

// 1. Lớp dữ liệu Sinh viên
data class SinhVien(
    val maSV: String,
    var hoTen: String,
    var tuoi: Int,
    var nganhHoc: String,
    var gpa: Double
) {
    fun hienThiThongTin() {
        println("Mã SV: %-8s | Họ tên: %-20s | Tuổi: %-3d | Ngành: %-22s | GPA: %3.2f"
            .format(maSV, hoTen, tuoi, nganhHoc, gpa))
    }
}


val danhSachSinhVien = mutableListOf(
    SinhVien("SV001", "Nguyễn Phú Lộc", 21, "Công nghệ thông tin", 8.8),
    SinhVien("SV002", "Trần Thị Mai", 20, "Quản trị kinh doanh", 7.5),
    SinhVien("SV003", "Lê Văn Nam", 22, "Công nghệ thông tin", 4.8),
    SinhVien("SV004", "Phạm Hoàng Anh", 19, "Công nghệ thông tin", 9.2),
    SinhVien("SV005", "Vũ Minh Tuấn", 23, "Kế toán", 6.2)
)



fun themSinhVien() {
    println("\n--- 1. THÊM SINH VIÊN MỚI ---")
    print("Nhập mã sinh viên: ")
    val maSV = readln().trim()
    if (danhSachSinhVien.any { it.maSV.equalsIgnoreCase(maSV) }) {
        println("Lỗi: Mã sinh viên '$maSV' đã tồn tại!")
        return
    }
    print("Nhập họ và tên: ")
    val hoTen = readln().trim()
    print("Nhập tuổi: ")
    val tuoi = readln().toIntOrNull() ?: 20
    print("Nhập ngành học: ")
    val nganhHoc = readln().trim()
    print("Nhập điểm GPA (0.0 - 10.0): ")
    val gpa = readln().toDoubleOrNull() ?: 0.0

    danhSachSinhVien.add(SinhVien(maSV, hoTen, tuoi, nganhHoc, gpa))
    println("Thêm sinh viên thành công!")
}

fun menuHienThi() {
    println("\n--- 2. HIỂN THỊ VÀ BÁO CÁO THỐNG KÊ ---")
    println("a. Hiển thị danh sách mặc định")
    println("b. Đếm số sinh viên (GPA >= 8.0 và GPA < 5.0)")
    println("c. Sắp xếp sinh viên theo GPA giảm dần")
    println("d. Hiển thị 3 sinh viên có GPA cao nhất")
    println("e. Sắp xếp sinh viên theo tuổi")
    println("f. Sắp xếp sinh viên theo tên")
    print("Chọn tùy chọn (a-f): ")

    when (readln().trim().lowercase()) {
        "a" -> {
            println("\n--- Danh sách sinh viên (${danhSachSinhVien.size}) ---")
            danhSachSinhVien.forEach { it.hienThiThongTin() }
        }
        "b" -> {
            val gpaCao = danhSachSinhVien.count { it.gpa >= 8.0 }
            val gpaThap = danhSachSinhVien.count { it.gpa < 5.0 }
            println("\n- Số sinh viên có GPA >= 8.0: $gpaCao")
            println("- Số sinh viên có GPA < 5.0: $gpaThap")
        }
        "c" -> {
            println("\n--- Danh sách sắp xếp theo GPA giảm dần ---")
            danhSachSinhVien.sortedByDescending { it.gpa }.forEach { it.hienThiThongTin() }
        }
        "d" -> {
            println("\n--- Top 3 sinh viên có GPA cao nhất ---")
            danhSachSinhVien.sortedByDescending { it.gpa }.take(3).forEach { it.hienThiThongTin() }
        }
        "e" -> {
            println("\n--- Danh sách sắp xếp theo tuổi ---")
            danhSachSinhVien.sortedBy { it.tuoi }.forEach { it.hienThiThongTin() }
        }
        "f" -> {
            println("\n--- Danh sách sắp xếp theo tên ---")
            danhSachSinhVien.sortedBy { it.hoTen }.forEach { it.hienThiThongTin() }
        }
        else -> println("Tùy chọn không hợp lệ!")
    }
}

fun menuTimKiem() {
    println("\n--- 3. TÌM KIẾM SINH VIÊN ---")
    println("a. Tìm theo một phần tên")
    println("b. Tìm theo ngành học")
    println("c. Tìm sinh viên có GPA trong khoảng 7.0 -> 8.5")
    println("d. Tìm sinh viên lớn tuổi nhất")
    print("Chọn tùy chọn (a-d): ")

    when (readln().trim().lowercase()) {
        "a" -> {
            print("Nhập tên cần tìm: ")
            val tuKhoa = readln().trim().lowercase()
            val ketQua = danhSachSinhVien.filter { it.hoTen.lowercase().contains(tuKhoa) }
            if (ketQua.isEmpty()) println("Không tìm thấy sinh viên nào chứa tên '$tuKhoa'")
            else ketQua.forEach { it.hienThiThongTin() }
        }
        "b" -> {
            print("Nhập tên ngành học: ")
            val nganh = readln().trim().lowercase()
            val ketQua = danhSachSinhVien.filter { it.nganhHoc.lowercase().contains(nganh) }
            if (ketQua.isEmpty()) println("Không tìm thấy sinh viên nào thuộc ngành '$nganh'")
            else ketQua.forEach { it.hienThiThongTin() }
        }
        "c" -> {
            println("\n--- Sinh viên có GPA từ 7.0 đến 8.5 ---")
            val ketQua = danhSachSinhVien.filter { it.gpa in 7.0..8.5 }
            if (ketQua.isEmpty()) println("Không có sinh viên nào nằm trong khoảng điểm 7.0 - 8.5")
            else ketQua.forEach { it.hienThiThongTin() }
        }
        "d" -> {
            val lonTuoiNhat = danhSachSinhVien.maxByOrNull { it.tuoi }
            if (lonTuoiNhat != null) {
                println("\n--- Sinh viên lớn tuổi nhất ---")
                lonTuoiNhat.hienThiThongTin()
            }
        }
        else -> println("Tùy chọn không hợp lệ!")
    }
}

fun tinhGpaTrungBinh() {
    println("\n--- 4. TÍNH ĐIỂM GPA TRUNG BÌNH ---")
    if (danhSachSinhVien.isEmpty()) {
        println("Danh sách trống!")
        return
    }

    val gpaTBChung = danhSachSinhVien.map { it.gpa }.average()
    println("Điểm GPA trung bình của tất cả sinh viên: %.2f".format(gpaTBChung))

    print("Nhập tên ngành để tính GPA trung bình (Bỏ trống nếu muốn bỏ qua): ")
    val nganhNhap = readln().trim()
    if (nganhNhap.isNotEmpty()) {
        val danhSachNganh = danhSachSinhVien.filter { it.nganhHoc.equalsIgnoreCase(nganhNhap) }
        if (danhSachNganh.isNotEmpty()) {
            val gpaTBNganh = danhSachNganh.map { it.gpa }.average()
            println("Điểm GPA trung bình của ngành '$nganhNhap': %.2f".format(gpaTBNganh))
        } else {
            println("Không tìm thấy sinh viên nào thuộc ngành '$nganhNhap'")
        }
    }
}

fun timGpaCaoNhat() {
    println("\n--- 5. TÌM SINH VIÊN CÓ GPA CAO NHẤT ---")
    val svCaoNhat = danhSachSinhVien.maxByOrNull { it.gpa }
    if (svCaoNhat != null) {
        svCaoNhat.hienThiThongTin()
    } else {
        println("Danh sách trống!")
    }
}

fun xoaSinhVien() {
    println("\n--- 6. XÓA SINH VIÊN ---")
    print("Nhập mã sinh viên cần xóa: ")
    val maSV = readln().trim()
    val sv = danhSachSinhVien.find { it.maSV.equalsIgnoreCase(maSV) }
    if (sv == null) {
        println("Không tìm thấy sinh viên có mã '$maSV'!")
    } else {
        danhSachSinhVien.remove(sv)
        println("Đã xóa thành công sinh viên '${sv.hoTen}'!")
    }
}

// --- HÀM MAIN CHÍNH ---
fun main() {
    while (true) {
        println("\n========== QUẢN LÝ SINH VIÊN ==========")
        println("1. Thêm sinh viên")
        println("2. Hiển thị danh sách sinh viên")
        println("3. Tìm kiếm sinh viên")
        println("4. Tính điểm GPA trung bình")
        println("5. Tìm sinh viên có GPA cao nhất")
        println("6. Xóa sinh viên")
        println("0. Thoát")
        println("========================================")
        print("Chọn chức năng (0-6): ")

        when (readln().trim()) {
            "1" -> themSinhVien()
            "2" -> menuHienThi()
            "3" -> menuTimKiem()
            "4" -> tinhGpaTrungBinh()
            "5" -> timGpaCaoNhat()
            "6" -> xoaSinhVien()
            "0" -> {
                println("Đã thoát chương trình. Tạm biệt!")
                break
            }
            else -> println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 6.")
        }
    }
}

fun String.equalsIgnoreCase(other: String): Boolean = this.equals(other, ignoreCase = true)