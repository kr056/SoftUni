function buildAWall(arr) {
    let concreteUsedPerDay = 0;
    let concrete = [];
    let totalConcrete = 0;

    while (arr.length != 0) {
        arr = arr.filter(x => x < 30);
        concreteUsedPerDay = 195 * arr.length;
        concrete.push(concreteUsedPerDay);
        totalConcrete += concreteUsedPerDay;

        for (let i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }

    console.log(concrete.filter(x => x !== 0).join(', '));
    console.log(totalConcrete * 1900 + " pesos");

}

buildAWall([17, 22, 17, 19, 17])