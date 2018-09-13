function solve(arr) {

    let students = arr.map(JSON.parse);

    students.forEach(student=>{
        let studentStr=
            `Name: ${student.name}\n`+
            `Age: ${student.age}\n` +
            `Date: ${student.date}`;

        console.log(studentStr);
    });


}
