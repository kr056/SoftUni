function calcThreeDdistance(nums) {
    let pointA = { x: nums[0], y: nums[1], z: nums[2] };
    let pointB = { x: nums[3], y: nums[4], z: nums[5] };

    let dist = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) +
        Math.pow(pointA.y - pointB.y, 2) +
        Math.pow(pointA.z - pointB.z, 2));

    return dist;
}

console.log(calcThreeDdistance([1, 1, 0, 5, 4, 0]));
console.log(calcThreeDdistance([3.5, 0, 1, 0, 2, -1]));