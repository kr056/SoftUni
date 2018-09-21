function tickets(data, sortType) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let db = [];
    
    for (let i = 0; i < data.length; i++) {
        let [destination, price, status] = data[i].split('|');
        db.push(new Ticket(destination, Number(price), status));
    }

    switch (sortType) {
        case 'destination':
            db.sort((a, b) => a.destination.localeCompare(b.destination));
            break;
        case 'price':
            db.sort((a, b) => a.price - b.price);
            break;
        case 'status':
            db.sort((a, b) => a.status.localeCompare(b.status));
            break;
    }

    return db;
}

console.log(tickets(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'status'
));