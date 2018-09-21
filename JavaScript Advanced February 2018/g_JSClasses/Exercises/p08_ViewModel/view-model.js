class Textbox {
    constructor(selector, invalidSymbols) {
        this._elements = $(selector);
        this._invalidSymbols = invalidSymbols;

        let _that = this;

        this._elements.each(function (index, elem) {
            $(elem).on('input', function () {
                _that.value = elem.value;
            })
        })
    }

    get value() {
        return this._value;
    }

    set value(value) {
        this._value = value;
        this.changeValues();
    }

    get elements() {
        return this._elements;
    }

    changeValues() {
        let _that = this;
        this._elements.each(function (index, elem) {
            elem.value = _that.value;
        })
    }

    isValid() {
        return !this._invalidSymbols.test(this._value);
    }
}

let textbox = new Textbox(".textbox", /[^a-zA-Z0-9]/);
let inputs = $('.textbox');