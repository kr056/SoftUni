const Book = require('../models/Book');

module.exports.addGet = (req, res) => {
    res.render('addBook');
}

module.exports.addPost = (req, res) => {
    let book = req.body;

    let emptyField = false;

    if (book.bookTitle === '' || book.bookPoster === '') {
        emptyField = true;
        res.render('addBook', { emptyField });
        return;
    }

    Book.create(book).then(() => {
        Book.find().then((books) => {
            let bookAdded = true;
            res.render('viewAll', { books, bookAdded });
        })
    });
}

module.exports.viewAll = (req, res) => {
    Book.find().then((books) => {
        res.render('viewAll', { books });
    });
}

module.exports.bookDetails = (req, res) => {
    let bookId = req.params.id;
    Book.findById(bookId).then((book) => {
        res.render('details', { book });
    });
}
