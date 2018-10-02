const homeController = require('./home');
const carController = require('./car');
const userHandler = require('./user');

module.exports = {
    home:homeController,
    car:carController,
    user:userHandler
};
