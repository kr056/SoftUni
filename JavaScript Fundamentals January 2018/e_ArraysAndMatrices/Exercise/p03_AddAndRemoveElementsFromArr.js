function addAndRemoveFromArr(arr) {
    let result = [];
    let value = 1;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === 'add') {
            result.push(value);
        } else {
            result.pop();
        }

        value++;
    }

    let print = (result.length > 0) ? result.join('\n') : 'Empty';
    console.log(print);
}
addAndRemoveFromArr(['add', 'add', 'remove', 'add', 'add'])