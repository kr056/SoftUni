function cappyJuice(arr) {
    let data = {};
    let result = new Map();

    for (let i = 0; i < arr.length; i++) {
        let [juice, quantity] = arr[i].split(/\s*=>\s*/);

        if (data.hasOwnProperty(juice)) {
            data[juice] = data[juice] + Number(quantity);
        } else {
            data[juice] = Number(quantity);
        }

        if (data[juice] >= 1000) {
            let bottles = Math.floor(data[juice] / 1000);
            data[juice] = data[juice] % 1000;

            if (result.has(juice)) {
                result.set(juice, result.get(juice) + bottles);
            } else {
                result.set(juice, bottles);
            }
        }
    }

    for (let [key, value] of result) {
        console.log(`${key} => ${value}`);
    }
}
cappyJuice(['Kiwi => 100', 'Pear => 2345', 'Kiwi => 3000'])