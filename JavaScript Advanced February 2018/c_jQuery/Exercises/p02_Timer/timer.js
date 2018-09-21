function timer() {
    let timer;
    let seconds = 0;
    let isStarted = false;

    $('#start-timer').on('click', function () {
        if (!isStarted) {
            timer = setInterval(incrementTime, 1000);
            isStarted = true;
        }
    });

    $('#stop-timer').on('click', function () {
        clearInterval(timer);
        isStarted = false;
    });

    function incrementTime() {
        seconds++;
        $('#seconds').text(('0' + seconds % 60).slice(-2));
        $('#minutes').text(('0' + Math.trunc(seconds / 60 % 60)).slice(-2));
        $('#hours').text(('0' + Math.trunc(seconds / 3600)).slice(-2));
    }

}
