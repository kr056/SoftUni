function sumFirstLast(arr) {
    let parsedArr = arr.map(Number);
    return parsedArr[0] + parsedArr[arr.length - 1];
}

console.log(sumFirstLast(['20', 40, 60, '80']));