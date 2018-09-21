function requestValidator(obj) {
    let methods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    let uriPat = /^[a-zA-Z0-9.]+$/;
    let versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    let messagePat = /^[^<>\\&'"]*$/;

    let methodError = 'Invalid request header: Invalid Method';
    let uriError = 'Invalid request header: Invalid URI';
    let versionError = 'Invalid request header: Invalid Version';
    let messageError = 'Invalid request header: Invalid Message';

    if (!obj.hasOwnProperty('method')) {
        throw new Error(methodError);
    } else {
        if (!methods.includes(obj.method)) {
            throw new Error(methodError);
        }
    }

    if (!obj.hasOwnProperty('uri')) {
        throw new Error(uriError);
    } else {
        if (!uriPat.exec(obj.uri)) {
            throw new Error(uriError);
        }
    }

    if (!obj.hasOwnProperty('version')) {
        throw new Error(versionError);
    } else {
        if (!versions.includes(obj.version)) {
            throw new Error(versionError);
        }
    }

    if (!obj.hasOwnProperty('message')) {
        throw new Error(messageError);
    } else {
        if (!messagePat.exec(obj.message)) {
            throw new Error(messageError);
        }
    }

    return obj;
}

console.log(requestValidator({
    method: ' GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
}));