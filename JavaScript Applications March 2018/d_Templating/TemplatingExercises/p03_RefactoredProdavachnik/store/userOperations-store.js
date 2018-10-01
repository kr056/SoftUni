(function () {
    class Section {
        constructor(formName, buttonId, buttonValue) {
            this.formName = formName;
            this.buttonId = buttonId;
            this.buttonValue = buttonValue;
        }
    }
    let registerSection = new Section('formRegister', 'buttonRegisterUser', 'Register');
    let loginSection = new Section('formLogin', 'buttonLoginUser', 'Login');


    window.userOperations = {
        registerSection,
        loginSection
    };
})();
