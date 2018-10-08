class Data {

    method: string
    url: string
    version: string
    message: string
    response: undefined
    fulfilled: boolean

    constructor(method: string, url: string, version: string, message: string) {
        this.method = method;
        this.url=url;
        this.version=version;
        this.message=message;
        this.fulfilled=false;
    }
}

let request : Data = new Data('GET','http://google.com','HTTP/1.1','Kvo stava');

console.log(request);