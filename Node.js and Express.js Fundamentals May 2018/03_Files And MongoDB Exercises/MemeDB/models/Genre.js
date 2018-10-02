const mongoose = require('mongoose');

let genreSchema = mongoose.Schema({
    genreName: { type: mongoose.SchemaTypes.String, required: true },
    memeList: [{ type: mongoose.SchemaTypes.ObjectId, ref: 'Meme' }]
})

let Genre = mongoose.model('Genre', genreSchema);

module.exports = Genre;