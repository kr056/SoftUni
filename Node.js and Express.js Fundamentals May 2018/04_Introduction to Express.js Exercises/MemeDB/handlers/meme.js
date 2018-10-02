const Genre = require('../models/Genre');
const Meme = require('../models/Meme');

module.exports.addGet = (req, res) => {
  Genre.find().then((genres) => {
    res.render('addMeme', { genres: genres });
  })
}

module.exports.addPost = (req, res) => {
  let meme = req.body;
  
  meme.image = '\\' + req.file.path;
  meme.status = (req.body.status === 'on') ? true : false;

  Meme.create(meme).then((meme) => {
    Genre.findById(meme.genre).then(genre => {
      genre.memeList.push(meme._id);
      genre.save();

      res.redirect('/');
    })
  })
}

module.exports.viewAll = (req, res) => {
  Meme.find().then((memes) => {
    res.render('viewAll', { memes: memes })
  })
}

module.exports.memeDetails = (req, res) => {
  let id = req.params.id;

  Meme.findById(id).then((meme) => {
    Genre.findById(meme.genre).then((genre) => {
      res.render('details', { meme: meme, genre: genre })
    })
  })
}

module.exports.searchGet = (req, res) => {
  Genre.find().then((genres) => {
    res.render('searchMeme', { genres: genres })
  })
}

module.exports.searchPost = (req, res) => {
  if (req.body.memeTitle !== '') {
    Meme.findOne({ memeTitle: req.body.memeTitle }).then((meme) => {
      res.render('details', { meme: meme })
    })

  }
}
