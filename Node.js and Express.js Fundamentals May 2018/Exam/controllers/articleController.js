let Article = require('mongoose').model('Article');
let Edit = require('mongoose').model('Edit');

module.exports.createGet = (req, res) => {
    res.render('article/create');
}

module.exports.createPost = (req, res) => {

    let article = {
        title: req.body.title,
        edits: []
    }

    if (article.title === '') {
        res.render('article/create', { error: 'Article title is required!' });

        return;
    }


    Article.create(article).then((article) => {
        let edit = {
            author: req.user.username,
            content: req.body.content,
            article: article._id
        }


        Edit.create(edit).then((edit) => {

            article.edits.push(edit._id);
            article.save();

            res.redirect('/');

        }).catch(error => {
            console.log(err);
        })

    }).catch(error => {
        coonsole.log(err);
    })

}

module.exports.viewAllArticles = (req, res) => {
    Article.find().sort({ title: 'asc' }).then((articles) => {
        res.render('article/viewAll', { articles });
    })
}

module.exports.articleDetails = (req, res) => {
    let articleId = req.params.id;

    Article.findById(articleId).then((article) => {
        let editId = article.edits[article.edits.length - 1];

        Edit.findById(editId).then((edit) => {
            res.render('article/details', { article, edit });
        })
    })
}

module.exports.editGet = (req, res) => {
    let articleId = req.params.id

    Article.findById(articleId).then((article) => {
        if (article.lockedStatus === 'true') {
            if (req.user && req.user.roles.includes('Admin')) {
                let editId = article.edits[article.edits.length - 1];

                Edit.findById(editId).then((edit) => {
                    res.render('article/edit', { article, edit });
                })
            } else {
                res.redirect('/');
            }
        } else {
            let editId = article.edits[article.edits.length - 1];

            Edit.findById(editId).then((edit) => {
                res.render('article/edit', { article, edit });
            })
        }

    })
}

module.exports.editPost = (req, res) => {
    let articleId = req.params.id;

    Article.findById(articleId).then((article) => {
        if (article.lockedStatus === 'true') {
            if (req.user && req.user.roles.includes('Admin')) {
                let edit = {
                    author: req.user.username,
                    content: req.body.content,
                    articleId: articleId
                }

                Edit.create(edit).then((edit) => {
                    article.edits.push(edit._id);
                    article.save();

                    res.redirect('/');
                })
            } else {
                res.redirect('/');
            }
        } else {
            let edit = {
                author: req.user.username,
                content: req.body.content,
                articleId: articleId
            }

            Edit.create(edit).then((edit) => {
                article.edits.push(edit._id);
                article.save();

                res.redirect('/');
            })
        }
    })
}

module.exports.articleLock = (req, res) => {
    let articleId = req.params.id;

    Article.findById(articleId).then((article) => {
        article.lockedStatus = true;
        article.save();

        res.redirect('/');
    })
}

module.exports.articleUnlock = (req, res) => {
    let articleId = req.params.id;

    Article.findById(articleId).then((article) => {
        article.lockedStatus = false;
        article.save();

        res.redirect('/');
    })
}

module.exports.articleHistory = (req, res) => {
    let articleId = req.params.id;

    Article.findById(articleId).populate({ path: 'edits', options: { sort: { creationDate: -1 } } })
        .then((article) => {
            let edits = article.edits;

            res.render('article/history', { edits });
        })
}

module.exports.articleLatest = (req, res) => {
    Article.find().populate('edits').sort({ dateCreated: -1 }).limit(1).then((articles) => {
        if (articles.length > 0) {
            let article = articles[0];

            let edit = article.edits[article.edits.length - 1];

            res.render('article/details', { article, edit });
        } else {
            res.redirect('/');
        }
    })
}

module.exports.search = (req, res) => {
    let searchWord = req.body.searchField;

    Article.find().then((articles) => {
        let filteredArticles=articles.filter((a)=>a.title.includes(searchWord));
        res.render('article/search',{searchWord,articles:filteredArticles});
    })

}
