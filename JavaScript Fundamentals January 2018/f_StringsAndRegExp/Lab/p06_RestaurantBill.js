function calcBill(arr) {
    let orders = [];
    let totalSum = 0;

    for (let i = 0; i < arr.length; i += 2) {
        orders.push(arr[i]);
        totalSum += Number(arr[i + 1]);
    }

    console.log(`You purchased ${orders.join(', ')} for a total sum of ${totalSum}`);
}

calcBill(['Cola', '1.35', 'Pancakes', '2.88'])