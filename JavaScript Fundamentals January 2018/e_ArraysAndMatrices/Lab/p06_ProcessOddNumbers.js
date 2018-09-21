function processOddNumbers(nums) {
    let result = '';

    // for (let i = nums.length - 1; i >= 0; i--) {
    //     if (i % 2 === 1) {
    //         result += nums[i] * 2 + ' ';
    //     }
    // }

    // return result

    //Second solution
    let resultTwo = nums
        .filter((num,i)=>i%2==1)
        .map(x=>x*2)
        .reverse();
    return resultTwo.join(' ');
}
console.log(processOddNumbers([10,15,20,25]))