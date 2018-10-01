$(() => {
    const app = Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        //HOME LOGIC

        this.get('#/home', function (ctx) {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');
            ctx.hasTeam = sessionStorage.getItem('teamId') !== 'undefined' || sessionStorage.getItem('teamId') !== null;
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
            }).then(function () {
                this.partial('./templates/home/home.hbs');
            });
        });

        //ABOUT LOGIC

        this.get('#/about', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
            }).then(function () {
                this.partial('./templates/about/about.hbs');
            });
        });

        //REGISTER LOGIC

        this.get('#/register', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                registerForm: './templates/register/registerForm.hbs',
            }).then(function () {
                this.partial('./templates/register/registerPage.hbs');
            });
        });

        this.post('#/register', (ctx) => {
            let username = ctx.params.username;
            let password = ctx.params.password;
            let repeatPass = ctx.params.password;

            if (password !== repeatPass) {
                alert('Pass do not match');
            } else {
                auth.register(username, password)
                    .then((res) => {
                        auth.saveSession(res);
                        auth.showInfo('You have registered successfully');
                        ctx.redirect('#/home');

                    });
            }
        });

        //LOGIN LOGIC

        this.get('#/login', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                loginForm: './templates/login/loginForm.hbs',
            }).then(function () {
                this.partial('./templates/login/loginPage.hbs');
            });
        });


        this.post('#/login', function (ctx) {
            let username = ctx.params.username;
            let password = ctx.params.password;

            auth.login(username, password)
                .then((res) => {
                    auth.saveSession(res)
                    auth.showInfo('You have logged in successfully');
                    ctx.redirect('#/home');
                });
        });

        // LOGOUT LOGIC

        this.get('#/logout', function (ctx) {
            auth.logout()
                .then(function () {
                    sessionStorage.clear();
                    auth.showInfo('Logged out');
                    ctx.redirect('#/home');
                })
        });

        //TEAM CATALOG

        this.get('#/catalog', function (ctx) {
            teamsService.loadTeams()
                .then((userData) => {
                    ctx.teams = userData;
                    ctx.loggedIn = auth.isAuth();
                    ctx.username = sessionStorage.getItem('username');
                    ctx.hasTeam = ctx.hasTeam = sessionStorage.getItem('teamId') !== null;
                    ctx.hasNoTeam = ctx.hasTeam = sessionStorage.getItem('teamId') === 'undefined' || sessionStorage.getItem('teamId') === null;


                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        team: './templates/catalog/team.hbs',
                    }).then(function () {
                        this.partial('./templates/catalog/teamCatalog.hbs');
                    });
                });
        });

        //TEAM DETAILS

        this.get('#/catalog/:id', function (ctx) {
            // ctx.hasNoTeam = !auth.hasTeam();
            let teamId = ctx.params.id.substring(1);
            teamsService.loadTeamDetails(teamId)
                .then((teamInfo) => {
                    ctx.name = teamInfo.name;
                    ctx.username = sessionStorage.getItem('username');
                    ctx.members = teamInfo.members;
                    ctx.comment = teamInfo.comment;
                    ctx.teamId = teamInfo._id;
                    ctx.isOnTeam = teamInfo._id === sessionStorage.getItem('teamId');
                    ctx.isAuthor = teamInfo._acl.creator === sessionStorage.getItem('userId');
                    ctx.loggedIn = auth.isAuth();

                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        team: './templates/catalog/team.hbs',
                        teamControls: './templates/catalog/teamControls.hbs',
                    }).then(function () {
                        this.partial('./templates/catalog/details.hbs');
                    });
                });
        });

        //CREATE TEAM

        this.get('#/create', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                createForm: './templates/create/createForm.hbs',
            }).then(function () {
                this.partial('./templates/create/createPage.hbs');
            });
        });

        this.post('#/create', function (ctx) {
            let name = ctx.params.name;
            let comment = ctx.params.comment;

            teamsService.createTeam(name, comment).then(function (data) {
                teamsService.joinTeam(data._id).then(function (newData) {
                    auth.saveSession(newData);
                    auth.showInfo('You have created a team successfully');
                    ctx.redirect('#/catalog');

                });
            })
        });

        //LEAVE TEAM

        this.get('#/leave', function (ctx) {

            teamsService.leaveTeam().then(function (response) {
                auth.saveSession(response);
                auth.showInfo('You left the team successfully');
                ctx.redirect('#/catalog');
            })
        });

        //JOIN TEAM

        this.get('#/join/:id', function (ctx) {
            let teamId = this.params.id.substring(1);

            teamsService.joinTeam(teamId).then(function (data) {
                auth.saveSession(data);
                auth.showInfo('You joined the team successfully');
                ctx.redirect('#/catalog');
            })
        });

        //EDIT TEAM
        this.get('#/edit/:id', function (ctx) {
            ctx.loggedIn = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');
            ctx.teamId = this.params.id.substring(1);

            teamsService.loadTeamDetails(ctx.teamId).then(function (data) {
                ctx.name = data.name;
                ctx.comment = data.comment;

                ctx.loadPartials({
                    header: './templates/common/header.hbs',
                    footer: './templates/common/footer.hbs',
                    editForm: './templates/edit/editForm.hbs',
                }).then(function () {
                    this.partial('./templates/edit/editPage.hbs');
                });
            });
        });

        this.post('#/edit/:id', function (ctx) {
            let teamId = ctx.params.id.substring(1);
            let name = ctx.params.name;
            let comment = ctx.params.comment;

            teamsService.edit(teamId, name, comment).then(function (data) {
                teamsService.joinTeam(data._id).then(function () {
                    auth.showInfo('You have edited a team successfully');
                    ctx.redirect('#/catalog');
                });
            })
        });

    });

    app.run();
})
;