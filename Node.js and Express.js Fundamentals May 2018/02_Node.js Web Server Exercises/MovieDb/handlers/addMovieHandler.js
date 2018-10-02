const url = require('url');
const database = require('../config/dataBase');
const fs = require('fs');
const path = require('path');
const qs = require('querystring');
const multiparty = require('multiparty');

const errorMessage = '<div id="errBox"><h2 id="errMsg">Please fill all fields</h2></div>';
const successMessage = '<div id="succssesBox"><h2 id="succssesMsg">Movie added</h2></div>';

module.exports = (req, res) => {
    req.pathname = req.pathname || url.parse(req.url).pathname;

    if (req.pathname === '/addMovie' && req.method === 'GET') {
        let filePath = path.normalize(path.join(__dirname, '../views/addMovie.html'));

        fs.readFile(filePath, (err, data) => {
            if (err) {
                console.log(err);
                return;
            }

            res.writeHead(200,
                {
                    'Content-Type': 'text/html'
                });

            res.write(data);
            res.end();

        });
    } else if (req.pathname === '/addMovie' && req.method === 'POST') {
        let form = new multiparty.Form();

        let movie = {};

        form.on('error', function (err) {
            console.log(err);
        })

        form.on('part', function (part) {
            part.setEncoding('utf-8');
            let field = '';

            part.on('data', (data) => {
                field += data;
            });

            part.on('end', function () {
                movie[part.name] = field;
            })
        })

        let validMovie = true;

        form.on('close', () => {
            for (let key in movie) {
                if (movie[key] === '') {
                    validMovie = false;
                    break;
                }
            }
        })

        fs.readFile('./views/addMovie.html', (err, data) => {
            if (err) {
                console.log(err);
                return;
            }
            
            if (validMovie) {
                database.push(movie);
                data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', successMessage);
                console.log(data);
            } else {
                data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', errorMessage);
            }

            res.writeHead(200,
                {
                    'Content-Type': 'text/html'
                });

            res.write(data);
            res.end();
        })

        form.parse(req);
    }
    else {
        return true;
    }
}
