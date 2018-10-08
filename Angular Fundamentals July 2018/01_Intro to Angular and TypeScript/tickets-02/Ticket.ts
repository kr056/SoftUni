class Ticket {
    destination: string
    price: number
    status: string

    constructor(destination: string, price: number, status: string) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }
}

function manageTickets(arr: Array<string>, sortCriteria: string) {
    let ticketArr: Array<Ticket> = [];

    for (let index = 0; index < arr.length; index++) {
        let element: string = arr[index];
        let tokens: Array<string> = element.split('|');

        let ticket: Ticket = new Ticket(tokens[0], Number(tokens[1]), tokens[2]);
        ticketArr.push(ticket);
    }

    ticketArr = ticketArr.sort((a, b) => compare(a, b, sortCriteria))


    function compare(a: Ticket, b: Ticket, sortCriteria: string) {
        if (sortCriteria === 'destination') {
            if (a.destination.localeCompare(b.destination) === 1) {
                return 1;
            }

            if (a.destination.localeCompare(b.destination) === -1) {
                return -1;
            }

            return 0;
        }

        if (sortCriteria === 'price') {
            if (a.price > b.price) {
                return 1;
            }

            if (a.price < b.price) {
                return -1;
            }

            return 0;
        }

        if (sortCriteria === 'status') {
            if (a.status.localeCompare(b.status) === 1) {
                return 1;
            }
            if (a.status.localeCompare(b.status) === -1) {
                return -1;
            }

            return 0;
        }
    }

    console.log(ticketArr);
}

manageTickets(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'status'
)
