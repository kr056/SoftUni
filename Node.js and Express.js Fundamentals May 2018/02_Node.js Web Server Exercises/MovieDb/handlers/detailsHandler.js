const url = require('url');
const fs = require('fs');
const database = require('../config/dataBase');
const path = require('path');

module.exports = (req, res) => {
    req.pathname = req.pathname || url.parse(req.url).pathname;

    if (req.pathname.includes('details') && req.method === 'GET') {
        let filePath = path.normalize(
            path.join(__dirname, '../views/details.html'));

        fs.readFile(filePath, (err, data) => {
            if (err) {
                console.log(err);
                res.writeHead(404,
                    {
                        'Content-Type': 'text/plain'
                    });

                res.write('404 not found!');
                res.end();
                
                return;
            }

            let movieIndex = req.pathname.substr(req.pathname.length - 1);
            let content = `<div class="content">
            <img src="${decodeURIComponent(database[movieIndex].moviePoster)}" alt=""/>
            <h3>Title ${database[movieIndex].movieTitle}</h3>
            <h3>Year ${database[movieIndex].movieYear}</h3>
            <p> ${database[movieIndex].movieDescription}</p>
            </div>`;


            let html = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', content);

            res.writeHead(200, {
                'Content-Type': 'text/html'
            })

            res.write(html);
            res.end();
        })
    } else {
        return true;
    }
}