function validityChecker(input) {
    let x = 0, y = 0;
    let x1 = input[0], y1 = input[1];
    let x2 = input[2], y2 = input[3];

    console.log(checkIsPointValid(x1, y1, x, y));
    console.log(checkIsPointValid(x2, y2, x, y));
    console.log(checkIsPointValid(x1, y1, x2, y2));

    function checkIsPointValid(x1, y1, x2, y2) {
        let d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        let output = `{${x1}, ${y1}} to {${x2}, ${y2}} is `;

        if (d.toString().includes('.')) {
            output += 'invalid';
        } else {
            output += 'valid';
        }
        
        return output;
    }
}
validityChecker([2, 1, 1, 1])