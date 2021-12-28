var inorderTraversal = function(root) {
  if (root === null) return []
  let statck = [],
      result = []
  let cur = root
  // 这里把cur !== null 当作条件进行首次入栈
  // 不然 statck.push(cur) 会对第一个重复入栈
  while (statck.length > 0 || cur !== null) {
    if (cur !== null) {
      statck.push(cur)
      cur = cur.left
    } else {
      let top = statck.pop()
      result.push(top.val)
      cur = top.right
    }
  }
  return result
}