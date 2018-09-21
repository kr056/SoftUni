function printArrWithDelimiter(arr) {
    let delimiter = arr.pop();

    console.log(arr.join(delimiter));
}
printArrWithDelimiter(['daba', 'daba', 'dsadas', '-'])