/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import collection.mutable


object Solution {
    // 通过堆栈遍历树
    def kthSmallest(root: TreeNode, k: Int): Int = {
        val s = new mutable.Stack[TreeNode]()
        
        var kth = k
        var cur = root

        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur)
                cur = cur.left
            } else {
                cur = s.pop()
                k -= 1
                if (k == 0) {
                    return cur.value
                }
                
                cur = cur.right
            }
        }
    }

}
