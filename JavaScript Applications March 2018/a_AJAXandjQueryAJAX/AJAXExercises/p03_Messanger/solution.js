function attachEvents() {
    $('#submit').on('click', submit);
    $('#refresh').on('click', refresh);

    function submit() {
        let author = $('#author').val();
        let msg = $('#content').val();
        let postJSON = JSON.stringify({
            author: author,
            content: msg,
            timestamp: Date.now()
        });

        $.post('https://messangerdemo-67188.firebaseio.com/messanger.json', postJSON);
        $('#author').val('');
        $('#content').val('');
    }

    function refresh() {
        $('#messages').empty();
        $.get('https://messangerdemo-67188.firebaseio.com/messanger.json').then(handleSuccess);

        function handleSuccess(content) {
            let messageArr = [];

            for (let obj in content) {
                if (content.hasOwnProperty(obj)) {
                    messageArr.push(content[obj]);
                }
            }

            messageArr.sort((a, b) => a.timestamp - b.timestamp);
            
            for (let msg of messageArr) {
                let str = `${msg.author}: ${msg.content}\n`;
                $('#messages').append(str);
            }
        }
    }
}
