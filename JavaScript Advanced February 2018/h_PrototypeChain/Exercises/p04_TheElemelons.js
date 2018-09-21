function elemelons() {
    class Melon {
        constructor(weight, melonSort) {
            if (new.target === Melon) {
                throw new TypeError('Abstract class cannot be instantiated directly');
            }
            this.weight = weight;
            this.melonSort = melonSort;
            this._elementIndex = this.weight * this.melonSort.length;
        }

        get elementIndex() {
            return this._elementIndex;
        }

        toString() {
            return `Element: ${this.constructor.name.replace('melon', '')}\nSort: ${this.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Water';
        }

        morph() {
            if (this.element === 'Water') {
                this.element = 'Fire';
            } else if (this.element = 'Fire') {
                this.element = 'Earth';
            } else if (this.element = 'Earth') {
                this.element = 'Air';
            } else if (this.element = 'Air') {
                this.element = 'Water';
            }
        }


        toString() {
            return `Element: ${this.element}\nSort: ${this.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    return { Melon, Watermelon, Earthmelon, Firemelon, Airmelon, Melolemonmelon };
}

let classes = elemelons();
let w = new classes.Melolemonmelon(12.5, 'KingSize');
w.morph();
console.log(w.toString());