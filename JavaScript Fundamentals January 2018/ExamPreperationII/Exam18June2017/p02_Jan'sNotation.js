function jansNotation(arr) {
    let operands = [];

    for (let i = 0; i < arr.length; i++) {
        let symbol = arr[i];

        if (!isNaN(symbol)) {
            operands.push(Number(symbol));
        } else {
            if (operands.length < 2) {
                console.log('Error: not enough operands!');
                return;
            }
            let num1 = operands.pop();
            let num2 = operands.pop();
            let operator = symbol;

            if (operator === '+') {
                operands.push(num2 + num1);
            } else if (operator === '-') {
                operands.push(num2 - num1);
            } else if (operator === '*') {
                operands.push(num2 * num1);
            } else {
                operands.push(num2 / num1);
            }
        }
    }

    if (operands.length > 1) {
        console.log('Error: too many operands!');
    } else {
        console.log(operands[0]);
    }
}