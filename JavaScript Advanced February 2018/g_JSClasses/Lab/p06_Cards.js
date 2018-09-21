let defineCards = (function () {
    let Suits = {
        CLUBS: '\u2663',
        DIAMONDS: '\u2666',
        HEARTS: '\u2665',
        SPADES: '\u2660',
    };

    let Faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J'
        , 'Q', 'K', 'A'];

    class Card {
        constructor(face, suit) {
            if (!Faces.includes(face)) {
                throw new Error("Invalid card face: " + face);
            }
            
            if (!Object.keys(Suits).map(k => Suits[k]).includes(suit)) {
                throw new Error("Invalid card face: " + face);
            }
            this.face = face;
            this.suit = suit;
        }

        set face(face) {
            this._face = face;
        }

        get face() {
            return this._face;
        }

        set suit(suit) {
            this._suit = suit;
        }

        get suit() {
            return this._suit;
        }

        toString() {
            return this.face + this.suit;
        }
    }

    return { Suits, Card };

})()
let Suits = defineCards.Suits;
let Card = defineCards.Card;
let card = new Card("A", Suits.SPADES);
console.log('' + card); // Q♦