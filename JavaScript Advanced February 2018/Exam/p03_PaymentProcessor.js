class PaymentProcessor {
    constructor(options) {
        if (options === undefined) {
            this.options = {
                types: ["service", "product", "other"],
                precision: 2
            }
        } else if (!options.hasOwnProperty('types') && options.hasOwnProperty('precision')) {
            this.options = {};
            this.options.types = ["service", "product", "other"];
            this.options.precision = options.precision;
        } else if (!options.hasOwnProperty('precision') && options.hasOwnProperty('types')) {
            this.options = {};
            this.options.types = options.types;
            this.options.precision = 2;
        } else {
            this.options = options;
        }

        this.payments = new Map();
    }

    registerPayment(id, name, type, value) {
        if (id === '' || name === '') {
            throw new Error;
        }

        if (this.payments.has(id)) {
            throw new Error;
        }

        if (typeof value !== 'number') {
            throw new Error;
        }

        if (!this.options.types.includes(type)) {
            throw new Error;
        }

        this.payments.set(id, { name, type, value });
    }

    deletePayment(id) {
        if (!this.payments.has(id)) {
            throw new Error;
        }

        this.payments.delete(id);
    }

    get(id) {
        if (!this.payments.has(id)) {
            throw new Error;
        }

        let paymentToPrint = this.payments.get(id);
        let result = `Details about payment ID: ${id}\n- Name: ${paymentToPrint.name}\n- Type: ${paymentToPrint.type}\n- Value: ${paymentToPrint.value.toFixed(this.options.precision)}`;

        return result;
    }

    setOptions(options) {
        if (options === undefined) {
            this.options = {
                types: ["service", "product", "other"],
                precision: 2
            }
        } else if (options.types === undefined) {
            this.options.precision = options.precision;
        } else if (options.precision === undefined) {
            this.options.types = options.types;
        } else {
            this.options = options;
        }
    }

    toString() {
        let balance = 0;
        this.payments.forEach((a) => balance += a.value);
        
        return `Summary:\n- Payments: ${this.payments.size}\n- Balance: ${balance.toFixed(this.options.precision)} `;
    }
}
// Initialize processor with default options
const generalPayments = new PaymentProcessor();
generalPayments.registerPayment('0001', 'Microchips', 'product', 15000);
generalPayments.registerPayment('01A3', 'Biopolymer', 'product', 23000);
console.log(generalPayments.toString());

// Should throw an error (invalid type)
// generalPayments.registerPayment('E028', 'Rare-earth elements', 'materials', 8000);

generalPayments.setOptions({ types: ['product', 'material'] });
generalPayments.registerPayment('E028', 'Rare-earth elements', 'material', 8000);
console.log(generalPayments.get('E028'));
generalPayments.registerPayment('CF15', 'Enzymes', 'material', 55000);

// Should throw an error (ID not found)
// generalPayments.deletePayment('E027');
// Should throw an error (ID not found)
// generalPayments.get('E027');

generalPayments.deletePayment('E028');
console.log(generalPayments.toString());

// Initialize processor with custom types
const servicePyaments = new PaymentProcessor({ types: ['service'] });
servicePyaments.registerPayment('01', 'HR Consultation', 'service', 3000);
servicePyaments.registerPayment('02', 'Discount', 'service', -1500);
console.log(servicePyaments.toString());

// Initialize processor with custom precision
const transactionLog = new PaymentProcessor({ precision: 5 });
transactionLog.registerPayment('b5af2d02-327e-4cbf', 'Interest', 'other', 0.00153);
console.log(transactionLog.toString());
