function getEvenPositionEls(nums) {
    let result = [];

    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            result.push(nums[i]);
        }
    }

    return result.join(' ');
}
console.log(getEvenPositionEls(['5', '10']));