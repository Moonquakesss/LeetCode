var permute = function(nums) {
  let result = []
  let path = []

  function backTracking(path, nums) {
    if (path.length === nums.length) {
      // 此处注意赋值
      result.push([...path])
      return;
    }
    for (let i=0; i<nums.length; i++) {
      if (path.indexOf(nums[i]) !== -1) {
        continue
      }
      path.push(nums[i])
      backTracking(path, nums)
      path.pop()
    }
  }

  backTracking(path, nums)
  return result
};
