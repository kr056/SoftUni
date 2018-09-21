function expressionSplit(str) {
    let elements = str.split(/[\s(),;.]+/);

    console.log(elements.join('\n'));
}
expressionSplit('let sum = 4 * 4,b = "wow";')