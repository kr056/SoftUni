function productOfNumbers(arr) {

    let nums = arr.map(Number);
    let negativeCount = 0;

    for (let i = 0; i < nums.length; i++) {

        if (nums[i] === 0) {
            console.log("Positive");
            return;
        }

        if (nums[i] < 0) {
            negativeCount++;
        }
    }

    if (negativeCount === 1 || negativeCount === 3) {
        console.log("Negative");
    }
    else {
        console.log("Positive");
    }
}