class SortedList {
    constructor() {
        this.myColl = [];
        this.size = 0;
    }

    add(el) {
        this.myColl.push(el);
        this.size++;
        
        return this.myColl.sort((a, b) => a - b);
    }

    remove(index) {
        if (index >= 0 && index < this.myColl.length) {
            this.myColl.splice(index, 1);
            this.size--;
            return this.myColl.sort((a, b) => a - b);
        }
    }

    get(index) {
        if (index >= 0 && index < this.myColl.length) {
            return this.myColl[index];
        }
    }
}

let sl = new SortedList();
console.log(sl.add(5));;
console.log(sl.get(0));
console.log(sl.remove(0));