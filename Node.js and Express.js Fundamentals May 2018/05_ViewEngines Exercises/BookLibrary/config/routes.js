const handlers = require('../handlers');

module.exports = (app) => {
    app.get('/', handlers.home.index);

    app.get('/viewAllBooks',handlers.book.viewAll);

    app.get('/details/book/:id',handlers.book.bookDetails);

    app.get('/addBook',handlers.book.addGet);
    app.post('/addBook',handlers.book.addPost);



}