const Product = require('mongoose').model('Product');

module.exports.index = (req, res) => {
    Product.find().then((products) => {
        let chickenDoners = products.filter((p) => p.category === 'chicken');
        let beefDoners = products.filter((p) => p.category === 'beef');
        let lambDoners = products.filter((p) => p.category === 'lamb');
        
        res.render('home', { roleAdmin:(req.user && req.user.roles.includes('Admin')),chickenDoners, beefDoners, lambDoners });
    }).catch(err=>{
        console.log(err.message);
    })
}