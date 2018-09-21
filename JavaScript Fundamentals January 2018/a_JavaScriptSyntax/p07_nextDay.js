function getNextDay(y, m, d) {
    let date = new Date(y, m - 1, d);
    let oneDay = 24 * 60 * 60 * 1000; //millisecond in one day
    let nextDate = new Date(date.getTime() + oneDay);

    return nextDate.getFullYear() + "-" + (nextDate.getMonth() + 1)
        + "-" + nextDate.getDate();
}

console.log(getNextDay(2016, 9, 30))
