object Solution {
    def maxArea(height: Array[Int]): Int = {
        val len = height.length
        var left = 0
        var right = len - 1
        var area = 0
        var max = 0

        while (left >= 0 && right < len && left < right) {
            area = (right - left) * Math.min(height(right), height(left))
            if (area > max) {
                max = area
            }

            if (height(left) < height(right)) {
                left += 1
            } else {
                right -= 1
            }
        }       

        max
    }
}


println(Solution.maxArea(Array(1,8,6,2,5,4,8,3,7)))
