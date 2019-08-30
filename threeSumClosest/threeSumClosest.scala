

object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
        val sn = nums.sortWith(_ < _)
        val len = sn.length

        var diff = Int.MaxValue                
        var sum = 0
        var left = 0
        var right = 0
        var middle = 0
        var ts = 0

        for (index <- 1 until len) {
            middle = sn(index)
            left = index - 1
            right = index + 1

            while (left >= 0 && right < len) {
                ts = sn(left) + sn(index) + sn(right)
                if (Math.abs(target - ts) < diff) {
                    diff = Math.abs(target - ts)
                    sum = ts
                }           
            
                if (ts < target) {
                    right += 1
                } else if (ts > target) {
                    left -= 1
                } else {
                    return sum
                }
            }     
        }
        
        sum
    }
}
