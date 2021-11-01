var fourSum = function(nums, target) {
  let map = new Map()
  // nums.sort((a,b) => a-b)
  let res = []
  for (let i=0; i<nums.length; i++) {
    let newTarget = target - nums[i]
    map.set(newTarget, i)
  }
  for (let i=0; i<nums.length-2; i++) {
    for (let j=i+1; j<nums.length-1; j++) {
      for (let k=j+1; k<nums.length; k++) {
        let sum3 = nums[i] + nums[j] + nums[k]
        let first = map.get(sum3)
        if (first && first !== i && first !== j && first !== k) {
          res.push([nums[map.get(sum3)], nums[i], nums[j], nums[k]].sort((a,b) => a-b))
        }
      }
    }
  }
  return noRepat(res)

  function noRepat(nums) {
    let newNums = []
    let set = new Set()
    for (let i=0; i<nums.length; i++) {
      if (set.has(nums[i].toString())) {
        continue
      }
      set.add(nums[i].toString())
      newNums.push(nums[i])
    }
    return newNums
  }
};

let nums = [1,0,-1,0,-2,2], target = 0

console.log(fourSum(nums, target));