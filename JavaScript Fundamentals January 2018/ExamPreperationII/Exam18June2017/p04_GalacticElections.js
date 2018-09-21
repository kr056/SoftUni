function galacticElection(arr) {
    //storing input
    let result = {};

    for (let obj of arr) {
        let system = obj['system'];
        let candidate = obj['candidate'];
        let votes = obj['votes'];

        if (result.hasOwnProperty(system)) {
            if (result[system].hasOwnProperty(candidate)) {
                result[system][candidate] += votes;
            } else {
                result[system][candidate] = votes;
            }
        } else {
            result[system] = {};
            result[system][candidate] = votes;
        }
    }

    //getting winners
    let totalSum = 0;

    for (let key in result) {
        let winner = Object.keys(result[key])
            .sort((a, b) => result[key][b] - result[key][a])[0];

        let sum = 0;

        for (let innerKey in result[key]) {
            sum += result[key][innerKey];
        }

        totalSum += sum;
        result[key] = {};
        result[key]['candidate'] = winner;
        result[key]['votes'] = sum;
    }

    let players = {};

    for (let key in result) {
        if (players.hasOwnProperty(result[key]['candidate'])) {
            players[result[key]['candidate']] += result[key]['votes'];
        } else {
            players[result[key]['candidate']] = result[key]['votes'];
        }
    }

    let sortedPlayers = Object.keys(players).sort((a, b) => players[b] - players[a]);
    let sortedVotes = Object.values(players).sort((a, b) => b - a)
        .map(a => Math.floor(a / totalSum * 100));

    let sortedSystems = Object.keys(result).sort((a, b) => result[b]['votes'] - result[a]['votes']);

    if (sortedVotes[0] > 50) {
        if (sortedVotes[0] === 100) {
            console.log(`${sortedPlayers[0]} wins with ${players[sortedPlayers[0]]} votes
${sortedPlayers[0]} wins unopposed!
`)
        } else {
            console.log(`${sortedPlayers[0]} wins with ${players[sortedPlayers[0]]} votes
Runner up: ${sortedPlayers[1]}`)
            sortedSystems.filter(x => result[x]['candidate'] === sortedPlayers[1])
                .forEach(p => console.log(p + ": " + result[p]['votes']));
        }
    } else {
        console.log(`Runoff between ${sortedPlayers[0]} with ${sortedVotes[0]}% and ${sortedPlayers[1]} with ${sortedVotes[1]}%`)
    }
}

galacticElection([{ system: 'Theta', candidate: 'Flying Shrimp', votes: 10 },
{ system: 'Sigma', candidate: 'Space Cow', votes: 200 },
{ system: 'Sigma', candidate: 'Flying Shrimp', votes: 120 },
{ system: 'Tau', candidate: 'Space Cow', votes: 15 },
{ system: 'Sigma', candidate: 'Space Cow', votes: 60 },
{ system: 'Tau', candidate: 'Flying Shrimp', votes: 150 }]
)