function calcCircArea(r) {
    let circleArea = Math.PI * r * r;
    console.log(circleArea);

    let circleAreaRounded = circleArea.toFixed(2);
    console.log(circleAreaRounded);;
}

calcCircArea(5)