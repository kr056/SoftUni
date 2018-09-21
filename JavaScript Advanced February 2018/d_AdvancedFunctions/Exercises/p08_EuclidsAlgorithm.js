function getDivisor(num1, num2) {
    let bigger = Math.max(num1, num2);
    let smaller = Math.min(num1, num2)
    for (let i = smaller; i >= 0; i--) {
        if (bigger % i === 0 && smaller % i === 0) {
            return i;
        }
    }
}
// recursive solution Euclids Algorithm
function euclidsAlgorithm(a, b) {
    return b == 0 ? a : euclidsAlgorithm(b, a % b);
}

console.log(getDivisor(555, 231));