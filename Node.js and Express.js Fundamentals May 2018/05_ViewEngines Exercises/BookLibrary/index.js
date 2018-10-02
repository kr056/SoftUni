const port = 7000;
const config = require('./config/config');
const database = require('./config/dbConfig');
const express = require('express');

let app = express();
let environment = process.env.NODE_ENV || 'development';

database(config[environment]);
require('./config/express')(app,config[environment]);
require('./config/routes')(app);
app.listen(port);
