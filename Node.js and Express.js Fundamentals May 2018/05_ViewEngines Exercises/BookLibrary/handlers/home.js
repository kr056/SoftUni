const Book = require('../models/Book');

module.exports.index = (req,res) => {
    Book.find().then((books)=>{
        let bookCount=books.length ;
        let bookForm = (bookCount===1) ? 'book':'books';
        let isForm = (bookCount===1) ? 'is':'are';
    
        res.render('index',{bookCount,bookForm,isForm});
    })
}