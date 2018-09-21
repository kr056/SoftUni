function processCommands(commands) {
    let cmd = (function () {
        let list = [];
        return {
            add: (newItem) => list.push(newItem),
            remove: (itemToRemove) => list = list.filter((x) => x !== itemToRemove),
            print: () => console.log(list.join(','))
        };

    })();

    for (let str of commands) {
        let [command, item] = str.split(' ');
        cmd[command](item);
    }
}

processCommands(['add hello', 'add again', 'remove hello', 'add again', 'print']);