function createNewStudentForm() {
    $('#results').append(
        $('<tr>')
            .append($('<td>').append($('<input type="number" name="id">')))
            .append($('<td>').append($('<input type="text" name="firstName">')))
            .append($('<td>').append($('<input type="text" name="lastName">')))
            .append($('<td>').append($('<input type="text" name="facNumber">')))
            .append($('<td>').append($('<input type="number" name="grade">')))
            .append($('<td>').append($('<button class="btnAdd">Add</button>')))
    );

}