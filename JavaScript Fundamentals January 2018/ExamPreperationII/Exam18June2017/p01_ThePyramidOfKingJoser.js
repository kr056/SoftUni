function pyramid(base, increment) {
    let stone = 0;
    let marble = 0;
    let lazuli = 0;
    let gold = 0;
    let step = 0;

    for (let i = base; i >= 0; i -= 2) {
        step++;

        if (i - 2 <= 0) {
            gold += i * i * increment;
            break;
        }

        stone += ((i - 2) * (i - 2)) * increment;

        if (step % 5 === 0) {
            lazuli += ((i * 4) - 4) * increment;
        } else {
            marble += ((i * 4) - 4) * increment;
        }
    }

    console.log("Stone required: " + Math.ceil(stone));
    console.log("Marble required: " + Math.ceil(marble));
    console.log("Lapis Lazuli required: " + Math.ceil(lazuli));
    console.log("Gold required: " + Math.ceil(gold));
    console.log("Final pyramid height: " + Math.floor(step * increment));
}

pyramid(23, 0.5)