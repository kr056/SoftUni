function getFibonator() {
    let f0 = 0, f1 = 1;
    let counter = 0;
    return function () {
        if (counter > 0) {
            let f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        counter++;
        
        return f1;
    };
}
let fib = getFibonator();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());