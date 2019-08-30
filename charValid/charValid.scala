object Solution {
    // 检查字符是左侧符号还是右侧符号
    def checkType(c: Char): Boolean = {
        c == '(' || c == '[' || c == '{'        
    }

    def isMatch(fst: Char, sec: Char): Boolean = {
        (fst == '(' && sec == ')') || (fst == '[' && sec == ']') || (fst == '{' && sec == '}')
    }

    def isValid(s: String): Boolean = {
        val c = new Array[Char](s.length)
        var heapLen = 0

        for (index <- 0 until s.length) {
            if (checkType(s(index))) {
                heapLen += 1
                c(heapLen - 1) = s(index)
            } else {
                if (heapLen > 0 && isMatch(c(heapLen - 1), s(index))) {
                    heapLen -= 1
                } else {
                    return false
                }
            } 
        }
        
        heapLen <= 0
    }
}

println(Solution.isValid("]"))

