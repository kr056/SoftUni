function attachEvents() {
    $('a.button').on('click', (event) => {
        let target = $(event.target)
        $('.selected').removeClass('selected');
        target.addClass('selected');
    });
}
