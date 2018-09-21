function checkMatrices(matrix) {
    let rowSum = 0;
    matrix[0].forEach(x => rowSum += x);

    for (let row = 1; row < matrix.length; row++) {
        let currentSum = 0;
        matrix[row].forEach(x => currentSum += x);

        if (rowSum !== currentSum) {
            return false;
        }

    }

    for (let col = 0; col < matrix[0].length; col++) {
        let colSum = 0;

        for (let row = 0; row < matrix.length; row++) {
            colSum += matrix[row][col];
        }

        if (rowSum !== colSum) {
            return false;
        }

    }

    return true;
}

console.log(checkMatrices([[2, 0, 0],
[0, 2, 0],
[0, 0, 1]]
));