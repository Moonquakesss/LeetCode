 var treeToDoublyList = function(root) {
  if (!root) {
    return null
  }

  let head, prev
  
  dfs(root)
  head.left = prev
  prev.right = head

  return head

  function dfs(node) {
    if (node === null) return
    dfs(node.left)
    // 注意一开始prev为undefined 而不是 null
    if (!prev) {
      head = node
    } else {
      prev.right = node
    }
    // 这里是公共部分，即第一次也会执行
    node.left = prev
    prev = node
    dfs(node.right)
  }
};


















var treeToDoublyList = function(root) {
  let head, pre

  function dfs(node) {
    if (node === null) return
    dfs(node.left)
    // if (prev === null) {
    //   head = node
    //   node.left = prev
    //   prev = node
    // } else {
    //   prev.right = node
    //   node.left = prev
    //   prev = node
    // }
    if (pre !== null) pre.right = node
    else head = node
    node.left = pre
    pre = node
    dfs(node.right)
  }

  dfs(root)
  head.left = pre
  pre.right = head

  return head

};
