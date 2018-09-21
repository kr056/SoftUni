function drawHelix(num) {
    let result = '';
    let index = 0;
    let dna = 'ATCGTTAGGG';

    for (let i = 0; i < num; i++) {
        if (i % 4 === 0) {
            result += '**' + dna[index % 10] + dna[index % 10 + 1] + '**\n';
        } else if (i % 4 === 1) {
            result += '*' + dna[index % 10] + '--' + dna[index % 10 + 1] + '*\n';
        } else if (i % 4 === 2) {
            result += dna[index % 10] + '----' + dna[index % 10 + 1] + '\n';
        } else {
            result += '*' + dna[index % 10] + '--' + dna[index % 10 + 1] + '*\n';
        }

        index += 2;

    }

    console.log(result);
}

drawHelix(15);