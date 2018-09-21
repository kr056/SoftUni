function radioCrystals(input) {
    let targetThickness = input[0];
    let service = 'Transporting and washing';

    for (let i = 1; i < input.length; i++) {
        let startThickness = input[i];
        let counter = 0;

        console.log(`Processing chunk ${startThickness} microns`);

        while (startThickness / 4 >= targetThickness) {
            startThickness /= 4;
            counter++;
        }

        if (counter !== 0) {
            console.log(`Cut x${counter}`);
            console.log(service);

            if (startThickness === targetThickness) {
                console.log(`Finished crystal ${startThickness} microns`);
            }

            counter = 0;
        }

        startThickness = Math.floor(startThickness);

        while (startThickness * 0.8 >= targetThickness) {
            startThickness *= 0.8;
            counter++;
        }

        if (counter !== 0) {
            console.log(`Lap x${counter}`);
            console.log(service);

            if (startThickness === targetThickness) {
                console.log(`Finished crystal ${startThickness} microns`);
            }

            counter = 0;
        }

        startThickness = Math.floor(startThickness);

        while (startThickness - 20 >= targetThickness) {
            startThickness -= 20;
            counter++;
        }

        if (counter !== 0) {
            console.log(`Grind x${counter}`);
            console.log(service);

            if (startThickness === targetThickness) {
                console.log(`Finished crystal ${startThickness} microns`);
                break;
            }

            counter = 0;
        }

        startThickness = Math.floor(startThickness);

        while (startThickness - 1 >= targetThickness) {
            startThickness -= 2;
            counter++;
        }

        if (counter !== 0) {
            console.log(`Etch x${counter}`);
            console.log(service);

            if (startThickness === targetThickness) {
                console.log(`Finished crystal ${startThickness} microns`);
                break;
            }

            counter = 0;
        }

        startThickness = Math.floor(startThickness);

        if (startThickness + 1 === targetThickness) {
            startThickness++;

            console.log('X-ray x1');
            console.log(`Finished crystal ${startThickness} microns`);
        }
    }
}

radioCrystals([1375, 50000])