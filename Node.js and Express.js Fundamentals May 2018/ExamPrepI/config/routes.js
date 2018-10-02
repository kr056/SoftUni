const controllers = require('../controllers');
const multer = require('multer');
const auth = require('./auth');

module.exports = (app) => {
    app.get('/', controllers.home.index);
    app.get('/index.html', controllers.home.index);

    app.get('/users/register', controllers.user.registerGet);
    app.post('/users/register', controllers.user.registerPost);

    app.get('/users/login', controllers.user.loginGet);
    app.post('/users/login', controllers.user.loginPost);

    app.post('/users/logout', controllers.user.logout);

    app.get('/product/create', auth.isInRole('Admin'), controllers.product.createGet);
    app.post('/product/create', auth.isInRole('Admin'), controllers.product.createPost);

    app.get('/order/place/:id', auth.isAuthenticated, controllers.order.orderGet);
    app.post('/order/place', auth.isAuthenticated, controllers.order.orderPost);

    app.get('/order/order-status', auth.isAuthenticated, controllers.order.orderStatus);

    app.get('/order/details/:id', auth.isAuthenticated, controllers.order.orderDetails);

    app.post('/order/status-change', auth.isInRole('Admin'), controllers.order.changeStatus);

    app.all('*', (req, res) => {
        res.status(404)
        res.send('404 Not Found')
        res.end()
    })



}