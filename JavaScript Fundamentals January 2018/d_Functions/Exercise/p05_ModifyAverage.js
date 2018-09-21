function modifyAverage(num) {
    let average = 0;
    let str = num.toString();

    while (true) {
        for (let i = 0; i < str.length; i++) {
            average += parseInt(str[i]);
        }

        average /= str.length;

        if (average > 5) {
            console.log(str);
            return;
        } else {
            average = 0;
            str += '9';
        }
    }
}

modifyAverage(101);
modifyAverage(5835);