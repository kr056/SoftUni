function constructionCrew(obj) {

    let shake = obj['handsShaking'];

    if (shake) {
        let calc = (obj['weight'] * 0.1) * obj['experience'];
        obj['bloodAlcoholLevel'] += calc;
        obj['handsShaking'] = false;
    }

    return obj;
}

let worker = {
    weight: 80,
    experience: 1,
    bloodAlcoholLevel: 0,
    handsShaking: true
}
console.log(constructionCrew(worker));;
