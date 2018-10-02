const url = require('url');
const fs = require('fs');
const database = require('../config/dataBase');
const path = require('path');

module.exports = (req, res) => {
    req.pathname = req.pathname || url.parse(req.url).pathname;

    if (req.pathname === '/viewAllMovies' && req.method === 'GET') {
        let filePath = path.normalize(
            path.join(__dirname, '../views/viewAll.html'));

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

            let movies = database;
            let content = '';

            for(let movie of database){
                content+=`<div class="movie">
                <a href="/details/${database.indexOf(movie)}">
                <img class="moviePoster" src="${decodeURIComponent(movie.moviePoster)}"/></a>
                </div>`;
            }

            let html = data.toString().replace('{content}', content);

            res.writeHead(200, {
                'Content-Type': 'text/html'
            })

            res.write(html);
            res.end();
        })
    }else{
        return true;
    }
}