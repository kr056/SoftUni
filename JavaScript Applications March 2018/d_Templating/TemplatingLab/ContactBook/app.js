$(() => {
    let details;
    let data;

    async function loadFiles() {
        let contacts = await $.get('templates/contacts.html');
        let contactsTemplate = Handlebars.compile(contacts);

        details = await $.get('templates/details.html');
        data = await $.get('data.json');

        let obj = {
            contacts: data
        };

        let table = contactsTemplate(obj);
        $('#list').append(table);
        attachEvents();
    }

    loadFiles();

    function attachEvents() {
        $('.contact').on('click', function () {
            loadDetails($(this).attr('data-id'));
            $('.active').removeClass('active');
            $(this).addClass('active');
        })

        function loadDetails(id) {
            let detailsTemplate = Handlebars.compile(details);
            let html = detailsTemplate(data[id]);
            $('#details').empty();
            $('#details').append(html);
        }
    }
});