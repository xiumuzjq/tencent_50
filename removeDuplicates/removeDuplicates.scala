object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        val len = nums.length
        var p = 1 // 非重复有效位置
        
        if (nums.length == 0) {
            return 0
        }

        for (i <- 1 until len) {
            if (nums(i) != nums(i - 1)) {
                nums(p) = nums(i)
                p += 1
            }
        }       

        p 
    }
}

println(Solution.removeDuplicates(Array(1, 1, 3, 4, 4, 7, 7, 9)))
