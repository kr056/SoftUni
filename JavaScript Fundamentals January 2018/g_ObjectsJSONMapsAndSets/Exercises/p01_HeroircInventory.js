function heroicInventory(arr) {
    let data = [];

    for (let i = 0; i < arr.length; i++) {
        let tokens = arr[i].split(' \/ ');
        let name = tokens[0];
        let level = Number(tokens[1]);
        let items = [];

        if (tokens.length > 2) {
            items = tokens[2].split(', ');
        }

        let hero = {
            name: name,
            level: level,
            items: items
        };

        data.push(hero);
    }
    
    console.log(JSON.stringify(data));
}
heroicInventory(['Isacc / 25 / Apple, GravityGun'])