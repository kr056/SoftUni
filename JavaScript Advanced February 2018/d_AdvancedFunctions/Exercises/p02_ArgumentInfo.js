function argumentInfo() {
    let data = {};

    for (let i = 0; i < arguments.length; i++) {
        let arg = arguments[i];
        let argType = typeof arg;

        console.log(argType + ": " + arg);

        if (data.hasOwnProperty(argType)) {
            data[argType]++;
        } else {
            data[argType] = 1;
        }
    }

    let sortedData = Object.keys(data).sort((a, b) => {
        return data[b] - data[a];
    });

    for (let key of sortedData) {
        console.log(key + " = " + data[key]);
    }
}
argumentInfo({ name: 'bob' }, 3.333, 9.999);
