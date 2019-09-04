/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    // 排序链表，快排算法，原地排序
    // 打印某个端点开始的链表，调式用
    def printX(head: ListNode) = {
        var cur = head
        while (cur != null) {
            print(cur.x + ",")
            cur = cur.next
        }    
    }
    
    def partitionList(left: ListNode, right: ListNode): ListNode = {
        if (left.next == null) {
            return left
        }

        
        val base = left.x
        
        var cur = left.next
        var pos = left
        var tmp = 0
                
        while (cur != null && cur != right) {
            if (cur.x < base) {
                pos = pos.next
                
                tmp = pos.x
                pos.x = cur.x
                cur.x = tmp
            }
            
            cur = cur.next
        }

        tmp = pos.x
        pos.x = left.x
        left.x = tmp

        pos
    }
    
    def work(left: ListNode, right: ListNode): ListNode = {
        if (left == null || left.next == right || left == right) {
            return left
        }
        
        var mid = partitionList(left, right) 

        work(left, mid)
        work(mid.next, right)
        
        left
    }
    
    def sortList(head: ListNode): ListNode = {
        if (head == null || head.next == null) {
            return head
        }
        
        work(head, null)
    }
}
