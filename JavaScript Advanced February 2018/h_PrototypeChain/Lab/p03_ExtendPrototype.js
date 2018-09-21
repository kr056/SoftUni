function extendClass(classToExtend) {
    classToExtend.prototype.species = 'Human';
    classToExtend.prototype.toSpeciesString = function () {
        return `I am a ${this.species}. ${this.toString()}`;
    }
}

class Person {
    constructor(name) {
        this.name = name;
    }
}

extendClass(Person);
let d = new Person('doni');
console.log(d.toSpeciesString());
