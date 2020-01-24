function aritmephile(arr) {
    arr = arr.map(x => Number(x));
    let max = Number.NEGATIVE_INFINITY;

    for (let i = 0; i < arr.length; i++) {
        let s = arr[i]

        if (s >= 0 && s < 10) {
            let current = 1;

            for (let j = 0; j < s; j++) {
                current *= arr[i + j + 1]
            }

            if (current > max) {
                max = current;
            }
        }
    }
    
    console.log(max);
}

aritmephile(['10', '20', '2','30','44','3','56','20','24'])
