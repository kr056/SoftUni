var Data = /** @class */ (function () {
    function Data(method, url, version, message) {
        this.method = method;
        this.url = url;
        this.version = version;
        this.message = message;
        this.fulfilled = false;
    }
    return Data;
}());
var request = new Data('GET', 'http://google.com', 'HTTP/1.1', 'Kvo stava');
console.log(request);
