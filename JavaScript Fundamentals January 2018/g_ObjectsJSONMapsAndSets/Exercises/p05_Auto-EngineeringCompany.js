function carCatalogue(arr) {
    let louge = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [brand, model, quantity] = arr[i].split(' \| ');
        quantity = Number(quantity);

        if (!louge.has(brand)) {
            louge.set(brand, new Map());
        }

        let oldQuantity = louge.get(brand).get(model);

        if (oldQuantity) {
            quantity += oldQuantity;
        }

        louge.get(brand).set(model, quantity);
    }
    for (let [key, innerMap] of louge) {
        console.log(key);

        for (let [model, quantity] of innerMap) {
            console.log(`###${model} -> ${quantity}`)
        }
    }
}
carCatalogue(['Audi | Q7 | 1000', 'Audi | Q6 | 12000'])