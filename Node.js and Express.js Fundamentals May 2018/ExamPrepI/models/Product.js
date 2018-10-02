const mongoose = require('mongoose');

let productSchema = mongoose.Schema({
    category: {
        type: mongoose.Schema.Types.String, required: true,
    },
    size: {
        type: mongoose.Schema.Types.Number,
        min: [17, 'Size must be between 17 and 24'],
        max: [24, 'Size must be between 17 and 24'],
        required: [true, 'Size is required']
    },
    imageUrl: { type: mongoose.Schema.Types.String, required: [true, 'Image is required!'] },
    toppings: [{
        type: mongoose.Schema.Types.String,
    }]

})


const Product = mongoose.model('Product', productSchema);

module.exports = Product;