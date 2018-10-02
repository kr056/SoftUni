const mongoose = require('mongoose');
const connectionString = 'mongodb://localhost:27017/MongoPlayground';

mongoose.Promise = global.Promise;

module.exports = mongoose.connect(connectionString);