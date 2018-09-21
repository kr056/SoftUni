function orderRectangles(matrix) {
    for (let i = 0; i < matrix.length; i++) {
        matrix[i] = {
            width: matrix[i][0],
            height: matrix[i][1],
            area: () => this.width * this.height,
            compareTo: function (other) {
                let diff = this.area() - other.area();
                return diff || this.width - other.width;
            }
        }
    }
    
    return matrix.sort((a, b) => a.compareTo(b));
}
console.log(orderRectangles([[10, 5], [3, 20], [5, 12]]));