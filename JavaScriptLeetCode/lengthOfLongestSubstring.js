var lengthOfLongestSubstring = function(s) {
  let maxLen = 0
  let left = 0
  let right = 1
  while (right <= s.length && left < right) {
    if (right-left === ([...new Set(s.substring(left, right))].length)) {
      if ((right-left) > maxLen) maxLen = right - left
      right++
    } else {
      left++
    }
  }
  return maxLen
};

