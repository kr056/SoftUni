const controllers = require('../controllers');
const multer = require('multer');
const auth = require('./auth');
// const upload = multer({dest: 'uploads/'})
module.exports = (app) => {
    app.get('/', controllers.home.index);

    app.get('/users/register', controllers.user.registerGet);
    app.post('/users/register', controllers.user.registerPost);

    app.get('/users/login', controllers.user.loginGet);
    app.post('/users/login', controllers.user.loginPost);

    app.post('/users/logout', controllers.user.logout);

    app.get('/cars/all', controllers.car.viewAll);

    app.post('/cars/search', controllers.car.searchByMake);

    app.get('/cars/create', auth.isInRole('Admin'), controllers.car.addGet);
    app.post('/cars/create', auth.isInRole('Admin'), controllers.car.addPost);

    app.get('/cars/edit/:id', auth.isInRole('Admin'), controllers.car.editGet);
    app.post('/cars/edit/:id', auth.isInRole('Admin'), controllers.car.editPost);

    app.get('/cars/rent/:id', auth.isAuthenticated, controllers.car.rentGet);
    app.post('/cars/rent/:id', auth.isAuthenticated, controllers.car.rentPost);

    app.get('/users/profile/me', auth.isAuthenticated, controllers.car.getProfile);

}