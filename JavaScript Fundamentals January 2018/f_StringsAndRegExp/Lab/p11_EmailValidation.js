function emailValidation(str) {
    let emailPattern = /^[A-Za-z0-9]+@[a-z]+\.[a-z]+$/;
    
    console.log(emailPattern.test(str) ? "Valid" : "Invalid");
}
emailValidation("invalid@emai1");