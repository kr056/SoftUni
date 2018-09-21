(function bookGenerator() {
    let id = 1;
    return function (selector, titleName, authorName, isbn) {
        let container = $(selector);
        let fragment = document.createDocumentFragment();
        let div = $('<div>');
        div.attr('id', `book${id}`);
        id++;

        let pTitle = $(`<p>${titleName}</p>`);
        let pAuthor = $(`<p>${authorName}</p>`);
        let pISBN = $(`<p>${isbn}</p>`);
        let selectBtn = $('<button>Select</button>');
        let deselectBtn = $('<button>Deselect</button>');

        pTitle.addClass('title');
        pAuthor.addClass('author');
        pISBN.addClass('isbn');

        selectBtn.on('click', function () {
            div.css('border', '2px solid blue');
        })
        deselectBtn.on('click', function () {
            div.css('border', 'none');
        })

        pTitle.appendTo(div);
        pAuthor.appendTo(div);
        pISBN.appendTo(div);
        selectBtn.appendTo(div);
        deselectBtn.appendTo(div);
        div.appendTo(fragment);
        container.append(fragment);
    }
}());