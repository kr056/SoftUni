function mathOperation(arr) {

    let nums = arr.map(Number);

    let n = nums[0];
    let x = nums[1];
    if (x >= n) {
        console.log(n * x);
    }
    else {
        console.log(n / x);
    }
}