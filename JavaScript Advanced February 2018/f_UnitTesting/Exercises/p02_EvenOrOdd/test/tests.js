let expect = require('chai').expect;
let isOddOrEven = require('../p02_EvenOrOdd').isOddOrEven;

describe('evenOrOdd tests', function () {
    it('should return even for dwade3', function () {
        expect(isOddOrEven('dwade3')).to.be.equal('even');
    })

    it('should return even for dwade', function () {
        expect(isOddOrEven('dwade')).to.be.equal('odd');
    })

    it('should return undefined for 5', function () {
        expect(isOddOrEven(5)).to.be.equal(undefined);
    })
});
