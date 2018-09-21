function playingCards(face, suit) {
    let faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    let suits = ['S', 'H', 'D', 'C'];

    if (!faces.includes(face) || !suits.includes(suit)) {
        throw new Error('Error');
    }

    let utf;

    switch (suit) {
        case 'S':
            utf = '\u2660';
            break;
        case 'H':
            utf = '\u2665';
            break;
        case 'D':
            utf = '\u2666';
            break;
        case 'C':
            utf = '\u2663';
            break;
    }
    
    let card = {
        face: face,
        suit: utf,
        toString: () => {
            return card.face + card.suit;
        }
    };

    return card;
}

console.log(playingCards('J', 'D') + '');