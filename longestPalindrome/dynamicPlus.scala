// 动态规划优化版，O(n^2) O(n), leetcode 实测 3800 毫秒
import scala.collection.mutable.Map

object Solution {
    
    def longestPalindrome(s: String): String = {
        var last_c = Map((0, 0) -> true)
        var c = Map((0, 0) -> true)

        val len = s.length

        var max_len = 1
        var pos = (0, 0)
        var check = false
       
        //for (i <- 0 to (len - 1)) {
        //    c.put((i, i), true)
        //}
 
        for (i <- 0 to (len - 1)) {
            
            
            for (j <- 0 to i) {
                check = false
                
                if (j == i) {
                    check = true     
                }
                else if (j == i - 1) {
                    check = s(i) == s(j)
                } 
                else {
                    check = (s(i) == s(j) && last_c.getOrElse((j + 1, i - 1), false))
                }
                
                c.put((j, i), check)
                
                if (check && i - j + 1 > max_len) {
                    max_len = i - j + 1
                    pos = (j, i)
                }
            }

            last_c = c
            c = Map((0, 0) -> true)
        
        }
        
    
        return s.slice(pos._1, pos._2 + 1)
    }
}

//val test = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
val test = "babad"
println(Solution.longestPalindrome(test))
