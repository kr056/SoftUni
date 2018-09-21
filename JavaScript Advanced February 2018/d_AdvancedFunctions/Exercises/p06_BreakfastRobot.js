let result = function () {
    let ingredients = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    };

    return function commandProcessor(input) {
        let tokens = input.split(' ');

        switch (tokens[0]) {
            case 'prepare':
                let dish = tokens[1];
                let quantity = Number(tokens[2]);

                return prepare(dish, quantity);
            case 'restock':
                let element = tokens[1];
                let restockQuantity = Number(tokens[2]);
                
                return restock(element, restockQuantity);
            case 'report':
                return report();
        }

        function restock(element, restockQuantity) {
            ingredients[element] += restockQuantity;
            return "Success";
        }

        function report() {
            return `protein=${ingredients.protein} carbohydrate=${ingredients.carbohydrate} fat=${ingredients.fat} flavour=${ingredients.flavour}`;
        }

        function prepare(dish, quantity) {
            let output = '';
            switch (dish) {
                case 'apple':
                    if (quantity > ingredients.carbohydrate) {
                        output = 'Error: not enough carbohydrate in stock';
                    } else if (quantity * 2 > ingredients.flavour) {
                        output = 'Error: not enough flavour in stock';
                    } else {
                        ingredients.carbohydrate -= quantity;
                        ingredients.flavour -= (quantity * 2);
                        output = 'Success';
                    }
                    return output;
                case 'coke':
                    if (quantity * 10 > ingredients.carbohydrate) {
                        output = 'Error: not enough carbohydrate in stock';
                    } else if (quantity * 20 > ingredients.flavour) {
                        output = 'Error: not enough flavour in stock';
                    } else {
                        ingredients.carbohydrate -= (quantity * 10);
                        ingredients.flavour -= (quantity * 20);
                        output = 'Success';
                    }
                    return output;
                case 'burger':
                    if (quantity * 5 > ingredients.carbohydrate) {
                        output = 'Error: not enough carbohydrate in stock';
                    } else if (quantity * 7 > ingredients.fat) {
                        output = 'Error: not enough fat in stock';
                    } else if (quantity * 3 > ingredients.flavour) {
                        output = 'Error: not enough flavour in stock';
                    } else {
                        ingredients.carbohydrate -= (quantity * 5);
                        ingredients.fat -= (quantity * 7);
                        ingredients.flavour -= (quantity * 3);
                        output = 'Success';
                    }
                    return output;
                case 'omelet':
                    if (quantity * 5 > ingredients.protein) {
                        output = 'Error: not enough protein in stock';
                    } else if (quantity > ingredients.fat) {
                        output = 'Error: not enough fat in stock';
                    } else if (quantity > ingredients.flavour) {
                        output = 'Error: not enough flavour in stock';
                    } else {
                        ingredients.protein -= (quantity * 5);
                        ingredients.fat -= (quantity);
                        ingredients.flavour -= (quantity);
                        output = 'Success';
                    }
                    return output;
                case 'cheverme':
                    if (quantity * 10 > ingredients.protein) {
                        output = 'Error: not enough protein in stock';
                    } else if (quantity * 10 > ingredients.carbohydrate) {
                        output = 'Error: not enough carbohydrate in stock';
                    } else if (quantity * 10 > ingredients.fat) {
                        output = 'Error: not enough fat in stock';
                    } else if (quantity * 10 > ingredients.flavour) {
                        output = 'Error: not enough flavour in stock';
                    } else {
                        ingredients.protein -= (quantity * 10);
                        ingredients.carbohydrate -= (quantity * 10);
                        ingredients.fat -= (quantity * 10);
                        ingredients.flavour -= (quantity * 10);
                        output = 'Success';
                    }
                    return output;
            }
        }
    }
};
console.log(result()('report'));
