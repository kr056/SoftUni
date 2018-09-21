function orbit(arr) {
    let cols = arr[0];
    let rows = arr[1];
    let x = arr[2];
    let y = arr[3];

    let star = 1;
    let matrix = [];

    for (let row = 0; row < rows; row++) {
        matrix[row] = [];

        for (let col = 0; col < cols; col++) {
            matrix[row][col] = Math.max(Math.abs(row - x), Math.abs(col - y)) + star;
        }
    }

    console.log(matrix.map(r => r.join(' ')).join('\n'));
}
orbit([5, 5, 2, 2])