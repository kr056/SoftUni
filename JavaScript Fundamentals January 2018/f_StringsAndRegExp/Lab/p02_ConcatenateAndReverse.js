function concatAndReverse(arr) {
    let result = '';

    for (let i = arr.length - 1; i >= 0; i--) {
        for (let j = arr[i].length - 1; j >= 0; j--) {
            result += arr[i][j];
        }
    }

    console.log(result);
}
concatAndReverse(['iam', 'sid'])