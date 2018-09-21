let expect = require('chai').expect;
let PaymentPackage = require('../paymentPackage').PaymentPackage;

describe('paymentPackageTests', function () {
    let paymentPackage;
    beforeEach(function () {
        paymentPackage = new PaymentPackage('sth', 100);
    })

    it('have all methods when created', function () {
        expect(PaymentPackage.prototype.hasOwnProperty('toString')).to.be.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('name')).to.be.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('value')).to.be.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('VAT')).to.be.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('active')).to.be.equal(true);
    })

    it('throws error for initializing with invalid params', function () {
        expect(() => paymentPackage = new PaymentPackage('HR')).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage(21)).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage()).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage(21, 21, 21)).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage('d', 'd', 'd')).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage('', 21)).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage('HR', -15)).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage([], 21)).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage('DD', '')).to.throw(Error);
        expect(() => paymentPackage = new PaymentPackage(-21, {})).to.throw(Error);
    })

    it('getters work', function () {
        expect(paymentPackage.VAT).to.equal(20);
        expect(paymentPackage.active).to.equal(true);
        expect(paymentPackage.name).to.equal('sth');
        expect(paymentPackage.value).to.equal(100);
    })

    it('throws error for invalid name name', function () {
        expect(() => paymentPackage.name = null).to.throw(Error);
        expect(() => paymentPackage.name = undefined).to.throw(Error);
        expect(() => paymentPackage.name = '').to.throw(Error);
        expect(() => paymentPackage.name = 21).to.throw(Error);
    })

    it('throws error for negative value', function () {
        expect(() => paymentPackage.value = null).to.throw(Error);
        expect(() => paymentPackage.value = undefined).to.throw(Error);
        expect(() => paymentPackage.value = '').to.throw(Error);
        expect(() => paymentPackage.value = -15).to.throw(Error);
        expect(() => paymentPackage.value = -15.151).to.throw(Error);
    })

    it('positive values and 0 work', function () {
        paymentPackage.value = 0;
        expect(paymentPackage.value).to.equal(0);
    })

    it('initial vat is 20', function () {
        expect(paymentPackage.VAT).to.be.equal(20);
    })

    it('initial active is true', function () {
        expect(paymentPackage.active).to.be.equal(true);
    })

    it('throws error for invalid vats', function () {
        expect(() => paymentPackage.VAT = 'd').to.throw(Error);
        expect(() => paymentPackage.VAT = -15).to.throw(Error);
        expect(() => paymentPackage.VAT = null).to.throw(Error);
        expect(() => paymentPackage.VAT = undefined).to.throw(Error);

    })

    it('throws error for invalid active', function () {
        expect(() => paymentPackage.active = 'dd').to.throw(Error);
        expect(() => paymentPackage.active = {}).to.throw(Error);
        expect(() => paymentPackage.active = null).to.throw(Error);
        expect(() => paymentPackage.active = undefined).to.throw(Error);
    })

    it('toString works', function () {
        expect(paymentPackage.toString()).to.be.equal('Package: sth\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120');
    })

    it('toString works when active if false', function () {
        paymentPackage.active = false;
        expect(paymentPackage.toString()).to.be.equal('Package: sth (inactive)\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120');
    })

    it('active change value', function () {
        paymentPackage.active = false;
        expect(paymentPackage.active).to.be.equal(false);
    })
})