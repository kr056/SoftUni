function checkForPalindrome(str) {
    let originalWord = str;

    function reverseWord(word) {
        let reversedWord = '';

        for (let i = word.length - 1; i >= 0; i--) {
            reversedWord += word[i];
        }

        return reversedWord;
    }

    let reversedWord = reverseWord(originalWord);

    if (originalWord === reversedWord) {
        console.log('true');
    } else {
        console.log('false');
    }
}

checkForPalindrome('haha');
checkForPalindrome('racecar');
checkForPalindrome('unitinu');