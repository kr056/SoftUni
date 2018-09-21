let expect = require('chai').expect;

function sum(arr) {
    let sum = 0;

    for (num of arr)
        sum += Number(num);
        
    return sum;
}

describe('sum(arr) - sum array of numbers', function () {
    it('should return 3 for[1,2]', function () {
        let expectedSum = 3;
        let actualSum = sum([1, 2]);
        expect(actualSum).to.be.equal(expectedSum);
    });

    it('should return 0 for[]', function () {
        let expectedSum = 0;
        let actualSum = sum([]);
        expect(actualSum).to.be.equal(expectedSum);
    });

    it('should return -10 for[-15,5]', function () {
        let expectedSum = -10;
        let actualSum = sum([-15,5]);
        expect(actualSum).to.be.equal(expectedSum);
    });

    it('should return NaN for[d]', function () {
        let actualSum = sum(['d']);
        expect(actualSum).to.be.NaN;
    });
})
