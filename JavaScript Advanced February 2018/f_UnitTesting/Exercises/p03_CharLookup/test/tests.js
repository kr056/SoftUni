let expect = require('chai').expect;
let lookupChar = require('../p03_CharLookup').lookupChar;

describe('charLookup tests', function () {
    it('should return w for dwade3,1', function () {
        expect(lookupChar('dwade3', 1)).to.be.equal('w');
    })

    it('should return w for dwade3,1.5', function () {
        expect(lookupChar('dwade3', 1.5)).to.be.equal(undefined);
    })

    it('should return undefined for {},1', function () {
        expect(lookupChar({}, 1)).to.be.equal(undefined);
    })

    it('should return undefined for dw,d', function () {
        expect(lookupChar('dw', 'd')).to.be.equal(undefined);
    })

    it('should return Incorrect index for dw,3', function () {
        expect(lookupChar('dw', 3)).to.be.equal('Incorrect index');
    })

    it('should return Incorrect index for dw,-5', function () {
        expect(lookupChar('dw', -5)).to.be.equal('Incorrect index');
    })

});
