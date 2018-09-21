function findVariableNamesInSentence(line) {
    let pat = /\b_[a-zA-Z0-9]+\b/g;
    let result = line.match(pat);
    console.log(result.map(x => x.substring(1)).join(','));
}
findVariableNamesInSentence('__invalidVariable _evenMoreInvalidVariable_ _validVariable')