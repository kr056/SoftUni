function solve() {
    const kinveyAppId = 'kid_BJXTsSi-e';
    const serviceUrl = 'https://baas.kinvey.com/appdata/' + kinveyAppId;
    const kinveyUsername = 'guest';
    const kinveyPassword = 'guest';
    const base64Auth = btoa(kinveyUsername + ':' + kinveyPassword);
    const authHeaders = { "Authorization": 'Basic ' + base64Auth };

    $(document).on('click', '.btnAdd', addNewUser);

    $.ajax({
        method: "GET",
        url: serviceUrl + '/students',
        headers: authHeaders
    }).then(listStudents);

    function listStudents(res) {
        res = res.sort((a, b) => a.ID - b.ID);
        for (let obj of res) {
            $('#results').append(
                $('<tr>')
                    .append($('<td>').text(obj.ID))
                    .append($('<td>').text(obj.FirstName))
                    .append($('<td>').text(obj.LastName))
                    .append($('<td>').text(obj.FacultyNumber))
                    .append($('<td>').text(obj.Grade))
            )
        }
    }


    function addNewUser() {
        let id = $('#results').find('input[name="id"]').val();
        let firstName = $('#results').find('input[name="firstName"]').val();
        let lastName = $('#results').find('input[name="lastName"]').val();
        let facultyNumber = $('#results').find('input[name="facNumber"]').val();
        let grade = $('#results').find('input[name="grade"]').val();

        let data = {
            ID: Number(id), FirstName: firstName, LastName: lastName
            , FacultyNumber: facultyNumber, Grade: Number(grade)
        };

        $.ajax({
            method: 'POST',
            url: serviceUrl + '/students',
            headers: { "Authorization": "Basic " + base64Auth, "Content-type": "application/json" },
            data: JSON.stringify(data)
        }).then(() => {
            $.ajax({
                method: "GET",
                url: serviceUrl + '/students',
                headers: authHeaders
            }).then(listStudents)
                .catch(function (err) {
                    console.log(err);
                });
        })
            .catch(function (err) {
                console.log(err);
            });
    }
}