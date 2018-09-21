function getPrice(input) {
    let movie = input[0].toLowerCase();
    let godfather = 0;
    let list = 8.5;
    let casablanca = 8;
    let oz = 10;
    let day = input[1].toLowerCase();

    switch (day) {
        case 'monday':
            godfather = 12;
            break;
        case 'tuesday':
            godfather = 10;
            break;
        case 'wednesday':
            godfather = 15;
            break;
        case 'thursday':
            godfather = 12.5;
            break;
        case 'friday':
            godfather = 15;
            break;
        case 'saturday':
            godfather = 25;
            list = 15;
            casablanca = 10;
            oz = 15;
            break;
        case 'sunday':
            godfather = 30;
            list = 15;
            casablanca = 10;
            oz = 15;
            break;
        default:
            console.log('error');
            break;
    }

    switch (movie) {
        case 'the godfather':
            console.log(godfather);
            break;
        case 'schindler\'s list':
            console.log(list);
            break;
        case 'casablanca':
            console.log(casablanca);
            break;
        case 'the wizard of oz':
            console.log(oz);
            break;
        default:
            console.log('error');
            break;
    }
}

getPrice(["The Godfather", "Friday"])