/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    // 迭代方式倒转
    def reverseList(head: ListNode): ListNode = {
        
        if (head == null || head.next == null) {
            return head
        }
        
        var dummy = head
        var curr = dummy.next
        var tmp = curr
        dummy.next = null

        while (curr != null) {
            tmp = curr.next
            curr.next = dummy
            dummy = curr
            curr = tmp
        }     

        dummy
    }
}
