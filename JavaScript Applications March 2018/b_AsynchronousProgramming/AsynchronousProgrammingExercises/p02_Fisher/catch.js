function attachEvents() {
    const kinveyAppId = 'kid_rkXNVfYqz';
    const serviceUrl = 'https://baas.kinvey.com/appdata/' + kinveyAppId;
    const kinveyUsername = 'guest';
    const kinveyPassword = 'guest';
    const base64Auth = btoa(kinveyUsername + ':' + kinveyPassword);
    const authHeaders = { "Authorization": 'Basic ' + base64Auth };

    $('.load').on('click', loadData);
    $('.add').on('click', addFish);

    function loadData() {
        let loadCatchesReq = {
            method: "GET",
            url: serviceUrl + '/biggestCatches',
            headers: authHeaders
        };

        $.ajax(loadCatchesReq)
            .then(loadCatches);

        function loadCatches(catches) {
            $('#catches').empty();
            for (let obj of catches) {
                let catchDiv = $(`<div class="catch" data-id="${obj._id}">`)
                    .append($('<label>').text('Angler'))
                    .append($('<input type="text" class="angler">').val(obj.angler))
                    .append($('<label>').text('Weight'))
                    .append($('<input type="number" class="weight">').val(obj.weight))
                    .append($('<label>').text('Species'))
                    .append($('<input type="text" class="species">').val(obj.species))
                    .append($('<label>').text('Location'))
                    .append($('<input type="text" class="location">').val(obj.location))
                    .append($('<label>').text('Bait'))
                    .append($('<input type="text" class="bait">').val(obj.bait))
                    .append($('<label>').text('Capture Time'))
                    .append($('<input type="number" class="captureTime">').val(obj.captureTime))
                    .append($('<button class="update">Update</button>').on('click', updateCatch))
                    .append($('<button class="delete">Delete</button>').on('click', deleteCatch))
                $('#catches').append(catchDiv);
            }
        }
    }

    function addFish() {
        let inputs = $('#aside').find('input');
        let addFishReq = {
            method: "POST",
            url: serviceUrl + '/biggestCatches',
            headers: { "Authorization": "Basic " + base64Auth, "Content-type": "application/json" },
            data: JSON.stringify({
                angler: $(inputs[0]).val(),
                weight: Number($(inputs[1]).val()),
                species: $(inputs[2]).val(),
                location: $(inputs[3]).val(),
                bait: $(inputs[4]).val(),
                captureTime: Number($(inputs[5]).val())
            })
        };

        $.ajax(addFishReq)
            .then(loadData);
    }

    function deleteCatch() {
        let catchId = $(this).parent().attr('data-id');

        let deleteCatchReq = {
            method: "DELETE",
            url: serviceUrl + '/biggestCatches/' + catchId,
            headers: authHeaders
        };

        $.ajax(deleteCatchReq)
            .then(loadData);
    }

    function updateCatch() {
        let catchId = $(this).parent().attr('data-id');
        let inputs = $(this).parent().find('input');

        let updateCatchReq = {
            method: "PUT",
            url: serviceUrl + '/biggestCatches/' + catchId,
            headers: { "Authorization": "Basic " + base64Auth, "Content-type": "application/json" },
            data: JSON.stringify({
                angler: $(inputs[0]).val(),
                weight: Number($(inputs[1]).val()),
                species: $(inputs[2]).val(),
                location: $(inputs[3]).val(),
                bait: $(inputs[4]).val(),
                captureTime: Number($(inputs[5]).val())
            })
        };

        $.ajax(updateCatchReq)
            .then(loadData);
    }
}