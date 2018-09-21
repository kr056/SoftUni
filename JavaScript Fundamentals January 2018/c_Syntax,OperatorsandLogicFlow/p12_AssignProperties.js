function assign(tokens) {
    let [propA, propB, propC] = [tokens[0], tokens[2], tokens[4]];
    let [valA, valB, valC] = [tokens[1], tokens[3], tokens[5]];
    let obj = {};

    obj[propA] = valA;
    obj[propB] = valB;
    obj[propC] = valC;

    return obj;
}

console.log(assign(['name', 'Pesho', 'age', '23', 'gender', 'male']))