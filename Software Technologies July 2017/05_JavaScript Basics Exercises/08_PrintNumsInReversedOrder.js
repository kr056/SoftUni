function printInReversedOrder(arr) {
    let nums = arr.filter(function (e) {
        return e!==0;
    }).map(Number);

    let reversedNums=[];

    for(let i=0;i<nums.length;i++){
        reversedNums[i]=nums[nums.length-1-i];
        console.log(reversedNums[i]);
    }
}
