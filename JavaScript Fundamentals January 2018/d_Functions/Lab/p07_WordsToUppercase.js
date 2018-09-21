function extractUppercaseWords(str) {
    console.log(str.split(/\W+/)
        .filter(x => x !== '')
        .map(x => x.toUpperCase())
        .join(', '));
}

extractUppercaseWords('Hi, how are you???')