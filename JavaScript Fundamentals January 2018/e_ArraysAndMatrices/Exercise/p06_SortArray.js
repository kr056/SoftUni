function sortArray(arr) {
    arr.sort((a, b) => a.length - b.length || a > b);
    console.log(arr.join('\n'));
}
sortArray(['test', 'Deny', 'omen', 'Default'])
