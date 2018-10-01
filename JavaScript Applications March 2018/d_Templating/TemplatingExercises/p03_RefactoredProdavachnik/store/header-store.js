(function () {
    class Header {
        constructor(id, text) {
            this.id = id;
            this.text = text;
        }
    }

    let loggedInHeaders = [
        new Header('linkHome', 'Home'),
        new Header('linkListAds', 'List Advertisements'),
        new Header('linkCreateAd', 'Create Advertisements'),
        new Header('linkLogout', 'Logout')
    ];


    let basicHeaders = [
        new Header('linkHome', 'Home'),
        new Header('linkLogin', 'Login'),
        new Header('linkRegister', 'Register')
    ];

    window.headers = {
        loggedInHeaders,
        basicHeaders
    };
})()