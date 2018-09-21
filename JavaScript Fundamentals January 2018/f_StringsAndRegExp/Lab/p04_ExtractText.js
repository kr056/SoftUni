function extractText(str) {
    let result = [];
    let startIndex = str.indexOf('(');

    while (startIndex !== -1) {
        let endIndex = str.indexOf(')', startIndex);

        if (endIndex === -1) {
            break;
        }

        result.push(str.substring(startIndex + 1, endIndex));
        startIndex = str.indexOf('(', endIndex);
    }

    console.log(result.join(', '));
}
extractText('(dasdasdassa)sup')