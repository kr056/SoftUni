const mongoose = require('mongoose');

let memeSchema = mongoose.Schema({
    memeTitle:{type: mongoose.SchemaTypes.String,required:true},
    memeDescription:{type: mongoose.SchemaTypes.String,required:true},
    image:{type: mongoose.SchemaTypes.String,required:true},
    genre:{type: mongoose.SchemaTypes.ObjectId,ref:'Genre'},
    status:{type: mongoose.SchemaTypes.Boolean,default:false},
    votes:{type: mongoose.SchemaTypes.Number,default:0},
    dateOfCreation:{type: mongoose.SchemaTypes.Date,required:true,default:Date.now},
})

let Meme = mongoose.model('Meme',memeSchema);

module.exports=Meme;