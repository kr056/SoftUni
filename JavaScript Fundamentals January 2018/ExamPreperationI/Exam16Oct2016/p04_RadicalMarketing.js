function radicalMarketing(arr) {
    let mainMap = new Map();
    let subscribedTo = new Map();

    for (let i = 0; i < arr.length; i++) {
        let tokens = arr[i].split('-');

        if (tokens.length > 1) {
            let a = tokens[0];
            let b = tokens[1];

            if (mainMap.has(a) && a !== b && mainMap.has(b)) {
                if (mainMap[a] !== a) {
                    mainMap.get(b).push(a)
                    subscribedTo.get(a).push(b);
                }
            }
        } else {
            mainMap.set(tokens[0], []);
            subscribedTo.set(tokens[0], []);
        }
    }

    let winner = Array.from(mainMap.keys()).sort((a, b) => {
        let comp1 = mainMap.get(b).length - mainMap.get(a).length;

        if (comp1 === 0) {
            let comp2 = subscribedTo.get(b).length - subscribedTo.get(a).length;
            return comp2;
        } else {
            return comp1;
        }
    })[0];

    console.log(winner);

    let count = 0;
    mainMap.get(winner)
        .forEach(x => console.log(`${++count}. ${x}`))
}

radicalMarketing(['A', 'B', 'C', 'D', 'A-B', 'D-B', 'A-C', 'D-C', 'C-A'])