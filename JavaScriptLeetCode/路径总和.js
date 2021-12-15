var hasPathSum = function(root, targetSum) {
  if (root === null) return false
  return help(root, targetSum, 0)
};

let help = function(root, targetSum, currentSum) {
  if (root === null) return false
  if (!root.left && !root.right) {
    currentSum += root.val
    if (currentSum === targetSum) {
      return true
    } 
    return false 
  }
  return help(root.left, targetSum, currentSum+root.val) || help(root.right, targetSum, currentSum+root.val)
}