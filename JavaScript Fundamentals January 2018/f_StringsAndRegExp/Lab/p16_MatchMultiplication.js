function multiplyExpression(str) {
    let pat = /([0-9\-]*)\s*\*\s*([0-9\-.]*)/g;
    str = str.replace(pat, (m, a, b) => Number(a) * Number(b));
    console.log(str);
}
multiplyExpression('My bill: 2*2.50 (beer); 2* 1.20 (kepab); -2  * 0.5 (deposit).')