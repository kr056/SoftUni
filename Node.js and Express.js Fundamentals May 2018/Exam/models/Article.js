const mongoose = require('mongoose');

let articleSchema = mongoose.Schema({
 title:{type:mongoose.Schema.Types.String,required:[true,'Article must have a title!']},
 dateCreated:{type:mongoose.Schema.Types.Date,default:Date.now},
 lockedStatus:{type:mongoose.Schema.Types.String,default:'false'},
 edits:[{type:mongoose.Schema.Types.ObjectId,ref:'Edit'}]
});

const Article = mongoose.model('Article', articleSchema);

module.exports = Article;