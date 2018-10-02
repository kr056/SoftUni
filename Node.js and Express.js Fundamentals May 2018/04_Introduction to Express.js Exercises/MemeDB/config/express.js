const express = require('express')
const path = require('path')
const multer = require('multer')
const handlebars = require('express-handlebars')

module.exports = (app, config) => {
    app.engine('.hbs', handlebars({
        extname: '.hbs'
    }))

    app.set('view engine', '.hbs')

    app.use(multer({dest:'public/images'}).single('image'));

    app.use((req, res, next) => {
        if (req.url.startsWith('/public')) {
            req.url = req.url.replace('/public', '');
        }

        next()
    }, express.static(
        path.normalize(
            path.join(__dirname, '../public'))))
}