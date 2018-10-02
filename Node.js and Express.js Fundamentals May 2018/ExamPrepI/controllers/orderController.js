const Product = require('mongoose').model('Product');
const Order = require('mongoose').model('Order');
const dateFormater = require('../api/dateFormater');

module.exports.orderGet = (req, res) => {
    let productId = req.params.id;

    Product.findById(productId).then((product) => {
        res.render('order/place', { product });
    })
}

module.exports.orderPost = (req, res) => {
    let productId = req.params.id;
    let order = {
        creator: req.user.id,
        product: req.body.product_id,
        toppings: []
    };

    for (let topping in req.body) {
        if (topping !== 'product_id') {
            order.toppings.push(topping);
        }
    }

    Order.create(order).then((order) => {
        Product.findById(order.product).then((product) => {
            res.render('order/details', { product, order });
        })
    })
}


module.exports.orderStatus = (req, res) => {
    if (req.user && req.user.roles.includes('Admin')) {
        let roleAdmin = true;

        Order.find().populate('product').then((orders) => {
            orders.map(o => {
                o.date = dateFormater.formatDate(o.date);
                o.category = o.product.category;
                o.size = o.product.size;
            })

            res.render('order/status', { roleAdmin, orders });

        }).catch(err => {
            console.log(err)
        })
    } else {
        Order.find({ creator: req.user.id }).populate('product').then((orders) => {

            orders.map(o => {
                o.date = dateFormater.formatDate(o.date);
                o.category = o.product.category;
                o.size = o.product.size;
            })

            res.render('order/status', { orders });
        }).catch(err => {
            console.log(err);
        })
    }
}


module.exports.orderDetails = (req, res) => {
    let orderId = req.params.id

    Order.findById(orderId).then((order) => {
        Product.findById(order.product).then((product) => {
            switch (order.status) {
                case 'Pending':
                    order.pending = true;
                    break;
                case 'In Progress':
                    order.progress = true;
                    break;
                case 'In Transit':
                    order.transit = true;
                    break;
                case 'Delivered':
                    order.delivered = true;
                    break;
            }
            res.render('order/details', { product, order })
        })
    })
}

module.exports.changeStatus = (req, res) => {
    let orderId = req.body.order_id;
    let orderStatus = req.body.orderStatus;

        Order.findById(orderId).then((order) => {
            order.status = orderStatus;
            order.save();
        }).catch(err => {
            console.log(err);
        })
    

    res.redirect('/');
}