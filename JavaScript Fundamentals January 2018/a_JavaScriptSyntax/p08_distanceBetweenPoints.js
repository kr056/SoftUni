function getDistanceBetweenTwoPoints(x1, y1, x2, y2) {
    let pointA = { x: x1, y: y1 };
    let pointB = { x: x2, y: y2 };

    let result = Math.sqrt(Math.pow((pointB.x - pointA.x), 2)
        + Math.pow((pointB.y - pointA.y), 2));

    return result;
}

console.log(getDistanceBetweenTwoPoints(2.34, 15.66, -13.55, -2.9985));