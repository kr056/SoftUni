function carFactory(obj) {
    let power = 0;
    let volume = 0;

    if (obj.power <= 90) {
        power = 90;
        volume = 1800;
    } else if (obj.power <= 120) {
        power = 120;
        volume = 2400;
    } else {
        power = 200;
        volume = 3500;
    }

    function getTires(size) {
        if (size % 2 === 0) {
            size -= 1;
        }

        size = Math.floor(size);

        return [size, size, size, size];
    }

    return {
        model: obj.model,
        engine: { power: power, volume: volume },
        carriage: { type: obj.carriage, color: obj.color },
        wheels: getTires(obj.wheelsize)
    };

}

let obj = {
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
};
console.log(carFactory(obj));