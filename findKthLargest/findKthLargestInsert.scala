object Solution {
    def insert(arr: Array[Int], ele: Int, top: Int): Int = {
        if (top == 0) {
            arr(top) = ele
            return 0
        }
    
        var i = top - 1
        var tmp = arr(top)
        while (i >= 0 && ele > arr(i)) {
            arr(i + 1) = arr(i)
            i -= 1
        }

        i += 1
        if (i < top) {
            // 说明老数据移动过
            arr(i) = ele
        } else {
            // 循环未比较末尾元素
            arr(top) = ele
        } 

        return top
    }

    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val len = nums.length
        val c = Array.fill[Int](len)(Int.MaxValue)
        
        var status = 0
        var top = 0

        for (ele <- nums) {
            status = insert(c, ele, top)
            println(c.mkString(","))
            println(ele, top, status)
            //if (status != -1) {
            top += 1
            //}
        }
        
        return c(k - 1)
    }
}

println(Solution.findKthLargest(Array(3,2,3,1,2,4,5,5,6), 4))
