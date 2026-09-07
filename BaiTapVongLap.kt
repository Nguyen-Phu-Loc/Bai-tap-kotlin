fun main() {
    println("================ BÀI 1: IN CÁC SỐ TỪ 1 ĐẾN 10 ================")
    // Bài 1 - Cách 1: Dùng for
    print("Dùng for  : ")
    for (i in 1..10) {
        print("$i ")
    }
    println()

   
    print("Dùng while: ")
    var count1 = 1
    while (count1 <= 10) {
        print("$count1 ")
        count1++
    }
    println("\n")


    println("================ BÀI 2: TÍNH TỔNG TỪ 1 ĐẾN 100 ================")
    // Bài 2 - Cách 1: Dùng for
    var sumFor = 0
    for (i in 1..100) {
        sumFor += i
    }
    println("Dùng for  -> Tổng 1..100 = $sumFor")

    

    println("============== BÀI 3: IN SỐ CHẴN TỪ 1 ĐẾN 20 ==============")
    

    // Bài 3 - Cách 2: Dùng while (bước nhảy +2)
    print("Dùng while: ")
    var count3 = 2
    while (count3 <= 20) {
        print("$count3 ")
        count3 += 2
    }
    println()
}