// 马拉车算法 728 毫秒
import scala.collection.mutable.Map
import scala.util.control.Breaks._


object Solution {

  def longestPalindrome(s: String): String = {
    val len = s.length
    val lens = Map[Int, Int]()
    val new_con = new Array[Char](2 * len + 2)

    var center = 1
    var right = 0
    var mirro = 0
    var index = 0
    var max_center = 0
    
    if (len == 0) {
        return s
    }

    // 填充新数组
    for (c <- s) {
      new_con(index) = "^".charAt(0)
      index += 1
      new_con(index) = c
      index += 1
    }

    new_con(index) = "^".charAt(0)

    // 遍历s
    lens.put(0, 0)
    breakable {
      for (i <- 1 to new_con.length - 1) {
        lens.put(i, 0)

        if (lens(center) + i + 1> new_con.length) {
          break
        }


        if (i < right) {
          mirro = 2 * center - i
          lens.put(i, Math.min(lens.getOrElse(mirro, 0), right - i))
        }
        //println(lens(i), i)
        while (i - 1 >= lens(i) && new_con(lens(i) + i + 1) == new_con(i - 1 - lens(i))) {
          lens.put(i, lens(i) + 1)
        }

        if (i + lens(i) > right) {
          right = i + lens(i)
          center = i
        }

        if (lens(i) > lens(max_center)) {
          max_center = i
        }
      }
    }

    //println(max_center, lens)
    new_con.slice(max_center - lens(max_center), max_center + lens(max_center)).filter(x => x != "^".charAt(0)).mkString("")
  }

}

println(Solution.longestPalindrome("eabccbad"))
