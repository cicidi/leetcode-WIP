/*
 * @lc app=leetcode id=86 lang=golang
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (38.57%)
 * Total Accepted:    186.3K
 * Total Submissions: 476.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */

// Definition for singly-linked list.
 type ListNode struct {
     Val int
     Next *ListNode
 }

func partition(head *ListNode, x int) *ListNode {
	var emptyNode *ListNode

	for head != nil {
	 	if !start && head.Val == x {
			start == true
			continue
		}
		if start {
			if head.Val < x {
				if emptyNode == nil{
					emptyNode = &ListNode{Val : head.Val}
				}else{
					emptyNode.Next = &ListNode(Val : head.Val}
					emptyNode = emptyNode.Next
				}
				
			}
		}
		head = head.Next
	}


}



