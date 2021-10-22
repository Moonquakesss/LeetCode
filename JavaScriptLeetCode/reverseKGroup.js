const hair = new ListNode(-1)
  hair.next = head

  let left_head = hair,
      right_tail = hair,
      cur = hair,
      count = 0
  
  let reverse_left, reverse_right
    
  while (cur) {
    if (count === 0) left_head = cur
    if (count === 1) reverse_left = cur
    if (count === k) {
      reverse_right = cur
      right_tail = cur.next
      left_head.next = null
      reverse_right.next = null
      reverseNode(reverse_left)
      left_head.next = reverse_right
      reverse_left.next = right_tail
      left_head = reverse_left
      cur = right_tail
      count = 1
      continue
    }
    cur = cur.next
    count++
  }

  return hair.next

  function reverseNode(head) {
    let pre = null,
        cur = head
    while (cur) {
      const next = cur.next
      cur.next = pre
      pre = cur
      cur = next
    }
  }