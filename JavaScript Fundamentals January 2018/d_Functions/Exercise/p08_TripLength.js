function tripLength(input) {
    let x1 = input[0], y1 = input[1];
    let x2 = input[2], y2 = input[3];
    let x3 = input[4], y3 = input[5];

    let distanceOneAndTwo = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    let distanceOneAndThree = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
    let distanceTwoAndThree = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

    let result = '';
    let totalDistance = 0;

    if (distanceOneAndTwo <= distanceOneAndThree && distanceOneAndThree >= distanceTwoAndThree) {
        result += '1->2->3';
        totalDistance = distanceOneAndTwo + distanceTwoAndThree;
    } else if (distanceOneAndTwo <= distanceTwoAndThree && distanceOneAndThree < distanceTwoAndThree) {
        result += '2->1->3';
        totalDistance = distanceOneAndTwo + distanceOneAndThree;
    } else {
        result += '1->3->2';
        totalDistance = distanceTwoAndThree + distanceOneAndThree;
    }

    console.log(`${result}: ${totalDistance}`);
}

tripLength([0, 0, 2, 0, 4, 0])
tripLength([5, 1, 1, 1, 5, 4])