function jsonTable(arr) {
    let html = '<table>\n';

    for (let i = 0; i < arr.length; i++) {
        let jsonArr = JSON.parse(arr[i]);

        html += '   <tr>\n';
        html += `        <td>${htmlEscape(jsonArr['name'] + '')}</td>\n`;
        html += `        <td>${htmlEscape(jsonArr['position'] + '')}</td>\n`;
        html += `        <td>${Number(htmlEscape(jsonArr['salary'] + ''))}</td>\n`;
        html += '   <tr>\n';
    }
    
    html += '</table>';
    console.log(html);

    function htmlEscape(text) {
        let map = {
            '"': '&quot;', '&': '&amp;',
            "'": '&#39;', '<': '&lt;', '>': '&gt;'
        }
        return text.replace(/["&'<>]/g, ch => map[ch]);
    }
}
jsonTable(['{"name":"Pesho","position":"Promenliva","salary":100000}', '{"name":"Teo","position":"Lecturer","salary":1000}'])