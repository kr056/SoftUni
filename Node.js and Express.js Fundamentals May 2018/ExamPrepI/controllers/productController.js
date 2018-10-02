const Product = require('mongoose').model('Product');
const api = require('../api/productCreate');

module.exports.createGet = (req, res) => {
    res.render('product/create');
}

module.exports.createPost = (req, res) => {
    let product = api.createProduct(req.body);

    Product.create(product).then((product)=>{
        res.redirect('/');
    }).catch((err)=>{
        let error = err.message;
        res.render('product/create',{error});
    })
}