let expect = require('chai').expect;
let isSymmetric = require('../p05_CheckForSymmetry').isSymmetric;

describe('Symmetry tests', function () {
    it('should return no for [1,2]', function () {
        expect(isSymmetric([1, 2])).to.be.equal(false);
    });

    it('should return yes for []', function () {
        expect(isSymmetric([])).to.be.equal(true);
    });

    it('should return yes for [1]', function () {
        expect(isSymmetric([1])).to.be.equal(true);
    });

    it('should return yes for [1,2,3,3,2,1]', function () {
        expect(isSymmetric([])).to.be.equal(true);
    });

    it('should return no for d,5,5', function () {
        expect(isSymmetric('d', 5, 5)).to.be.equal(false);
    });

    it("should return false for [5,'hi',{a:5},new Date(),{X:5},'hi',5]", function () {
        expect(isSymmetric([5,'hi',{a:5},new Date(),{X:5},'hi',5])).to.be.equal(false);
    });

    it('should return no for [d,5,5]', function () {
        expect(isSymmetric(['d', 5, 5])).to.be.equal(false);
    });
});
