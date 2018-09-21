let result = (function vectorMath() {
    return {
        add: (vec1, vec2) => {
            let result = [];
            result[0] = vec1[0] + vec2[0];
            result[1] = vec1[1] + vec2[1];
            return result;
        },
        multiply: (vec, scalar) => {
            let result = [];
            result[0] = vec[0] * scalar;
            result[1] = vec[1] * scalar;
            return result;
        },
        length: (vec) => {
            return Math.sqrt((vec[0] * vec[0]) + (vec[1] * vec[1]));
        },
        dot: (vec1, vec2) => {
            return (vec1[0] * vec2[0]) + (vec1[1] * vec2[1]);
        },
        cross: (vec1, vec2) => {
            return (vec1[0] * vec2[1]) - (vec1[1] * vec2[0]);
        }
    };
})();
console.log(result.add([1, 1], [2, 0]));
console.log(result.cross([1, 1], [2, 0]));
console.log(result.dot([1, 1], [2, 0]));