function calcTriangleArea(a, b, c) {
    let sP = (a + b + c) / 2;
    let area = Math.sqrt(sP * (sP - a) * (sP - b) * (sP - c));

    console.log(area);
}

calcTriangleArea(2, 3.5, 4)