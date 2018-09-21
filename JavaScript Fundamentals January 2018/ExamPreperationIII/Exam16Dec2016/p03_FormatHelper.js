function formatHelper([text]) {
    let first = /[ ]*([.,!?:;])[ ]*/g;
    let quotes = /"\s*(.+?)\s*"/g;
    let date = /\. (?=[0-9])/g;
    let manySymbols = /([.,!?:;]) (?=[.,!?:;])/g;

    console.log(text
        .replace(first, (match, g1) => `${g1} `)
        .replace(date, (match) => `.`)
        .replace(quotes, (match, g1) => `"${g1}"`)
        .replace(manySymbols, (match, g1) => g1));
}

formatHelper('Terribly formatted text . With chaotic spacings." Terrible quoting "! Also\n' +
    'this date is pretty "   shity   quote             " confusing : 20 . 12. 16 .')