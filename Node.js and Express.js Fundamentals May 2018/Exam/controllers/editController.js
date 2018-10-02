let Article = require('mongoose').model('Article');
let Edit = require('mongoose').model('Edit');


module.exports.selectedEdit = (req, res) => {
    let editId = req.params.id;

    Edit.findById(editId).then((edit) => {
        Article.findById(edit.article).then((article)=>{
            res.render('article/details',{article,edit});
        })
    })
}