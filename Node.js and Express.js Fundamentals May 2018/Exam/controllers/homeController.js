let Article = require('mongoose').model('Article');
let Edit = require('mongoose').model('Edit');

module.exports.index = (req, res) => {

    Article.find().populate('edits').sort({ dateCreated: -1 }).limit(3).then((articles) => {
        if (articles.length > 0) {
            let recentArticle = articles[0];

            let recentContent = recentArticle.edits[recentArticle.edits.length - 1].content;
            recentContent=recentContent.substring(0,50);
            
            res.render('index', { recentArticle, recentContent, articles });
        } else {
            res.render('index');
        }

    })

}