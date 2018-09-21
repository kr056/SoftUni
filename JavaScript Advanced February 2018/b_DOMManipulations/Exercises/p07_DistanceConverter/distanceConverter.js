function attachEventsListeners() {
    let btn = document.getElementById('convert');

    btn.addEventListener('click', distanceConverter)

    function distanceConverter() {
        let fromValue = document.getElementById('inputUnits').value;
        let toValue = document.getElementById('outputUnits').value;
        let fromDistance = Number(document.getElementById('inputDistance').value);
        let toDistance = document.getElementById('outputDistance');
        let meters = 1;

        switch (fromValue) {
            case 'km':
                meters = fromDistance * 1000;
                break;
            case 'm':
                meters = fromDistance;
                break;
            case 'cm':
                meters = fromDistance * 0.01;
                break;
            case 'mm':
                meters = fromDistance * 0.001;
                break;
            case 'mi':
                meters = fromDistance * 1609.34;
                break;
            case 'yrd':
                meters = fromDistance * 0.9144;
                break;
            case 'ft':
                meters = fromDistance * 0.3048;
                break;
            case 'in':
                meters = fromDistance * 0.0254;
                break;
        }

        switch (toValue) {
            case 'km':
                toDistance.value = meters / 1000;
                break;
            case 'm':
                toDistance.value = meters;
                break;
            case 'cm':
                toDistance.value = meters / 0.01;
                break;
            case 'mm':
                toDistance.value = meters / 0.001;
                break;
            case 'mi':
                toDistance.value = meters / 1609.34;
                break;
            case 'yrd':
                toDistance.value = meters / 0.9144;
                break;
            case 'ft':
                toDistance.value = meters / 0.3048;
                break;
            case 'in':
                toDistance.value = meters / 0.0254;
                break;
        }
    }
}
