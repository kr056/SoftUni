function lastKNumbersSequence(n, k) {
    let result = [1];

    for (let i = 1; i < n; i++) {
        let start = Math.max(0, i - k);
        let end = i;

        let sum = result.slice(start, end).reduce((a, b) => a + b, 0);
        result[i] = sum;
    }

    console.log(result.join(' '));
}
lastKNumbersSequence(6, 3)
lastKNumbersSequence(8, 2)