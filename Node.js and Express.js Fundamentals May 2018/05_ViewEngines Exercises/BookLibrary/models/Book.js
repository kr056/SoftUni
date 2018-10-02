const mongoose = require('mongoose');

let bookSchema = mongoose.Schema({
    bookTitle:{type: mongoose.SchemaTypes.String,required:true},
    bookAuthor:{type: mongoose.SchemaTypes.String,required:true},
    bookPoster:{type: mongoose.SchemaTypes.String,required:true},
    bookYear:{type: mongoose.SchemaTypes.Number,required:true},
})

let Book = mongoose.model('Book',bookSchema);

module.exports=Book;