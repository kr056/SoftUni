function smallestTwoNumbers(nums) {
    nums.sort((a, b) => a - b);
    let result = nums.slice(0, 2).join(' ');
    console.log(result);
}
smallestTwoNumbers([30, 15, 50, 5])