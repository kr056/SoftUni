function validate() {
    let usernamePat = /^[a-zA-Z0-9]{3,20}$/;
    let emailPat = /.*?@.*?\.+/;
    let passwordPat = /^\w{5,15}$/;

    let username = $('#username');
    let email = $('#email');
    let password = $('#password');
    let confirm = $('#confirm-password');
    let checkBox = $('#company');

    let companyInfo;
    let companyNumber;

    let isValid = true;
    let isChecked = false;

    checkBox.on('change', function () {
        if (checkBox.is(':checked')) {
            companyInfo = $('#companyInfo');
            companyInfo.css('display', 'block');
            companyNumber = $('#companyNumber');
            isChecked = true;
        }
    });

    let submitBtn = $('#submit');
    submitBtn.on('click', function (ev) {
        ev.preventDefault();
        if (!usernamePat.test(username.val())) {
            username.css('border-color', 'red');
            isValid = false;
        }

        if (!emailPat.test(email.val())) {
            email.css('border-color', 'red');
            isValid = false;
        }

        if (!passwordPat.test(password.val())) {
            password.css('border-color', 'red');
            isValid = false;
        }

        if (!passwordPat.test(confirm.val())
            || confirm.val() !== password.val()) {
            confirm.css('border-color', 'red');
            isValid = false;
        }

        if (isChecked) {
            if (Number(companyNumber.val() < 1000 ||
                Number(companyNumber.val() > 9999))) {
                companyNumber.css('border-color', 'red');
                isValid = false;
            }
        }

        if (isValid) {
            $('#valid').css('display', 'block');
        } else {
            $('#valid').css('display', 'none');
        }
    })

}
