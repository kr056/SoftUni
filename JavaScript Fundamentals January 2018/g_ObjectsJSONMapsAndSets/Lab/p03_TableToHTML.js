function tableToHTML(JSONstr) {
    let arr = JSON.parse(JSONstr);
    let html = '<table>\n';
    html += '   <tr>';

    let keys = Object.keys(arr[0]);

    for (let key of keys) {
        if (key !== undefined) {
            html += `<th>${htmlEscape(key)}</th>`
        }
    }

    html += '</tr>\n';

    for (let obj of arr) {
        html += '   <tr>';

        for (let i = 0; i < keys.length; i++) {
            html += `<td>${htmlEscape(obj[keys[i]] + '')}` +
                `</td>`;
        }

        html += '</tr>\n';
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
console.log(tableToHTML('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]'))