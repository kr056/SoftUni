function countWordsInText(arr) {
    let data = {};

    for (let i = 0; i < arr.length; i++) {
        let text = arr[i].split(/[^\w]+/).filter(x => x !== '');

        for (let str of text) {
            if (data.hasOwnProperty(str)) {
                data[str]++;
            } else {
                data[str] = 1;
            }
        }
    }

    console.log(JSON.stringify(data));
}
countWordsInText(["Far too slow, you're far too slow."])