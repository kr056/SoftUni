let d = (function strExtension() {
    String.prototype.ensureStart = function (item) {
        if (!this.toString().startsWith(item)) {
            return item + this.toString();
        }

        return this.toString();
    };

    String.prototype.ensureEnd = function (item) {
        if (!this.toString().endsWith(item)) {
            return this + item.toString();
        }
        
        return this.toString();
    };

    String.prototype.isEmpty = function () {
        return this.toString() === '';
    };

    String.prototype.truncate = function (n) {
        if (n < 4) {
            return '.'.repeat(n);
        }

        if (this.toString().length <= n) {
            return this.toString();
        } else {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(' ');
            if (lastIndex !== -1) {
                return this.toString().substr(0, lastIndex) + '...';
            } else {
                return this.toString().substr(0, n - 3) + '...';
            }
        }
    };


    String.format = function (str, ...args) {
        let result = str;
        for (let i = 0; i < args.length; i++) {
            result = result.replace(`{${i}}`, args[i]);
        }
        return result;
    };


})();
let str = 'my string'
str = str.ensureStart('my')
str = str.ensureStart('hello ')
str = str.truncate(16)
str = str.truncate(14)
str = str.truncate(8)
str = str.truncate(4)
console.log(str);
