function getElements(nums) {
    let k = nums[0];

    console.log(nums.slice(1, k + 1).join(' '));
    
    console.log(nums.slice(nums.length - k).join(' '));
}
getElements([3, 6, 7, 8, 9])