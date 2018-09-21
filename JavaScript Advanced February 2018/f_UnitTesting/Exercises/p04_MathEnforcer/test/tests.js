let expect = require('chai').expect;
let mathEnforcer = require('../p04_MathEnforcer').mathEnforcer;

describe('mathEnforcer tests', function () {
    it('should return 8 for addFive(3)', function () {
        expect(mathEnforcer.addFive(3)).to.be.equal(8);
    });

    it('should return 0 for addFive(-5)', function () {
        expect(mathEnforcer.addFive(-5)).to.be.equal(0);
    });


    it('should return 8.5 for addFive(3.5)', function () {
        expect(mathEnforcer.addFive(3.5)).to.be.equal(8.5);
    });

    it('should return undefined for addFive(das)', function () {
        expect(mathEnforcer.addFive('das')).to.be.equal(undefined);
    });

    it('should return 10 for subtractTen(20)', function () {
        expect(mathEnforcer.subtractTen(20)).to.be.equal(10);
    });

    it('should return 0 for subtractTen(-10)', function () {
        expect(mathEnforcer.subtractTen(-10)).to.be.equal(-20);
    });

    it('should return 10.5 for subtractTen(20.5)', function () {
        expect(mathEnforcer.subtractTen(20.5)).to.be.equal(10.5);
    });

    it('should return undefined for subtractTen(das)', function () {
        expect(mathEnforcer.subtractTen('das')).to.be.equal(undefined);
    });

    it('should return 25 for sum(23,2)', function () {
        expect(mathEnforcer.sum(23, 2)).to.be.equal(25);
    });

    it('should return 26 for sum(23.5,2.5)', function () {
        expect(mathEnforcer.sum(23.5, 2.5)).to.be.equal(26);
    });

    it('should return undefined for sum(d,d)', function () {
        expect(mathEnforcer.sum('d', 'd')).to.be.equal(undefined);
    });

    it('should return undefined for sum(5,d)', function () {
        expect(mathEnforcer.sum(5, 'd')).to.be.equal(undefined);
    });

    it('should return undefined for sum(d,5)', function () {
        expect(mathEnforcer.sum('d', 5)).to.be.equal(undefined);
    });
});