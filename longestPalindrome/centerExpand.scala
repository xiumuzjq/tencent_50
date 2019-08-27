// 中心扩展法，O(n^2) O(n), leetcode 实测 604 毫秒
import scala.util.control.Breaks._


object Solution {
    
    def longestPalindrome(s: String): String = {
        val max_len = 1
        val len = s.length

        var cen_pos = 0 // 中心点位置
        var sub_len = 0 // 单侧偏移量

        var new_con = new Array[Char](2 * len + 1)
        var index = 0

        // 填充新数组
        for (c <- s) {
            new_con(index) = "^".charAt(0)
            index += 1
            new_con(index) = c
            index += 1
        }
        new_con(index) = "^".charAt(0)

        for (i <- 0 to (2 * len + 1 - 1)) {
            breakable {
                for (k <- 1 to len) {
                    if (i - k < 0 || i + k > (2 * len + 1 - 1)) {
                        break
                    }

                    if (new_con(i - k) != new_con(i + k)) {
                        break
                    }
                
                    if (k > sub_len) {
                        cen_pos = i
                        sub_len = k
                    }
                }
            }
        }

        // 获取结果
        index = 0
        //println(cen_pos, sub_len, new_con)

        val rst_arr = new Array[Char](1 + sub_len)
        for (i <- cen_pos - sub_len to cen_pos + sub_len) {
            //println(i)
            if (new_con(i) != "^".charAt(0)) {
                rst_arr(index) = new_con(i)
                index += 1
            }
        }
        
        return rst_arr.mkString("").trim()
    }
}

println(Solution.longestPalindrome("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"))

