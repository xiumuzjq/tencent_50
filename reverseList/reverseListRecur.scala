/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    // 递归模式反转链表    
    def reverseList(head: ListNode): ListNode = {
        if (head == null || head.next == null) {
            return head
        }
        
        var tmp = head.next
        
        head.next = null
        
        val rst = reverseList(tmp)
        
        tmp.next = head
        rst
    }
}
