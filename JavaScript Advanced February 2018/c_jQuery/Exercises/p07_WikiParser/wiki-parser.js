/**
 * Created by BooM on 22.2.2018 г..
 */
function wikiParser(selector) {
    let text = $(selector).text();
    text = text.replace(/'''(.*?)'''/g, '<b>$1</b>')
        .replace(/''(.*?)''/g, '<i>$1</i>')
        .replace(/===(.*?)===/g, '<h3>$1</h3>')
        .replace(/==(.*?)==/g, '<h2>$1</h2>')
        .replace(/=(.*?)=/g, '<h1>$1</h1>')
        .replace(/\[\[([^|[]*?)]]/g, '<a href="/wiki/$1">$1</a>')
        .replace(/\[\[([^|[]*?)\|(.*?)]]/g, '<a href="/wiki/$1">$2</a>');

    $(selector).html(text)


}
