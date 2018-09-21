function calcConeVolumeAndArea(r, h) {
    let volume = (1 / 3) * Math.PI * r * r * h;
    console.log("volume = " + volume);

    let l = Math.sqrt(r * r + h * h);
    let area = (Math.PI * r) * (r + l);
    console.log("area = " + area);
}

calcConeVolumeAndArea(3, 5)