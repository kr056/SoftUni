class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        if (!/^\d{6}$/.exec(clientId)) {
            throw new TypeError('Client ID must be a 6-digit number');
        } else {
            this.clientId = clientId;
        }

        if (!/^\w+@([a-zA-Z.]+$)/.exec(email)) {
            throw new TypeError('Invalid e-mail');
        } else {
            this.email = email;
        }

        if (firstName.length < 3 || firstName.length > 20) {
            throw new TypeError('First name must be between 3 and 20 characters long');
        }
        else if (!/^[a-zA-Z]*$/.exec(firstName)) {
            throw new TypeError('First name must contain only Latin characters');
        } else {
            this.firstName = firstName;
        }

        if (lastName.length < 3 || lastName.length > 20) {
            throw new TypeError('Last name must be between 3 and 20 characters long');
        }
        else if (!/^[a-zA-Z]*$/.exec(lastName)) {
            throw new TypeError('Last name must contain only Latin characters');
        } else {
            this.lastName = lastName;
        }

    }
}

let acc = new CheckingAccount('4234145', 'petkan@another.co.uk', 'Petkan', 'Draganov')