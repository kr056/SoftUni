function attachEvents() {
    $('#btnLoadTowns').on('click', function () {
        let townsString = $('#towns').val();
        let townsArr = townsString.split(', ');
        let index = $('#towns-template').html();
        let indexTemplate = Handlebars.compile(index)
        $('#root').append(indexTemplate(townsArr));
    })
}