function orderNumbers(nums) {
    let result = [];

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            result.unshift(nums[i]);
        } else {
            result.push(nums[i]);
        }
    }

    console.log(result.join('\n'));
}
orderNumbers([3, -2, 0, -1])