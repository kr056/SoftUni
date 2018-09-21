function sumByTown(arr) {
    let objArr = [];
    let info = {};

    for (let i = 0; i < arr.length; i += 2) {
        let town = arr[i];
        let income = Number(arr[i + 1]);

        if (info.hasOwnProperty(town)) {
            info[town] = info[town] + income;
        } else {
            info[town] = income;
        }

    }

    console.log(JSON.stringify(info));
}
sumByTown(['Sofia', 20, 'Sofia', 50, 'Burgar', '11'])