function storeCatalogue(arr) {
    let logue = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [product, price] = arr[i].split(/\s*:\s*/);

        if (!logue.has(product[0])) {
            logue.set(product[0], new Map());
        }

        logue.get(product[0]).set(product, price);
    }

    let sorted = Array.from(logue.keys()).sort();

    for (let key of sorted) {
        console.log(key);
        let innerSorted = Array.from(logue.get(key).keys()).sort();

        for (let inner of innerSorted) {
            console.log(' ' + inner + ': ' + logue.get(key).get(inner))
        }

    }
}
storeCatalogue(['Appricot : 20.4', 'Anti-Bug Spray : 15', 'DD : 6'])