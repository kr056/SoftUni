const homeController = require('./homeController');
const articleController = require('./articleController');
const editController = require('./editController');
const userController = require('./userController');

module.exports = {
    home:homeController,
    article:articleController,
    edit:editController,
    user:userController
};
