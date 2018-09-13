function addOrRemove(arr) {
    let resultArr = [];

    for (let i = 0; i < arr.length; i++) {

        let line = arr[i].split(" ");
        let command = line[0];
        let element = Number(line[1]);

        if (command === "add") {
            resultArr.push(element);
        }
        else if (command === "remove") {
            resultArr.splice(element, 1);
        }
    }

    for (let el of resultArr) {
        console.log(el);
    }
}
