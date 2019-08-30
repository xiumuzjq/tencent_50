import util.control.Breaks._


object Solution {
    def multiply(num1: String, num2: String): String = {
        val len1 = num1.length
        val len2 = num2.length
        val lenRst = len1 + len2

        var rst = Array.fill[Int](lenRst)(0)
        var next = 0  // 进位标志
        var tmp = 0
        var d1 = 0
        var d2 = 0

        // 模拟多位数乘以多位数规则
        for (i <- 0 until len1) {
            d1 = num1(len1 - 1 - i) - '0'

            for (j <- 0 until len2) {
                d2 = num2(len2 - 1 - j) - '0'
                rst(lenRst - 1 - i - j) = d1 * d2 + rst(lenRst - 1 - i - j)
            }
            
        }       

        // 格式化 rst
        for (index <- lenRst - 1 to 0 by -1) {
            tmp = (rst(index) + next) % 10 
            next = (rst(index) + next) / 10
            rst(index) = tmp
        }
       
        val newRst = rst.map(x => (x + '0').toChar)
        var actPos = 0

        breakable {
            for (pos <- 0 until lenRst) {
                if (newRst(pos) == '0') {
                    actPos += 1
                } else {
                    break
                }
            }
        }

        if (actPos == lenRst) {
            return "0"
        }
        newRst.mkString("").slice(actPos, lenRst)
    }
}

println(Solution.multiply("0", "456"))
