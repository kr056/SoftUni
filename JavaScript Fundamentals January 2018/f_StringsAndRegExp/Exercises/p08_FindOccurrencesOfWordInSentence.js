function findOccurrencesOfWordInSentence(sentence, word) {
    let exp = new RegExp("\\b" + word + "\\b", "ig");
    let match = exp.exec(sentence);
    let count = 0;

    while (match) {
        count++;
        match = exp.exec(sentence);
    }

    console.log(count);
}
findOccurrencesOfWordInSentence('jaba jaba Jaba d', 'jaba')