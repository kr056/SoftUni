function attachEventsListeners() {
    let days = document.getElementById('days');
    let daysBtn = document.getElementById('daysBtn');

    let hours = document.getElementById('hours');
    let hoursBtn = document.getElementById('hoursBtn');

    let minutes = document.getElementById('minutes');
    let minutesBtn = document.getElementById('minutesBtn');

    let seconds = document.getElementById('seconds');
    let secondsBtn = document.getElementById('secondsBtn');

    daysBtn.addEventListener('click', convertDays);
    hoursBtn.addEventListener('click', convertHours);
    minutesBtn.addEventListener('click', convertMinutes);
    secondsBtn.addEventListener('click', convertSeconds);

    function convertDays() {
        hours.value = Number(days.value) * 24;
        minutes.value = Number(hours.value) * 60;
        seconds.value = Number(minutes.value) * 60;
    }

    function convertHours() {
        days.value = Math.ceil(Number(hours.value) / 24);
        minutes.value = Number(hours.value) * 60;
        seconds.value = Number(minutes.value) * 60;
    }

    function convertMinutes() {
        hours.value = Math.ceil(Number(minutes.value) / 60);
        days.value = Math.ceil(Number(hours.value) / 24);
        seconds.value = Number(minutes.value) * 60;
    }

    function convertSeconds() {
        minutes.value = Math.ceil(Number(seconds.value) / 60);
        hours.value = Math.ceil(Number(minutes.value) / 60);
        days.value = Math.ceil(Number(hours.value) / 24);
    }
}
