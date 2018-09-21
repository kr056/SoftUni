function sortedList() {
    let myColl = [];

    return {
        add: function (el) {
            myColl.push(el);
            this.size++;
            return myColl.sort((a, b) => a - b);
        },
        remove: function (index) {
            if (index >= 0 && index < myColl.length) {
                myColl.splice(index, 1);
                this.size--;
                return myColl.sort((a, b) => a - b);
            }
        },
        get: function (index) {
            if (index >= 0 && index < myColl.length) {
                return myColl[index];
            }
        },
        size: 0
    }
};
let result = sortedList();
result.add(5);
result.add(11);
console.log(result.size);
console.log(result.get(0));
console.log(result.remove(0));
