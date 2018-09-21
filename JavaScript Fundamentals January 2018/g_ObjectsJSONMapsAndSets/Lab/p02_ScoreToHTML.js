function scoreToHTML(JSONobj) {
    let html = '<table>\n';
    html += '<tr><th>name</th><th>score</th></tr>\n';
    let arr = JSON.parse(JSONobj);

    for (let obj of arr) {
        html += `<tr><td>${htmlEscape(obj['name'])}` +
            `</td><td>${obj['score']}</td></tr>\n`;
    }

    return html + `</table>`;


    function htmlEscape(text) {
        let map = {
            '"': '&quot;', '&': '&amp;',
            "'": '&#39;', '<': '&lt;', '>': '&gt;'
        }
        
        return text.replace(/["&'<>]/g, ch => map[ch]);
    }
}
console.log(scoreToHTML('[{"name":"Pesho & Kiro","score":479},{"name":"Gosho, Maria & Viki","score":205}]'));