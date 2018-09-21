function boxesAndBottles(bottles, singleBoxCapacity) {
    return Math.ceil((bottles / singleBoxCapacity));
}

console.log(boxesAndBottles(5, 10))