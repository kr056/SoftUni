function matchAllWords(str) {
    return str.split(/\W+/).filter(x => x !== '').join('|');
}
console.log(matchAllWords('A Regular Expression needs to have the global flag in order to match all occurrences in the text'));