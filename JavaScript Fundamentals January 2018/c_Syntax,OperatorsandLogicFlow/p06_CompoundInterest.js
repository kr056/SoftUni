function calcInterest(str) {
    let p = str[0];
    let i = str[1];
    let n = str[2];
    let t = str[3];

    let result = p *
        Math.pow(1 + i / (100 * (12 / n)), 12 / n * t);
    console.log(result.toFixed(2));
}

calcInterest([1500, 4.3, 3, 6])
calcInterest([100000, 5, 12, 25])