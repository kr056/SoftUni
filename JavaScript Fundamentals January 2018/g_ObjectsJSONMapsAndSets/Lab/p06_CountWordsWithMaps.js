function countWordsWithMaps(arr) {
    let wordsMap = new Map();
    
    for (let i = 0; i < arr.length; i++) {
        let text = arr[i].split(/[^\w]+/).filter(x => x !== '')
            .map(w => w.toLowerCase());

        for (let str of text) {
            if (wordsMap.has(str)) {
                wordsMap.set(str, wordsMap.get(str) + 1)
            } else {
                wordsMap.set(str, 1)
            }
        }
    }
    let mapSorted = new Map([...wordsMap.entries()].sort());

    for (let [key, value] of mapSorted) {
        console.log(`'${key}' -> ${value} times`)
    }
}
countWordsWithMaps(["Far too slow, you're far too slow."])