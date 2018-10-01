$(function solve() {
    $('#btnLoad').on('click', loadContacts);
    $('#btnCreate').on('click', createContact);

    let baseServiceUrl = 'https://phonebookdemo-33175.firebaseio.com/phonebook';

    function loadContacts() {
        $('#phonebook').empty();

        $.get(baseServiceUrl + '.json')
            .then(displayContacts)
            .catch(displayError);
    }

    function createContact() {
        let newContactJSON = JSON.stringify({
            person: $('#person').val(),
            phone: $('#phone').val()
        });

        $.post(baseServiceUrl + '.json', newContactJSON)
            .then(loadContacts)
            .catch(displayError);

        $('#person').val('');
        $('#phone').val('');
    }

    function displayContacts(contacts) {
        for (let key in contacts) {
            let person = contacts[key]['person'];
            let phone = contacts[key]['phone'];
            let li = $('<li>');

            li.text(person + ': ' + phone);
            $('#phonebook').append(li);
            li.append($("<button>Delete</button>")).on('click', deleteContact.bind(this, key));
        }
    }


    function deleteContact(key) {
        let request = {
            method: 'DELETE',
            url: baseServiceUrl + '/' + key + '.json'
        };

        $.ajax(request)
            .then(loadContacts)
            .catch(displayError);
    }


    function displayError(err) {
        console.log(err);
        $('#phonebook').append($('<li>Error</li>'));
    }

})