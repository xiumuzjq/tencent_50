// 普通动态规划，O(n^2) O(n^2), leetcode 实测栈溢出
import scala.collection.mutable.Map

object Solution {
    
    def longestPalindrome(s: String): String = {
        val c = Map((0, 0) -> true)
        val len = s.length

        var max_len = 1
        var pos = (0, 0)
        var check = false
       
        for (i <- 0 to (len - 1)) {
            c.put((i, i), true)
        }
 
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
                    check = (s(i) == s(j) && c.getOrElse((j + 1, i - 1), false))
                }
                
                c.put((j, i), check)
                
                if (check && i - j + 1 > max_len) {
                    max_len = i - j + 1
                    pos = (j, i)
                }
            }
        
        }
        
    
        return s.slice(pos._1, pos._2 + 1)
    }
}

val test = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
//val test = "ddddd"
println(Solution.longestPalindrome(test))
