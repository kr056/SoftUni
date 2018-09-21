function lowestPriceInCities(arr) {
    let info = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [town, product, price] = arr[i].split(/\s*\|\s*/);
        price = Number(price);

        if (!info.has(product)) {
            info.set(product, new Map());
        }

        info.get(product).set(town, price);
    }

    for (let [key, value] of info) {
        let minPrice = Number.POSITIVE_INFINITY;
        let minTown = '';

        for (let [town, price] of value) {
            if (price < minPrice) {
                minPrice = price;
                minTown = town;
            }
        }

        console.log(`${key} -> ${minPrice} (${minTown})`);
    }
}
lowestPriceInCities(['New York | Sample Product | 1000', 'New York | Orange | 99.1', 'New York | Sample Product | 5'])