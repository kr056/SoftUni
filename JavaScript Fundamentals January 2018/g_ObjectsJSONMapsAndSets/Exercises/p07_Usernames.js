function usernamesCatalogue(arr) {
    let names = new Set();

    for (let i = 0; i < arr.length; i++) {
        names.add(arr[i]);
    }
    
    [...names].sort((n1, n2) => {
        if (n1.length > n2.length) {
            return 1;
        } else if (n2.length > n1.length) {
            return -1;
        } else {
            if (n1 > n2) {
                return 1;
            } else if (n2 > n1) {
                return -1;
            } else {
                return 0;
            }
        }
    }).forEach(x => console.log(x))

}
usernamesCatalogue(['Ashton', 'Abbbbb'])