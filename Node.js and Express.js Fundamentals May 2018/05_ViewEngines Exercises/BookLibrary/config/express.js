const express = require('express');
const path = require('path');
const multer = require('multer');
const handlebars = require('express-handlebars');

module.exports = (app, config) => {
    app.engine('.hbs', handlebars({
        extname: '.hbs'
    }));

    app.set('view engine', '.hbs');

    app.use(multer({dest:'static/images'}).array());

    app.use((req, res, next) => {
        if (req.url.startsWith('/static')) {
            req.url = req.url.replace('/static', '')
        }

        next()
    }, express.static(
        path.normalize(
            path.join(__dirname, '../static'))));
}