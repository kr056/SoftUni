function attachEvents() {
    $('#items > li').on('click', function () {
        if (!$(this).attr('data-selected')) {
            $(this).attr('data-selected', true);
            $(this).css('background-color', "#DDD");
        } else {
            $(this).removeAttr('data-selected', true);
            $(this).css('background-color', "");
        }
    });
    $('#showTownsButton').on('click', function () {
        let result = $('#items > li[data-selected=true]')
            .toArray()
            .map(li => li.textContent)
            .join(', ');
            
        $('#selectedTowns')
            .text("Selected towns: " + result);

    })
}
