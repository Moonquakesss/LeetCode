var reverseBetween = function(head, left, right) {
  if (left === right) {
    return head
  }
  let hair = new ListNode(-1)
  hair.next = head

  let left_head = hair
  let right_tail = hair

  let cur = hair,
      count = 0
  while (cur.next !== null) {
    count++
    if (count === left) {
      left_head = cur
    }
    cur = cur.next
    if (count === right) {
      right_tail = cur.next
      cur.next = null
    }
  }

  let newHead = left_head.next
  left_head.next = null

  let prev = helper(newHead)

  left_head.next = prev
  newHead.next = right_tail

  return hair.next
  
  function helper(head) {
    let prev = null
    let cur = head
    while (cur) {
      let temp = cur.next
      cur.next = prev
      prev = cur
      cur = temp
    }
    return prev
  }
};