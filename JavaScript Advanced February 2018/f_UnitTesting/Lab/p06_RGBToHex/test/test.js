let expect = require('chai').expect;
let rgbToHexColor = require('../p06_RGBToHex').rgbToHexColor;

describe('rgbToHex tests', function () {
    it('should return purple', function () {
        expect(rgbToHexColor(255,158,170)).to.be.equal('#FF9EAA');
    });

    it('should return black', function () {
        expect(rgbToHexColor(0,0,0)).to.be.equal('#000000');
    });

    it('should return white', function () {
        expect(rgbToHexColor(255,255,255)).to.be.equal('#FFFFFF');
    });

    it('should return undefined', function () {
        expect(rgbToHexColor('d',255,255)).to.be.equal(undefined);
    });

    it('should return undefined', function () {
        expect(rgbToHexColor(252,-12,255)).to.be.equal(undefined);
    });

    it('should return undefined', function () {
        expect(rgbToHexColor()).to.be.equal(undefined);
    });

    it('should return undefined', function () {
        expect(rgbToHexColor(0,0,256)).to.be.equal(undefined);
    });
})
