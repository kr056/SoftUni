function sortArray(inputArr, sortType) {
    let ascComparator = function (a, b) {
        return a - b;
    }

    let descComparator = function (a, b) {
        return b - a;
    }

    let sortingStrategies = {
        'asc': ascComparator,
        'desc': descComparator
    };

    return inputArr.sort(sortingStrategies[sortType]);
}
console.log(sortArray([14, 7, 17, 6, 8], 'desc'));