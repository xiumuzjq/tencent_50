object Solution {
    def reverseString(s: Array[Char]): Unit = {
        val len = s.length

        var left = 0
        var right = len - 1
        var tmp = ' '

        while (left < right ) {
            tmp = s(left)
            s(left) = s(right)
            s(right) = tmp
            
            left += 1
            right -= 1            
        }       
    }
}
