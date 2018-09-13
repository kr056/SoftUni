function kvp(arr) {
    let map = new Map();

    for (let i = 0; i < arr.length - 1; i++) {
        let tokens = arr[i].split(" ");
        let key = tokens[0];
        let value = tokens[1];
        map[key] = value;
    }

    let searchedKey = arr[arr.length - 1];

    if (map[searchedKey] === undefined) {
        console.log("None");
    }
    else {
        console.log(map[searchedKey]);
    }

}
