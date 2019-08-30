object Solution {
    def reverseWords(s: String): String = {
        val len = s.length + 1
        val ns = (s + " ").toCharArray()
        var o_left = -1
        var o_right = - 1
        
        var i_left = 0
        var i_right = 0
        var tmp = ' '

        for (i <- 0 until len) {
            if (ns(i) == ' ') {
                o_left = o_right
                o_right = i

                i_left = o_left + 1
                i_right = o_right - 1
                while (i_left < i_right) {
                    tmp = ns(i_right)                    
                    ns(i_right) = ns(i_left)
                    ns(i_left) = tmp
    
                    i_left += 1
                    i_right -= 1
                }
            }
        }       
        
        ns.mkString("").trim()
    }
}

println(Solution.reverseWords("Let's take LeetCode contest"))
