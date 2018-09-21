function drawFigure(n) {
    let lines = (n%2===0) ? n-1:n;
    let fillingCount = Math.floor((lines-3)/2);
    let figure='';

    if(n===2){
        figure=('+++');
        return figure;
    }

    let repCount = n-2;
    let border = '+' + '-'.repeat(repCount) + '+' + '-'.repeat(repCount)+'+\n';
    let filling = '|' + ' '.repeat(repCount) + '|' + ' '.repeat(repCount)+'|\n';
    figure+=border;

    for (let i = 0; i < fillingCount; i++) {
        figure+=filling;
    }

    figure+=border;

    for (let i = 0; i < fillingCount; i++) {
        figure+=filling;
    }

    figure+=border;

    return figure;
}

console.log(drawFigure(9));