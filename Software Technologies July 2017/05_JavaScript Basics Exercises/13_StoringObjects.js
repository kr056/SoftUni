function storeObj(arr) {
    function parseStudent(str) {
        let tokens = str.split(/ -> /);
        let name = tokens[0];
        let age = Number(tokens[1]);
        let grade = Number(tokens[2]);

        let obj = {name: name, age: age, grade: grade};
        return obj;
    }

    let students = arr.map(parseStudent);

    for (let student of students) {
        console.log(`Name: ${student.name}`);
        console.log(`Age: ${student.age}`);
        console.log(`Grade: ${student.grade.toFixed(2)}`);
    }
}
