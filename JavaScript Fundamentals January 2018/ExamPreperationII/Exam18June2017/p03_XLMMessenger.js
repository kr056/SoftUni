function xmlMessanger(text) {
    let messagePattern = /^<message(\s*[a-z]+\=\"[a-zA-Z0-9\s.]+\")*>([\s\S]*)<\/message>$/g;
    let attributesPattern = /.*?(([a-z]+)\=(\"[a-zA-Z0-9\s\.]+))\".*?/g;
    let match = messagePattern.exec(text);
    let attributes = {};

    if (match) {
        let attribute;

        while (attribute = attributesPattern.exec(text)) {
            attributes[attribute[2]] = attribute[3];
        }

        if (attributes.hasOwnProperty('to') && attributes.hasOwnProperty('from')) {
            let sender = attributes['from'].replace(/\"/g, "");
            let receiver = attributes['to'].replace(/\"/g, "");
            let msg = match[2].toString().split('\n');
            let html = `<article>
  <div>From: <span class="sender">${sender}</span></div>
  <div>To: <span class="recipient">${receiver}</span></div>
  <div>\n`;

            for (let line of msg) {
                html += `    <p>${line}</p>\n`;
            }
            
            html += `  </div>
</article>
`;
            console.log(html);
        } else {
            console.log('Missing attributes');
        }
    } else {
        console.log('Invalid message format');
    }
}

xmlMessanger('<message to="Bob" from="Alice" timestamp="1497254092">Hey man, what\'s up?</message>')