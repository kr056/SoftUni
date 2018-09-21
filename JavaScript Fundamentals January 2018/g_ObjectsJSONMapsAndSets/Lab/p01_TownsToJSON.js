function townsToJSON(arr) {
    let result = [];

    for (let row of arr.slice(1)) {
        let [townName, lat, lng] = row.split(/\s*\|\s*/)
            .filter(x => x !== '');

        let townObj = {
            Town: townName, Latitude: Number(lat),
            Longitude: Number(lng)
        };
        
        result.push(townObj);
    }

    console.log(JSON.stringify(result));
}
townsToJSON(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
)