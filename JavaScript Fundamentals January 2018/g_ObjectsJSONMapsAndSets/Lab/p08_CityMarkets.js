function cityMarkets(arr) {
    let data = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [town, product, quantityPrice] = arr[i].split(/\s*->\s*/)
            .filter(s => s !== '');

        let [quantity, price] = quantityPrice.split(/\s*:\s*/);

        if (!data.has(town)) {
            data.set(town, new Map());
        }

        let income = quantity * price;
        let oldIncome = data.get(town).get(product);

        if (oldIncome) {
            income += oldIncome;
        }

        data.get(town).set(product, income);
    }

    for (let [key, value] of data) {
        console.log(`Town - ${key}`);

        for (let [prod, income] of value) {
            console.log(`$$$${prod} : ${income}`);
        }
    }
}
cityMarkets(['Sofia -> Laptops HP -> 200 : 2000', 'Sofia -> Audi Q7 -> 200 : 100000'])