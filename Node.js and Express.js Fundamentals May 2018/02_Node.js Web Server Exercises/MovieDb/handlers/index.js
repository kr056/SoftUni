const homeHandler = require('./homeHandler');
const filesHandler = require('./staticFilesHandler');
const viewAllHandler = require('./viewAllHandler');
const addMovieHandler = require('./addMovieHandler');
const detailsHandler = require('./detailsHandler');
const statusHandler = require('./statusHandler');

module.exports = [homeHandler,filesHandler,viewAllHandler,addMovieHandler,detailsHandler,statusHandler];