object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
        var maxSum = Int.MinValue
        var curSum = 0

        for (num <- nums) {
            if (curSum < 0) {
                curSum = 0
            }
                
            curSum += num

            if (curSum > maxSum) {
                maxSum = curSum
            }
        }       

        maxSum
    }
}

println(Solution.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))
