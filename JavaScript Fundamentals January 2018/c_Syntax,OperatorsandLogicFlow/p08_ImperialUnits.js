function inchesToFeets(value) {
    let feets = Math.floor(value/12);
    let inches = value%12;

    console.log(`${feets}'-${inches}\"`);
}

inchesToFeets(11);