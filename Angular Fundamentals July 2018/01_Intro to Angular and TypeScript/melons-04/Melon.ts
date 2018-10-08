abstract class Melon {
    weight: number;
    melonSort: string;
    elementIndex: number;

    constructor(weight: number, melonSort: string) {
        this.weight = weight;
        this.melonSort = melonSort;
        this.elementIndex = this.weight * this.melonSort.length;
    }

    getElementIndex(): number {
        return this.elementIndex;
    }

    toString(): string {
        return `Sort: ${this.melonSort}\nElementIndex: ${this.getElementIndex()}`;
    }
}