function aggregateTable(arr) {
    let towns = [];
    let totalIncome = 0;

    for (let i = 0; i < arr.length; i++) {
        let line = arr[i].split('|').filter(x => x !== '');
        towns.push(line[0].trim());
        totalIncome += Number(line[1]);
    }

    console.log(towns.join(', '))
    console.log(totalIncome);
}
aggregateTable(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
)