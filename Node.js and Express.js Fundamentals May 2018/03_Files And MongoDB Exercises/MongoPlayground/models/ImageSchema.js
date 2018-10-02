const mongoose = require('mongoose');

let imageSchema = mongoose.Schema({
    url:{type: mongoose.SchemaTypes.String,required:true},
    creationDate:{type: mongoose.SchemaTypes.Date,required:true,default:Date.now},
    description:{type: mongoose.SchemaTypes.String,required:true},
    tags: [{type:mongoose.SchemaTypes.ObjectId}]
})

let Image = mongoose.model('Image',imageSchema);

module.exports=Image;