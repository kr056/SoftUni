const handlers = require('../handlers')
module.exports = (app) => {
    app.get('/',handlers.home.index);

    app.get('/viewAllMemes',handlers.meme.viewAll);

    app.get('/meme/details/:id',handlers.meme.memeDetails);

    app.get('/addGenre',handlers.genre.addGet);
    app.post('/addGenre',handlers.genre.addPost);

    app.get('/addMeme',handlers.meme.addGet);
    app.post('/addMeme',handlers.meme.addPost);

    
    app.get('/searchMeme',handlers.meme.searchGet);
    app.post('/searchMeme',handlers.meme.searchPost);


}