function spiceMustFlow(yieldStr) {
    let yield = Number(yieldStr);
    let spice = 0;
    let days = 0;

    while (yield >= 100) {
        spice += yield;
        spice -= Math.min(26, spice);
        yield -= 10;
        days++;
    }

    spice -= Math.min(26, spice)
    console.log(days);
    console.log(spice);
}
spiceMustFlow(20)