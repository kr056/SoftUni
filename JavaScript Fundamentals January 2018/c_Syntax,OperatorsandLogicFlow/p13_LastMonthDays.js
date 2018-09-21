function getLastMonthDay(input) {
    let prevDate = new Date(input[2], input[1] - 1, 0);
    
    return prevDate.getDate();
}

console.log(getLastMonthDay([13, 12, 2004]))
console.log(getLastMonthDay([17, 3, 2002]))