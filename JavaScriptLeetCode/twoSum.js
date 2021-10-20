var twoSum = function(nums, target) {
  map = new Map()
  let res = []
  for (let i=0; i<nums.length; i++) {
    map.has(target-nums[i]) ? res = [map.get(target-nums[i]),i] : map.set(nums[i], i)
  }
  return res
};