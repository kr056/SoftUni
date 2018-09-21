function populationInTowns(arr) {
    let data = {};
    
    for (let i = 0; i < arr.length; i++) {
        let line = arr[i].split(' <-> ').filter(x => x !== '');

        for (let j = 0; j < line.length; j += 2) {
            let town = line[j];
            let population = Number(line[j + 1]);

            if (data.hasOwnProperty(town)) {
                data[town] = data[town] + population;
            } else {
                data[town] = population;
            }
        }
    }

    for (let key in data) {
        console.log(`${key} : ${data[key]}`)
    }
}
populationInTowns([`Sofia <-> 1200`,`Varna <-> 1500`,`Burgas <-> 18200`])