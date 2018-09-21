function extensibleObject() {
    let myObj = {};

    myObj.extend = function (template) {
        for (let a in template) {
            if (typeof template[a] === 'function') {
                Object.getPrototypeOf(myObj)[a] = template[a];
            } else {
                myObj[a] = template[a];
            }
        }
    }

    return myObj;
}

let template = {
    extensionMethod: function () {
        console.log('functiofwqqfn')
    },
    randomProp: 'andOne',
    randomProp2: 'andOneTwo'
};

let result = extensibleObject();
result.extend(template);

console.log(result);
result.extensionMethod();