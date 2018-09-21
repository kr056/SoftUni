function extractTheLinks(arr) {
    let pat = /w{3}\.[a-zA-Z0-9\-]+(\.[a-z]+)+/;

    for (let sentence of arr) {
        let match = pat.exec(sentence);

        if (match) {
            console.log(match[0]);
        }
    }
}
extractTheLinks(['Join WebStars now for free, at www.web-stars.com',
    'You can also support our partners:',
    'Internet - www.internet.com',
    'WebSpiders - www.webspiders101.com',
    'Sentinel - www.sentinel.-ko '
])