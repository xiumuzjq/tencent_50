// 搜寻两个数组中位数
import util.control.Breaks._


object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        var l = nums2
        var s = nums1
        if (nums1.length > nums2.length) {
            l = nums1
            s = nums2
        }

        val m = s.length
        val n = l.length
        val isOdd = (m + n) % 2 == 1

        var min = 0
        var max = m

        var i = 0
        var j = 0
        var maxLeft = 0
        var minRight = 0
        var middle = 0


        // 尝试二分查找
        while (min <= max) {
            i = (min + max + 1) / 2 // 分割点左边界点
            j = (m + n + 1) / 2 - i 

            println(i, j)
            if (i < max && l(j-1) > s(i)) {
                min = i + 1
            } else if (i > min && s(i - 1) > l(j)) {
                max = i - 1
            } else {
                if (i == 0) {
                    maxLeft = l(j-1)
                } else if (j == 0) {
                     maxLeft = s(i-1)
                } else {
                    maxLeft = Math.max(s(i-1), l(j-1))
                }
                
                if (isOdd) {
                    return maxLeft
                }

                if (i == m) {
                    minRight = l(j)
                } else if (j == n) {
                    minRight = s(i)
                } else {
                    minRight = Math.min(s(i), l(j))
                }

                return (minRight + maxLeft) / 2.0
            }

        }

        return 0.0
    }
}


print(Solution.findMedianSortedArrays(Array(1, 2), Array(3, 4)))

