function captureTheNumbers(arr) {
    let result = [];
    let pat = /\d+/g;

    for (let str of arr) {
        let match;

        while (match = pat.exec(str)) {
            result.push(match[0]);
        }
    }

    console.log(result.join(' '));
}
function v2(arr) {
    let text = arr.join(' ');
    let regex = /\d+/g;
    let numbers = text.match(regex);
    console.log(numbers.join(' '));
}
captureTheNumbers(['55d 62sdasgas'])
v2(['55d 62sdasgas'])