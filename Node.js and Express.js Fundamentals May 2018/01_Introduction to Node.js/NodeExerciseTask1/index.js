const storage = require('./storage.js');

storage.load()
    .then(() => {
        storage.put('test2','12345');
        storage.saveSync();
        console.log(storage.get('test2'));
    })
    .catch(err => {
        throw new Error('Could not read file!');
    })

