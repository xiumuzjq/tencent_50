object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        val output = new Array[Int](nums.length) 
        var tmp = 1

        output(0) = 1
        for (i <- 1 until nums.length) {
            output(i) = output(i - 1) * nums(i - 1)
        }       

        for (i <- nums.length - 1 to 0 by -1) {
            output(i) *= tmp
            tmp *= nums(i)
        
        }

        return output
    }
}

println(Solution.productExceptSelf(Array(1, 2, 3, 4)).mkString(","))
