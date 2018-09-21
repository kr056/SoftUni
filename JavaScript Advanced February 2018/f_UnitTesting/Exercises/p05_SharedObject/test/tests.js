let expect = require('chai').expect;
let sharedObject = require('../shared-object').sharedObject;
this.jsdom = require('jsdom-global')();
let $ = require('jquery');


document.body.innerHTML = `<body><div id="wrapper">
        <input type="text" id="name">
        <input type="text" id="income">
    </div>
</body>`;


