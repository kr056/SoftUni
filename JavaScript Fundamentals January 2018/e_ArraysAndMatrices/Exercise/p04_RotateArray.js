function rotateArray(arr) {
    let rotateCount = Number(arr.pop());

    for (let i = 0; i < rotateCount % arr.length; i++) {
        arr.unshift(arr.pop());
    }

    console.log(arr.join(' '));
}
rotateArray(['Banana', 'Orange', 'Coconut', 'Apple', 15])