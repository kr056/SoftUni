function parseEmployeeData(arr) {
    let pat = /^([A-Z][a-zA-Z]*) - ([1-9]\d*) - ([A-Za-z0-9- ]+)$/;

    for (let line of arr) {
        let match = pat.exec(line);
        
        if (match) {
            console.log(`Name: ${match[1]}\nPosition: ${match[3]}\nSalary: ${match[2]}`);
        }
    }
}
parseEmployeeData(['Jonathan - 2000 - Manager', 'George - 1000 - Team Leader ', 'Peter- 1000- Chuck'])