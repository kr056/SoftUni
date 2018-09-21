function findBiggestElementInMatrix(matrix) {
    let max = Number.NEGATIVE_INFINITY;

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] > max) {
                max = matrix[i][j];
            }
        }
    }

    return max;
}
console.log(findBiggestElementInMatrix([[20, 50, 10],
[8, 33, 145]]
));