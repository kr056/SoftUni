$(() => {
    renderCatTemplate();
    attachEvents();
    function renderCatTemplate() {
        let catsTemplate = $('#cat-template').html();
        let html = Handlebars.compile(catsTemplate);
        let obj = {
            cats: window.cats
        };
        $('#allCats').append(html(obj));

    }

    function attachEvents() {
        $('.btn-primary').on('click', function () {
            let text = $(this).text();
            let cardBlock = $(this).parent();

            if (text === 'Hide status code') {
                $(cardBlock).find('div').hide();
                $(this).text('Show status code');
            } else {
                $(this).text('Hide status code');
                $(cardBlock).find('div').show();
            }
        })
    }
})
