/**
 * Created by BooM on 22.2.2018 г..
 */
function domSearch(selector, caseType) {
    let container = $(selector);
    let fragment = document.createDocumentFragment();

    let contentDiv = $('<div>');
    contentDiv.addClass('items-control');

    let addDiv = $('<div>');
    addDiv.addClass('add-controls');
    let label = $('<label>Enter text:</label>');
    let input = $('<input>');

    let anchor = $('<a>Add</a>');
    anchor.addClass('button');
    anchor.css('display', 'inline-block');
    anchor.on('click', addItem);

    let searchDiv = $('<div>');
    searchDiv.addClass('search-controls');
    let searchLabel = $('<label>Search:</label>');
    let searchInput = $('<input>');
    searchInput.on('input', showElements);


    let resultDiv = $('<div>');
    resultDiv.addClass('result-controls');
    let list = $('<ul>');
    list.addClass('items-list');


    label.appendTo(addDiv);
    input.appendTo(addDiv);
    anchor.appendTo(addDiv);

    searchLabel.appendTo(searchDiv);
    searchInput.appendTo(searchDiv);

    list.appendTo(resultDiv);

    addDiv.appendTo(contentDiv);
    searchDiv.appendTo(contentDiv);
    resultDiv.appendTo(contentDiv);
    contentDiv.appendTo(fragment);
    container.append(fragment);

    function addItem() {
        let item = $(`<li>`).addClass('list-item');
        let btn = $('<a>X</a>').addClass('button').on('click', deleteItem);
        let strong = $(`<strong>${input.val()}</strong>`);
        btn.appendTo(item);
        strong.appendTo(item);
        item.appendTo(list);
    }


    function deleteItem() {
        $(this).parent().remove();
    }

    function showElements() {
        $('.list-item')
            .each((index, li) => {
                $(li).css('display', 'block');
            })
        $('.items-list')
            .find('li')
            .each((index, el) => {
                if (caseType) {
                    if (!el.textContent.includes(searchInput.val())) {
                        $(el).css('display', 'none');
                    }
                } else {
                    if (!el.textContent.toLowerCase().includes(searchInput.val().toLowerCase())) {
                        $(el).css('display', 'none');
                    }
                }
            });
    }
}
