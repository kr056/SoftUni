function matchDates(arr) {
    let pat = /\b(\d{1,2})-([A-Z][a-z]{2})-(\d{4})\b/g;
    let date;

    for (let i = 0; i < arr.length; i++) {
        while (date = pat.exec(arr[i])) {
            console.log(`${date[0]} (Day: ${date[1]}, Month: ${date[2]}, Year: ${date[3]})`);
        }
    }
}
matchDates(['29-Jul-1955'])