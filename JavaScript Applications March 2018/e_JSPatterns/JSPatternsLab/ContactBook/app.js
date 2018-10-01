const handlers= {};

$(() => {
    const app = Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        this.get('#/index.html',handlers.homeHandler);

        this.get('#/register', (ctx) => {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                navigation: './templates/common/navigation.hbs',
                footer: './templates/common/footer.hbs',
            }).then(function () {
                this.partial('./templates/forms/registerForm.hbs');
            });
        });

        this.post('#/register', (ctx) => {
            let username = ctx.params.username;
            let pass = ctx.params.pass;
            let repeatPass = ctx.params.repeatPass;

            if (pass !== repeatPass) {
                alert('Pass do not match');
            } else {
                auth.register(username, pass);
                ctx.redirect('#/index.html');
            }
        });

        this.post('#/login', (ctx) => {
            let username = ctx.params.username;
            let pass = ctx.params.pass;
            auth.login(username, pass)
                .then((res) => {
                    auth.saveSession(res);
                    ctx.redirect('#/index.html');
                });
        })
    });

    app.run();
});
