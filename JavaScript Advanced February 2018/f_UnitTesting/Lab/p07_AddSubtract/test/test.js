let expect = require('chai').expect;
let createCalculator = require('../p07_AddSubtract').createCalculator;

describe('rgbToHex tests', function () {
    let calc;
    beforeEach(function () {
        calc = createCalculator();
    });

    it('should return 11 after {add:5,add:6}', function () {
        calc.add(5);
        calc.add(6);
        let value = calc.get();
        expect(value).to.be.equal(11);
    });

    it("should return 2 after add(10); subtract('7'); add('-2'); subtract(-1)", function () {
        calc.add(10);
        calc.subtract('7');
        calc.add('-2');
        calc.subtract(-1);
        let value = calc.get();
        expect(value).to.be.equal(2);
    });

    it('should return 11.5 after {add:5.2,add:6.3}', function () {
        calc.add(5.2);
        calc.add(6.3);
        let value = calc.get();
        expect(value).to.be.equal(11.5);
    });

    it('should return 15 after {add:21,subtract:6}', function () {
        calc.add(21);
        calc.subtract(6);
        let value = calc.get();
        expect(value).to.be.equal(15);
    });

    it('should return -50 after {subract:20,subtract:30}', function () {
        calc.subtract(20);
        calc.subtract(30);
        let value = calc.get();
        expect(value).to.be.equal(-11);
    });

    it('should return 0 after {}', function () {
        let value = calc.get();
        expect(value).to.be.equal(0);
    });

    it('should return NaN after {add:d}', function () {
        calc.add('d')
        let value = calc.get();
        expect(value).to.be.NaN;
    });

    it('should return NaN after {subtract:g}', function () {
        calc.subtract('g')
        let value = calc.get();
        expect(value).to.be.NaN;
    });
});

