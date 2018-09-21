function uniqueSeq(input) {
    let arraySet = [];

    for (let line of input) {
        let arr = JSON.parse(line);
        arraySet.push(arr.map(Number).sort((a, b) => b - a));
    }

    for (let i = 0; i < arraySet.length; i++) {
        for (let j = i + 1; j < arraySet.length; j++) {
            let areEqual = (arraySet[i].length === arraySet[j].length)
                && arraySet[i].every((el, index) => el === arraySet[j][index]);

            if (areEqual) {
                arraySet.splice(j, 1);
                j--;
            }
        }
    }

    arraySet.sort((a, b) => a.length - b.length);
    arraySet.forEach(a => console.log("[" + a.join(", ") + "]"));
}
uniqueSeq([`[-3, -2, -1, 0, 1, 2, 3, 4]`,'[10, 1, -17, 0, 2, 13]','[10, 1, -17, 0, 2, 13]'])