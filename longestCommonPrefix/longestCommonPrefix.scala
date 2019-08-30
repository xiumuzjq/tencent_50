object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        var c = ' '

        for (index <- 0 until strs(0).length) {
            c = strs(0).charAt(index)
               
            for (str <- strs) {
                if (str.length - 1 < index || str(index) != c) {
                    return strs(0).slice(0, index)
                }
            }
        } 

        ""     
    }
}

println(Solution.longestCommonPrefix(Array("abcdf", "a", "abc")))
