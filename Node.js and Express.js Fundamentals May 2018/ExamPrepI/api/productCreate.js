let allowedToppings = ['pickle', 'tomato', 'onion', 'lettuce', 'hot sauce', 'extra sauce'];

function createProduct(data) {
   return  product = {
        category: data.category,
        size: Number(data.size),
        imageUrl: data.imageUrl,
        toppings: data.toppings.split(',').filter(product => allowedToppings.includes(product))
    };
}

module.exports = {
    createProduct
}