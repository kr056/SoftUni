const mongoose = require('mongoose');

let orderSchema = mongoose.Schema({
    creator: { type: mongoose.Schema.Types.ObjectId, ref: 'User' },
    product: { type: mongoose.Schema.Types.ObjectId, ref: 'Product' },
    date: { type: mongoose.Schema.Types.Date, default: Date.now },
    toppings: [{ type: mongoose.Schema.Types.String }],
    status: { type: mongoose.Schema.Types.String, default: 'Pending', enums: ['Pending', 'In Progress', 'In Transit', 'Delivered'] }
})

const Order = mongoose.model('Order', orderSchema);

module.exports = Order;