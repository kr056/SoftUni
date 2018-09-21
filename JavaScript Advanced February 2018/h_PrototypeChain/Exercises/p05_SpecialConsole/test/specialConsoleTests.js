let expect = require('chai').expect;
let Console = require('../p05_SpecialConsole').Console;

describe('specialConsole tests', function () {
    it('input is str', function () {
        expect(Console.writeLine('ddd')).to.be.equal('ddd');
    })

    it('input is object', function () {
        expect(Console.writeLine({name: 'doni'})).to.be.equal(JSON.stringify({name: 'doni'}));
    })

    it('returns undefined for number input', function () {
        expect(Console.writeLine(5)).to.be.equal(undefined)
    })

    it('throws typeError for first element not a string', function () {
        expect(() => Console.writeLine(5, 10)).to.throw(TypeError);
    })

    it('throws typeError for no elements', function () {
        expect(() => Console.writeLine()).to.throw(TypeError);
    })

    it('throws rangeError for incorrect amount of parameters given', function () {
        let d = '1';
        expect(() => Console.writeLine('Dumbo {0} {1}', d)).to.throw(RangeError);
    })

    it('throws rangeError for incorrect amount of placeholders given', function () {
        let a = '1';
        let b = '1';
        expect(() => Console.writeLine('Dumbo {0} {1} {2}', a, b)).to.throw(RangeError);
    })

    it('should replace placeholders if everything is ok', function () {
        expect(Console.writeLine('{0} {1}', 'This', 'Works')).to.be.equal('This Works')
    })

    it('throws rangeError for invalid placeholder', function () {
        expect(() =>Console.writeLine('This is  {15}', 'this')).to.throw(RangeError);
    })

})