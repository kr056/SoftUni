const fs = require('fs');
const path = require('path');
const storagePath = path.join(__dirname, '/storage.json');

let storage = {};
let count = 0;

module.exports = {
    put: (key, value) => {
        if (typeof (key) !== 'string') {
            throw new Error('Key is not a string!');
        }
        
        if (storage.hasOwnProperty(key)) {
            throw new Error('Key already in the storage!');
        }

        storage[key] = value;
        count++;
    },
    get: (key) => {

        if (typeof (key) !== 'string') {
            throw new Error('Key is not a string!');
        }

        if (!storage.hasOwnProperty(key)) {
            throw new Error('Key is not found in the storage!');
        }

        return storage[key];
    },
    getAll: () => {
        if (count === 0) {
            throw new Error('Storage is empty');
        }

        return storage;
    },
    update: () => {
        if (typeof (key) !== 'string') {
            throw new Error('Key is not a string!');
        }

        if (!storage.hasOwnProperty(key)) {
            throw new Error('Key is not found in the storage!');
        }

        storage[key] = value;
    },
    delete: (key) => {
        if (typeof (key) !== 'string') {
            throw new Error('Key is not a string!');
        }

        if (!storage.hasOwnProperty(key)) {
            throw new Error('Key is not found in the storage!');
        }
        
        storage[key] = undefined;
        count--;
    },
    clear: () => {
        storage = {};
        count = 0;
        console.log('Storage cleared.');
    },
    saveSync: () => {
        let json = JSON.stringify(storage);
        fs.writeFileSync(storagePath, json);
        console.log('Saved successfully.');
    },
    loadSync: () => {
        let readFileData = fs.readFileSync(storagePath);
        let storage = JSON.parse(readFileData);
        console.log('Loaded successfully.');
    },
    load: () => {
        return new Promise((resolve, reject) => {
            let data = fs.readFile(storagePath, (err, data) => {
                if (err) {
                    reject(err);
                    console.log(err);
                    return;
                }

                storage = JSON.parse(data)
                resolve();
            })
        })
    }

}