function printDeckOfCards(cards) {
    function makeCard(face, suit) {
        let faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        let suits = ['S', 'H', 'D', 'C'];

        if (!faces.includes(face) || !suits.includes(suit)) {
            throw new Error(`Invalid card: ${face}${suit}`);
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

    let result = [];

    for (let i = 0; i < cards.length; i++) {
        let face, suit;

        if (cards[i].length === 3) {
            face = cards[i].substr(0, 2);
            suit = cards[i].substr(2);
        } else {
            face = cards[i].substr(0, 1);
            suit = cards[i].substr(1);
        }

        try {
            result.push(makeCard(face, suit));
        } catch (err) {
            console.log(`Invalid card: ${cards[i]}`);
            return;
        }
    }

    console.log(result.join(' '));
}

printDeckOfCards(['5S', '3D', 'QD', '1C']);