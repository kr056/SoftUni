let createE = (function extensibleClass() {
    let id = 0;
    return class Extensible {
        constructor() {
            this.id = id++;
        }

        extend(template) {
            for (let parentProp of Object.keys(template)) {
                if (typeof template[parentProp] === 'function') {
                    Object.getPrototypeOf(this)[parentProp] = template[parentProp];
                } else {
                    this[parentProp] = template[parentProp];
                }
            }
        }
    };
})();
let obj1 = new createE();
let obj2 = new createE();
let obj3 = new createE();
console.log(obj1.id);
console.log(obj2.id);
console.log(obj3.id);