function getUsernames(arr) {
    let usernames = [];

    for (let i = 0; i < arr.length; i++) {
        let tokens = arr[i].split('@');
        let username = tokens[0] + '.';
        let domain = tokens[1];
        domain.split('.').forEach(x => username += x[0]);
        usernames.push(username);
    }
    
    console.log(usernames.join(', '));
}
getUsernames(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com'])
