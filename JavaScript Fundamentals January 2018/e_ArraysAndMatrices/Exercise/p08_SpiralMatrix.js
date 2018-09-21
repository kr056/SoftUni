function spiralMatrix(rows, cols) {
    let matrix = [];

    for (let i = 0; i < rows; i++) {
        matrix[i] = [];
    }

    let startRow = 0, startCol = 0, endRow = rows - 1, endCol = cols - 1;
    let val = 1;

    while (startRow <= endRow || startCol <= endCol) {
        for (let i = startCol; i <= endCol; i++) {
            matrix[startRow][i] = val++;
        }

        for (let i = startRow + 1; i <= endRow; i++) {
            matrix[i][endCol] = val++;
        }

        for (let i = endCol - 1; i >= startCol; i--) {
            matrix[endRow][i] = val++;
        }

        for (let i = endRow - 1; i > startRow; i--) {
            matrix[i][startCol] = val++;
        }

        startRow++;
        startCol++;
        endRow--;
        endCol--;
    }

    console.log(matrix.map(r => r.join(' ')).join('\n'));
}
spiralMatrix(7, 7)