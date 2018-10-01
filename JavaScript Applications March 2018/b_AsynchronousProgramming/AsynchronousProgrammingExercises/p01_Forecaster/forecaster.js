function attachEvents() {

    function getSymbol(type) {
        switch (type) {
            case 'Sunny':
                return '&#x2600;';
            case 'Partly sunny':
                return '&#x26C5;';
            case 'Overcast':
                return '&#x2601;';
            case 'Rain':
                return '&#x2614;';
        }
    }

    function handleError() {
        $("#forecast")
            .css('display', 'block')
            .text('Error');
    }


    $('#submit').on('click', function () {
        $.get('https://judgetests.firebaseio.com/locations.json')
            .then(handleSuccess)
            .catch(handleError)

        function handleSuccess(arr) {
            let searchedLocation = $('#location').val();
            let locCodeValue = '';
            let degrees = '&#176;';

            for (let obj of arr) {
                if (obj.name === searchedLocation) {
                    locCodeValue = obj.code;
                    break;
                }
            }

            $.get(`https://judgetests.firebaseio.com/forecast/today/${locCodeValue}.json`)
                .then(todayForecast)
                .catch(handleError);

            $("#forecast")
                .css('display', 'block');

            function todayForecast(todayObj) {
                let weather = todayObj.forecast.condition;
                let symbol = getSymbol(weather);
                let high = todayObj.forecast.high;
                let low = todayObj.forecast.low;
                
                let conditionSymbol = $('<span class="symbol">').html(symbol);
                let conditionSpan = $('<span class="condition">')
                    .append($('<span class="forecast-data">').text(todayObj.name))
                    .append($('<span class="forecast-data">').html(`${low}${degrees}/${high}${degrees}`))
                    .append($('<span class="forecast-data">').text(weather));

                $('#current').append(conditionSymbol).append(conditionSpan);
            }

            $.get(`https://judgetests.firebaseio.com/forecast/upcoming/${locCodeValue}.json`)
                .then(upcomingForecast)
                .catch(handleError);

            function upcomingForecast(upcoming) {
                for (let forecast of upcoming.forecast) {
                    let upcomingSpan = $('<span class="upcoming">')
                        .append($('<span class="forecast-data">').html(getSymbol(forecast.condition)))
                        .append($('<span class="forecast-data">').html(`${forecast.low}${degrees}/${forecast.high}${degrees}`))
                        .append($('<span class="forecast-data">').text(forecast.condition));
                    $('#upcoming').append(upcomingSpan);
                }
            }
        }
    })
}