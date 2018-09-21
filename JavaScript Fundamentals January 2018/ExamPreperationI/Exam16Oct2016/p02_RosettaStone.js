function rosettaStonev2(arr) {
    let templateLength = Number(arr.shift());
    let template = [];

    for (let i = 0; i < templateLength; i++) {
        template.push(arr.shift().split(' ').map(Number))
    }

    let messageMatrix = [];

    for (let i = 0; i < arr.length; i++) {
        messageMatrix.push(arr[i].split(' ').map(Number))
    }

    for (let i = 0; i < messageMatrix.length; i++) {
        for (let j = 0; j < messageMatrix[i].length; j++) {
            messageMatrix[i][j] += template[i % templateLength][j % template[0].length];
            messageMatrix[i][j] %= 27;

            if (messageMatrix[i][j] === 0) {
                messageMatrix[i][j] = ' ';
            } else {
                messageMatrix[i][j] = String.fromCharCode(64 + messageMatrix[i][j])
            }
        }
    }

    console.log(messageMatrix.map(r => r.join('')).join(''));

}

rosettaStonev2(['2',
    '59 36',
    '82 52',
    '4 18 25 19 8',
    '4 2 8 2 18',
    '23 14 22 0 22',
    '2 17 13 19 20',
    '0 9 0 22 22']
)