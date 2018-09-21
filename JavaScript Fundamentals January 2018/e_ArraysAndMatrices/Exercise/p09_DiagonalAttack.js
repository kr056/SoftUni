function diagonalAttack(input) {
    let matrix = input.map(row => row.split(" ").map(Number));

    let d1Sum = 0;
    let d2Sum = 0;

    for (let i = 0; i < matrix.length; i++) {
        d1Sum += matrix[i][i];
        d2Sum += matrix[i][matrix.length - 1 - i];
    }

    if (d1Sum === d2Sum) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                if (row + col !== row + row && row + col !== (matrix.length - 1 - row) + row) {
                    matrix[row][col] = d1Sum;
                }
            }
        }
    }

    console.log(matrix.map(row => row.join(' ')).join('\n'));
}
diagonalAttack(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']
)