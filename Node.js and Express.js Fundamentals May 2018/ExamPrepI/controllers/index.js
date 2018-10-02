const homeController = require('./homeController');
const productController = require('./productController');
const orderController = require('./orderController');
const userController = require('./userController');

module.exports = {
    home: homeController,
    product: productController,
    order: orderController,
    user: userController
};
