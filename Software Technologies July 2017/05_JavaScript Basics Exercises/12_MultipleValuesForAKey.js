function solve(arr) {

    let map = new Map();

    for (let i = 0; i < arr.length - 1; i++) {
        let tokens = arr[i].split(" ");
        let key = tokens[0];

        map[key] = map[key] || [];
        map[key].push(tokens[1]);
    }

    let searchedKey = arr[arr.length - 1];

    if (map[searchedKey] === undefined) {
        console.log("None");
    }
    else {
        for (let item of map[searchedKey]) {
            console.log(item);
        }
    }
}