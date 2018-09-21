function personAndTeacher() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }
    }

    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email);
            this.subject = subject;
        }
    }

    return {
        Person,
        Teacher
    };
}

let c = personAndTeacher().Teacher;
let t = new c('Djoni', 'b@bg.d', 'fishsticks');
console.log(t);