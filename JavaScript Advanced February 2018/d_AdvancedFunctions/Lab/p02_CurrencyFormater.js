function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);

    if (symbolFirst) {
        return symbol + ' ' + result;
    }
    else {
        return result + ' ' + symbol;
    }
}

let formatter = getDollarFormatter(currencyFormatter);

function getDollarFormatter(func) {
    return function (value) {
        return func(',', '$', true, value);
    }
}

console.log(formatter(5434));
console.log(formatter(5.3488888888));
