function calcDistance(input) {
    let distA = (input[0] * 1000) / 3600 * input[2];
    let distB = (input[1] * 1000) / 3600 * input[2];

    console.log(Math.abs(distA - distB));
}

calcDistance([0, 60, 3600])
calcDistance([11, 10, 120])
calcDistance([5, -5, 40])