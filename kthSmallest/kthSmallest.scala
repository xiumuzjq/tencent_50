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
    // 计算子节点总数 O(n)
    def kthSmallest(root: TreeNode, k: Int): Int = {
        if (root == null) {
            return -1
        }        

        var node_size = calculate_size(root.left)
        if (node_size == k - 1) {
            return root.value
        } else if (node_size > k - 1) {
            return kthSmallest(root.left, k)
        } else {
            return kthSmallest(root.right, k - node_size - 1)
        }
        
    }

    // 计算该节点下的子节点数
    def calculate_size(node: TreeNode): Int = {
        if (node == null) {
            0
        } else {
            1 + calculate_size(node.left) + calculate_size(node.right)
        }
    }
}
