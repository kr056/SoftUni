class PaymentManager {
    constructor(title) {
        this.title = title;
        this.element = $(this.createElement());
    }

    render(target) {
        let selector = '#' + target;
        $(selector).append(this.element);
    }

    createElement() {
        let table = $('<table>');
        let caption = $('<caption>').text(this.title + ' Payment Manager');
        table.append(caption);
        let thead = $('<thead>');
        let tHeadRow = $('<tr>');
        let thName = $('<th class="name">').text('Name');
        let thCategory = $('<th class="category">').text('Category');
        let thPrice = $('<th class="price">').text('Price');
        let thActions = $('<th>').text('Actions');
        tHeadRow.append(thName);
        tHeadRow.append(thCategory);
        tHeadRow.append(thPrice);
        tHeadRow.append(thActions);
        thead.append(tHeadRow);
        table.append(thead);
        //tbody
        let tbody = $('<tbody class="payments">');
        table.append(tbody);
        // tfoot
        let tfoot = $('<tfoot class="input-data">');
        let tFootRow = $('<tr>');
        let td1 = $('<td>');
        let nameInput = $('<input name="name" type="text">');
        td1.append(nameInput);
        //
        let td2 = $('<td>');
        let categoryInput = $('<input name="category" type="text">');
        td2.append(categoryInput);
        //
        let td3 = $('<td>');
        let priceInput = $('<input name="price" type="number">');
        td3.append(priceInput);
        //
        let td4 = $('<td>');
        let addBtn = $('<button>').text('Add');
        addBtn.on('click', function () {
            let name = table.find('input[name=name]').val();
            let category = table.find('input[name=category]').val();
            let price = table.find('input[name=price]').val();
            if (name !== '' && category !== '' && price !== '') {
                table.find('input[name=name]').val('');
                table.find('input[name=category]').val('');
                table.find('input[name=price]').val('');
                let tRow = $('<tr>');
                let tdName = $('<td>').text(name);
                let tdCategory = $('<td>').text(category);
                let tdPrice = $('<td>').text(Number(price));
                let td4 = $('<td>');
                let delBtn = $('<button>').text('Delete');
                delBtn.on('click', function () {
                    tRow.remove();
                });
                td4.append(delBtn);
                tRow.append(tdName);
                tRow.append(tdCategory);
                tRow.append(tdPrice);
                tRow.append(td4);
                table.find('.payments').append(tRow);
            }
        });
        td4.append(addBtn);
        //
        tFootRow.append(td1);
        tFootRow.append(td2);
        tFootRow.append(td3);
        tFootRow.append(td4);
        //
        tfoot.append(tFootRow);
        //
        table.append(tfoot);
        return table;
    }
}