function roadRadar(input) {
    let driverSpeed = input[0];
    let area = input[1];

    switch (area) {
        case 'motorway':
            printOutput(driverSpeed, 130);
            break;
        case 'interstate':
            printOutput(driverSpeed, 90);
            break;
        case 'city':
            printOutput(driverSpeed, 50);
            break;
        case 'residential':
            printOutput(driverSpeed, 20);
            break;
    }

    function printOutput(driverSpeed, limit) {
        if (driverSpeed <= limit) {
        } else if (driverSpeed - limit <= 20) {
            console.log('speeding');
        } else if (driverSpeed - limit <= 40) {
            console.log('excessive speeding')
        } else {
            console.log('reckless driving');
        }
    }
}
roadRadar([40, 'city'])
roadRadar([21, 'residential'])
roadRadar([120, 'interstate'])
roadRadar([200, 'motorway'])