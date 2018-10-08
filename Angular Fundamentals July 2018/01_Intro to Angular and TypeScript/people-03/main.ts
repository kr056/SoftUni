function showResult() {
    let junior: Junior = new Junior('Bat Georgi', 21);
    let senior : Senior = new Senior('Bat Ivan',21);
    let manager : Manager = new Manager('Bat Dimo',22);

    junior.collectSalary();
    senior.collectSalary();
    manager.collectSalary();
}
showResult()