class Melonmelon extends Melon {
    element: string;
    types: Array<string>;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
        this.element = 'Water';
        this.types = ['Fire', 'Earth', 'Air', 'Water'];
    }

    morph(): void {
        let typeToMorphInto = this.types.shift();

        this.element = typeToMorphInto;
        this.types.push(typeToMorphInto);

    }

    toString(): string {
        return `Element: ${this.element}\n` + super.toString();
    }
}