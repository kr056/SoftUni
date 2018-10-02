const mongoose = require('mongoose');

let carSchema = mongoose.Schema({
    make: { type: mongoose.Schema.Types.String, required: true },
    model: { type: mongoose.Schema.Types.String, required: true },
    color: { type: mongoose.Schema.Types.String },
    price: {
        type: mongoose.Schema.Types.Number,
        min: 0,
        max: Number.MAX_VALUE,
        default: 0,
        required: true
    },
    imageUrl: { type: mongoose.Schema.Types.String, required: true },
    // creator: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
    renter: { type: mongoose.Schema.Types.ObjectId, ref: 'User' },
    duration:{type:mongoose.Schema.Types.Number}
})

let Car = mongoose.model('Car', carSchema);

module.exports = Car;