data class Student(
    val id: String,
    val name: String,
    val math: Double,
    val programming: Double,
    val database: Double
) {
   
    fun getTotalScore(): Double {
        return math + programming + database
    }

   
    fun getGpa(): Double {
        return getTotalScore() / 3.0
    }

  
    fun getMaxScore(): Double {
        return maxOf(math, programming, database)
    }

    fun isPassed(): Boolean {
        return getGpa() >= 5.0
    }

  
    fun printReport() {
        println("----------------------------------------")
        println("THÔNG TIN SINH VIÊN")
        println("Mã SV: $id | Họ tên: $name")
        println("Điểm chi tiết -> Toán: $math | Lập trình: $programming | Cơ sở dữ liệu: $database")
        println("----------------------------------------")
        println("1. Tổng điểm       : ${String.format("%.2f", getTotalScore())}")
        println("2. Điểm trung bình : ${String.format("%.2f", getGpa())}")
        println("3. Điểm cao nhất   : ${getMaxScore()}")
        println("4. Kết quả         : ${if (isPassed()) "ĐẠT (PASSED)" else "KHÔNG ĐẠT (FAILED)"}")
        println("----------------------------------------\n")
    }
}

fun main() {
  
    val student = Student(
        id = "SV001",
        name = "Nguyễn Văn Lộc",
        math = 7.5,
        programming = 8.0,
        database = 4.5
    )

  
    student.printReport()
}