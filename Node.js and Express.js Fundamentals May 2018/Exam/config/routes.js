const controllers = require('../controllers');
const multer = require('multer');
const auth = require('./auth');

// const upload = multer({dest: 'uploads/'})

module.exports = (app) => {
  app.get('/', controllers.home.index);
  app.get('/index.html', controllers.home.index);

  app.get('/users/register', controllers.user.registerGet);
  app.post('/users/register', controllers.user.registerPost);

  app.get('/users/login', controllers.user.loginGet);
  app.post('/users/login', controllers.user.loginPost);

  app.post('/users/logout', controllers.user.logout);

  app.get('/article/create', auth.isAuthenticated, controllers.article.createGet);
  app.post('/article/create', auth.isAuthenticated, controllers.article.createPost);


  app.get('/article/edit/:id', auth.isAuthenticated, controllers.article.editGet);
  app.post('/article/edit/:id', auth.isAuthenticated, controllers.article.editPost);

  app.get('/article/viewAll', controllers.article.viewAllArticles);

  app.post('/article/search',controllers.article.search);

  app.get('/article/latest', controllers.article.articleLatest);

  app.get('/article/details/:id', controllers.article.articleDetails);

  app.get('/article/history/:id', auth.isAuthenticated, controllers.article.articleHistory);

  app.get('/article/selectedEdit/:id', controllers.edit.selectedEdit);

  app.get('/article/lock/:id', auth.isInRole('Admin'), controllers.article.articleLock);

  app.get('/article/unlock/:id', auth.isInRole('Admin'), controllers.article.articleUnlock);


  app.all('*', (req, res) => {
    res.status(404);
    res.send('404 Not Found');
    res.end();
  })

}