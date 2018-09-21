function add(first) {
    let sum = first;

    function increase(add) {
        sum += add;
        return increase;
    }

    increase.toString = function () {
        return sum;
    };

    return increase;
};
//iife solution
(function () {
    let sum = 0;

    function increase(add) {
        sum += add;
        return increase;
    }

    increase.toString = function () {
        return sum;
    };

    return increase;
})();
console.log(add(1)(2) + '');