function airport(arr) {
    let landed = [];
    let cities = {};

    for (let i = 0; i < arr.length; i++) {
        let tokens = arr[i].split(/\s/);
        let id = tokens[0];
        let city = tokens[1];
        let passangers = Number(tokens[2]);
        let status = tokens[3];

        if (status === 'depart') {
            if (landed.includes(id)) {
                if (!cities.hasOwnProperty(city)) {
                    cities[city] = {
                        arrivals: 0,
                        departures: 0,
                        planes: new Set()
                    };
                }

                cities[city].departures += passangers;
                landed.splice(landed.indexOf(id), 1);
                cities[city].planes.add(id);
            }
        } else {
            if (!landed.includes(id)) {
                if (!cities.hasOwnProperty(city)) {
                    cities[city] = {
                        arrivals: 0,
                        departures: 0,
                        planes: new Set()
                    };
                }

                cities[city].arrivals += passangers;
                landed.push(id);
                cities[city].planes.add(id);
            }
        }
    }

    console.log("Planes left:");
    landed.sort((a, b) => a.localeCompare(b))
        .forEach(p => console.log('- ' + p));

    let citiesSorted = Object.keys(cities)
        .sort((a, b) => {
            if (cities[b].arrivals - cities[a].arrivals === 0) {
                return a.localeCompare(b);
            } else {
                return cities[b].arrivals - cities[a].arrivals;
            }
        });

    for (let c of citiesSorted) {
        console.log(`${c}\nArrivals: ${cities[c]['arrivals']}\nDepartures: ${cities[c]['departures']}`);
        console.log('Planes:');

        let sortedPlanes = Array.from(cities[c]['planes'])
            .sort((a, b) => a.localeCompare(b))
            .forEach(x => console.log(`-- ${x}`));
    }
}

airport(["RTA72 London -10 land",
    "RTA#72 Brussels -110 depart",
    "RTA7!2 Warshaw 350 land",
    "RTA72 Riga -201 depart",
    "rta72 riga -13 land",
    "rta Riga -200 depart"]
)

// airport([
//         "Airbus Paris 356 land",
//         "Airbus London 321 land",
//         "Airbus Paris 213 depart",
//         "Airbus Ljubljana 250 land"
//     ]
// )