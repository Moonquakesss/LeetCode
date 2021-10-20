var longestPalindrome = function(s) {
  if (s.length === 1) {
    return s
  }
  if (s.length === 2 && s.charAt(0) === s.charAt(1)) {
    return s
  }
  let res_l=0, res_r=1
  for (let i=0; i<s.length; i++) {
    finder(i, i)
    finder(i, i+1)
  }

  return s.slice(res_l+1, res_r)

  function finder(l, r) {
    while (l >= 0 && r < s.length && s.charAt(l) === s.charAt(r)) {
      l--
      r++
    }
    if (r-l > res_r - res_l) {
      res_l = l
      res_r = r
    }
}
};