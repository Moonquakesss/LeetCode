var pathSum = function(root, target) {
  let path = []
  let res = []
  function dfs(node, target) {
    if (node === null) return
    target = target - node.val
    path.push(node.val)
    if (target === 0 && node.left === null && node.right === null) {
      // 浅拷贝
      res.push([...path])
    }
    dfs(node.left, target)
    dfs(node.right, target)
    // 防止 dfs时对右子树的影响
    path.pop()
  }
  dfs(root, target)
  return res
};