handlers.homeHandler = function (ctx) {
    ctx.isAuth = auth.isAuth();

    $.ajax('data.json')
        .then((contacts) => {
            ctx.contacts = contacts;

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                navigation: './templates/common/navigation.hbs',
                footer: './templates/common/footer.hbs',
                contactsPage: './templates/contactsPage.hbs',
                contact: './templates/contact.hbs',
                contactsList: './templates/contactsList.hbs',
                contactsDetails: './templates/contactsDetails.hbs',
                loginForm: './templates/forms/loginForm.hbs',
            }).then(function () {
                ctx.partials = this.partials;

                render();
            });
        }).catch(console.error);

    function render() {
        ctx.partial('./templates/welcome.hbs')
            .then(attachEvents);
    }

    function attachEvents() {
        $('.contact').on('click', (e) => {
            let index = $(e.target).closest('.contact').attr('data-id');
            ctx.selected = ctx.contacts[index];
            render();
        })
    }
};