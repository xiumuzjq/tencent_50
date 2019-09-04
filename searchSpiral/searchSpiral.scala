object Solution {
    // 搜索循环数组
    def search(nums: Array[Int], target: Int): Int = {
        val len = nums.length
        
        var left = 0
        var right = len - 1
        var mid = 0
        
        if (len == 1) {
            return if (nums(0) == target) 0 else -1
        }
        
        while (left < right) {
            mid = (left + right) / 2 
            //println(left, mid, right)
            if (nums(left) == target) {
                return left
            } else if (nums(right) == target) {
                return right
            } else if (right - left == 1) {
                return -1
            } 
            
            if (nums(mid) > nums(left)) {
                if (target < nums(mid) && target > nums(left)) {
                    right = mid
                } else {
                    left = mid
                }
            } else {
                if (target < nums(right) && target > nums(mid)) {
                    left = mid
                } else {
                    right = mid
                }
            }
        }
        
        -1
    }
}
