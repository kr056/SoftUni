function round(input) {
    let num = input[0];
    let precision = input[1];

    if (precision > 15) {
        precision = 15;
    }

    let roundedNum = num.toFixed(precision);
    let str = roundedNum.toString().replace(/(\.\d*?[1-9]*)(0+)(\s*%?)$/, '$1$3');
    return str;
}

console.log(round([10.5, 3]))
