class Airmelon extends Melon {
    element : string;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
        this.element='Air';
    }

    toString() :string{
        return `Element: ${this.element}\n` + super.toString();
    }
}