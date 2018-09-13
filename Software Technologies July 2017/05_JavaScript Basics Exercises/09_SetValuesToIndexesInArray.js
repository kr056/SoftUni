function setValues(arr) {

    let resultArr = new Array(Number(arr[0]));

    for (let j = 0; j < resultArr.length; j++) {
        resultArr[j] = 0;
    }

    for (let i = 1; i <= arr.length - 1; i++) {
        let pair = arr[i].split(/\s-\s/).map(Number);
        let index = pair[0];

        resultArr[index] = pair[1];
    }

    for (let el of resultArr) {
        console.log(el);
    }
}
