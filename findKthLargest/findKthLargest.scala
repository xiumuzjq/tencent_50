object Solution {
    // 用快排搜索第 K 大参数
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val len = nums.length
        var (left, right) = (0, len - 1)
                   
        if (len == 1) {
            return 0
        }
        
        quickSort(nums, left, right, k)
    }

    def quickSort(nums: Array[Int], left: Int, right: Int, k: Int): Int = {
        if (left == right) {
            return 2
        }
    
        var pivot = partitionList(nums, left, right)
        println(nums.mkString(" "), ",", left, right, pivot) 
        quickSort(nums, pivot + 1, right, k)
        quickSort(nums, left, pivot - 1, k)
        1 
        //pivot match {
        //    case d if (d == k - 1) => {nums(pivot)}
        //    case d if (d < k - 1) => {quickSort(nums, pivot + 1, right, k)}
        //    case d if (d > k - 1) => {quickSort(nums, left, pivot - 1, k)} 
        //}
    }

    def partitionList(nums: Array[Int], left: Int, right: Int): Int = {
        val base = nums(right)

        var pos = left
        var tmp = 0
        
        if (left == right) {
            return 0
        }

        for (index <- left + 1 until right) {
            if (nums(index) >= base) {
                pos += 1
                tmp = nums(index)
                nums(index) = nums(pos)
                nums(pos) = tmp 
            }
        }

        tmp = nums(pos)
        nums(pos) = base
        nums(right) = tmp

        pos
    }
}

println(Solution.findKthLargest(Array(3,2,3,1,2,4,5,5,6), 4))
