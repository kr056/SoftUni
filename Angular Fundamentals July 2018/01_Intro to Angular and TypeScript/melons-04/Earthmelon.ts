class Earthmelon extends Melon {
    element:string;

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
        this.element='Earth';
    }

    toString() :string{
        return `Element: ${this.element}\n` + super.toString();
    }
}