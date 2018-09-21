function search() {
    let targetValue = $('#searchText').val();
    let matches = 0;
    $('#towns')
        .find('li')
        .each((index, el) => {
            if (el.textContent.includes(targetValue)) {
                $(el).css('font-weight', 'bold');
                matches++;
            }
        });
    $('#result').text(matches + " matches found.")
}
