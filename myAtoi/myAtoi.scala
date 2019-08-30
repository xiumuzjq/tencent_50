import util.control.Breaks._


object Solution {
    def checkNum(c: Char): Boolean = {
        c >= '0' && c <= '9'
    }

    // + - 或数字
    def checkAvi(c: Char): Boolean = {
        c == '+' || c == '-' || checkNum(c)
    }

    def myAtoi(str: String): Int = {
        
        val nums = new Array[Int](128)
                
        var i = 0
        var startMark = false
        var isPos = true
        var maxNum = Int.MaxValue
        var base = 0

        breakable {
            for (c <- str) {
                if (startMark) {
                    if (!checkNum(c)) {
                        break
                    } else {
                        nums(i) = c - '0'
                        i += 1
                    }
                } else if (c == '0') {
                    isPos = true
                    startMark = true
                } else if (c != ' '){
                    if (!checkAvi(c)) {
                        break
                    } else if (c == '-') {
                        isPos = false
                    } else if (c == '+' || c == ' ' || c == '0'){
                        isPos = true
                    } else {
                        isPos = true
                        nums(i) = c - '0'
                        i += 1
                    }
                    
                    startMark = true
                }
            }       
        }
        if (i == 0) {
            return 0
        }
        
        for (index <- 0 until i) {
            if (base > Int.MaxValue / 10 || (base == Int.MaxValue / 10 && ((isPos && nums(index) > 7) || (!isPos && nums(index) > 8)))) {
                return if (isPos) Int.MaxValue else Int.MinValue
            }

            base = base * 10 + nums(index)
        }
        
        return if (isPos) base else -base
    }
}

println(Solution.myAtoi("-91283472332"))
