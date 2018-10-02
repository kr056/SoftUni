const mongoose = require('mongoose');

let editSchema = mongoose.Schema({
 author:{type:mongoose.Schema.Types.String},
 creationDate:{type:mongoose.Schema.Types.Date,default:Date.now},
 content:{type:mongoose.Schema.Types.String},
 article:{type:mongoose.Schema.Types.ObjectId,ref:'Article'}
});

const Edit = mongoose.model('Edit', editSchema);

module.exports = Edit;