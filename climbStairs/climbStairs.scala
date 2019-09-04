object Solution {
    def climbStairs(n: Int): Int = {
        val arr = new Array[Int](n+1)
        
        if (n < 3) {
            return n    
        }
        
        arr(1) = 1
        arr(2) = 2
        
        for (i <- 3 to n) {
            arr(i) = arr(i-2) + arr(i-1) 
        }
        
        //println(arr.mkString(","))
        arr(n)
    }
}
