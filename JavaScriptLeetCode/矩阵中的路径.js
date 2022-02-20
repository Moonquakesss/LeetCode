/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
 var exist = function(board, word) {
  let m = board.length
  let n = board[0].length

  // index 表示word中该索引所在char匹配
  function dfs(i,j,index) {
    // 注意这里是 >= 
    if (i<0 || j<0 || i>=m || j>=n || board[i][j] !== word[index]) {
      return false
    }
    if (index === word.length-1) {
      return true
    }
    let temp = board[i][j]
    // 访问过的先标记 以免后续dfs重复访问
    board[i][j] = ''
    // 上下左右进行搜索
    let res = 
    dfs(i-1, j, index+1) ||
    dfs(i+1, j, index+1) ||
    dfs(i, j-1, index+1) ||
    dfs(i, j+1, index+1)

    // 恢复标记 给上层dfs访问
    board[i][j] = temp
    return res
  }

  for (let i=0; i<m; i++) {
    for (let j=0; j<n; j++) {
      if (dfs(i,j,0)) {
        return true
      }
    }
  }

  // 从任一位置开始搜索都没找到则返回 false
  return false
};