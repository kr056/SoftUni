function personalBMI(name, age, weight, height) {
    let heightInMetres = height / 100;
    let bmi = Math.round(weight / (heightInMetres * heightInMetres));
    let status = getStatus(bmi);

    let patient = {
        name: name, personalInfo: {
            age: age,
            weight: weight,
            height: height
        }, BMI: bmi, status: status
    }

    if (status === 'obese') {
        patient['recommendation'] = 'admission required';
    }

    function getStatus(bmi) {
        let result = '';

        if (bmi < 18.5) {
            result = 'underweight';
        } else if (bmi < 25) {
            result = 'normal';
        } else if (bmi < 30) {
            result = 'overweight';
        } else {
            result = 'obese';
        }

        return result;
    }

    return patient;
}
console.log(personalBMI('Honey Boo Boo', 9, 57, 137));