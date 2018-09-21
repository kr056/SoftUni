function filterPersonsByAge(minAge, pOneName, pOneAge, pTwoName, pTwoAge) {
    let personA = { name: pOneName, age: pOneAge };
    let personB = { name: pTwoName, age: pTwoAge };

    if (personA.age >= minAge) {
        console.log(personA)
    }
    
    if (personB.age >= minAge) {
        console.log(personB)
    }
}

filterPersonsByAge(18, "Pesho", 5, "Toshko", 20)