$(() => {
    const app = Sammy('#container', function () {
        this.use('Handlebars', 'hbs');

        //HOME VIEW
        this.get('#/home', getWelcomePage);
        this.get('index.html', getWelcomePage);

        //REGISTER
        this.post('#/register', (ctx) => {
            let username = ctx.params.username;
            let password = ctx.params.password;
            let repeatPass = ctx.params.repeatPass;

            if (!/^[A-Za-z]{3,}$/.test(username)) {
                notify.showError('Username should be at least 3 characters long and contain only english alphabet letters.')
            } else if (!/^[A-Za-z0-9]{6,}$/.test(password)) {
                notify.showError('Password should be at least 6 characters long.')
            } else if (password !== repeatPass) {
                notify.showError('Passwords should match.')
            } else {
                auth.register(username, password)
                    .then((userData) => {
                        auth.saveSession(userData);
                        notify.showInfo('Registration successful.');
                        ctx.redirect('#/catalog');
                    }).catch(notify.handleError);
            }
        });

        //LOGIN
        this.post('#/login', (ctx) => {
            let username = ctx.params.username;
            let password = ctx.params.password;
            if (username === '' || password === '') {
                notify.showError('All fields must not be empty.')
            } else {
                auth.login(username, password)
                    .then((userData) => {
                        auth.saveSession(userData);
                        notify.showInfo('Login successful.');
                        ctx.redirect('#/catalog');
                    }).catch(notify.handleError);
            }
        });

        //LOGOUT
        this.get('#/logout', (ctx) => {
            auth.logout()
                .then(() => {
                    sessionStorage.clear();
                    notify.showInfo('Logout successful.');
                    ctx.redirect('#/home');
                }).catch(notify.handleError);
        });

        //CATALOG
        this.get('#/catalog', function (ctx) {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            posts.getAllPosts()
                .then((posts) => {
                    posts.forEach((p, i) => {
                        p.rank = i + 1;
                        p.date = calcTime(p._kmd.ect);
                        p.isAuthor = p._acl.creator === sessionStorage.getItem('userId');

                        ctx.isAuth = auth.isAuth();
                        ctx.username = sessionStorage.getItem('username');
                        ctx.posts = posts;

                        ctx.loadPartials({
                            header: './templates/common/header.hbs',
                            footer: './templates/common/footer.hbs',
                            navigation: './templates/common/navigation.hbs',
                            postsList: './templates/posts/postsList.hbs',
                            post: './templates/posts/post.hbs',
                        }).then(function () {
                            this.partial('./templates/posts/catalogPage.hbs');
                        });
                    });
                });
        });

        //CREATE_POST LOGIC
        this.get('#/create/post', function (ctx) {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            ctx.isAuth = auth.isAuth();
            ctx.username = sessionStorage.getItem('username');
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                navigation: './templates/common/navigation.hbs',
            }).then(function () {
                this.partial('./templates/posts/createPostPage.hbs')
            });
        });

        this.post('#/create/post', function (ctx) {
            let url = ctx.params.url;
            let imageUrl = ctx.params.imageUrl;
            let title = ctx.params.title;
            let description = ctx.params.description;
            let author = sessionStorage.getItem('username');

            if (title === '') {
                notify.showError('Title is required!');
            } else if (url === '' || !(url.startsWith('http://') || url.startsWith('https://'))) {
                notify.showError('Url is required and must start with "http"!');
            } else {
                posts.createPost(author, title, description, url, imageUrl)
                    .then(() => {
                        notify.showInfo('Post created.');
                        ctx.redirect('#/catalog');
                    }).catch(notify.handleError);
            }
        });

        //EDIT_POST LOGIC
        this.get('#/edit/post/:postId', function (ctx) {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            let postId = ctx.params.postId;
            posts.getPostById(postId)
                .then((post) => {
                    ctx.isAuth = auth.isAuth();
                    ctx.username = sessionStorage.getItem('username');
                    ctx.post = post;
                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        navigation: './templates/common/navigation.hbs',
                    }).then(function () {
                        this.partial('./templates/posts/editPostPage.hbs')
                    });
                });
        });

        this.post('#/edit/post', function (ctx) {
            let postId = ctx.params.postId;
            console.log(postId);
            let url = ctx.params.url;
            let imageUrl = ctx.params.imageUrl;
            let title = ctx.params.title;
            let description = ctx.params.description;
            let author = sessionStorage.getItem('username');

            if (title === '') {
                notify.showError('Title is required!');
            } else if (url === '' || !(url.startsWith('http://') || url.startsWith('https://'))) {
                notify.showError('Url is required and must start with "http"!');
            } else {
                posts.editPost(postId, author, title, description, url, imageUrl)
                    .then(() => {
                        notify.showInfo(`Post ${title} edited.`);
                        ctx.redirect('#/catalog');
                    }).catch(notify.handleError);
            }
        });

        //DELETE_POST LOGIC
        this.get('#/delete/post/:postId', function (ctx) {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            let postId = ctx.params.postId;

            posts.deletePost(postId)
                .then(function () {
                    notify.showInfo('Post deleted.');
                    ctx.redirect('#/catalog');
                }).catch(notify.handleError);
        });

        //MY_POSTS LOGIC
        this.get('#/posts', function (ctx) {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            let username = sessionStorage.getItem('username');


            posts.getMyPosts(username)
                .then((posts) => {
                    posts.forEach((p, i) => {
                        p.rank = i + 1;
                        p.date = calcTime(p._kmd.ect);

                        ctx.isAuth = auth.isAuth();
                        ctx.username = username;
                        ctx.posts = posts;

                        ctx.loadPartials({
                            header: './templates/common/header.hbs',
                            footer: './templates/common/footer.hbs',
                            navigation: './templates/common/navigation.hbs',
                            postsList: './templates/posts/postsList.hbs',
                            post: './templates/posts/post.hbs',
                        }).then(function () {
                            this.partial('./templates/posts/myPostsPage.hbs');
                        });
                    });
                });
        });

        //POST_DETAILS LOGIC
        this.get('#/details/:postId', function (ctx) {
            let postId = ctx.params.postId;

            const postPromise = posts.getPostById(postId);
            const allCommentsPromise = comments.getPostComments(postId);

            Promise.all([postPromise, allCommentsPromise])
                .then(([post, comments]) => {
                    post.date = calcTime(post._kmd.ect);
                    post.isAuthor = post._acl.creator === sessionStorage.getItem('userId');
                    comments.forEach((c) => {
                        c.date = calcTime(c._kmd.ect);
                        c.commentAuthor = c._acl.creator === sessionStorage.getItem('userId');
                    });

                    ctx.isAuth = auth.isAuth();
                    ctx.username = sessionStorage.getItem('username');
                    ctx.post = post;
                    ctx.comments = comments;

                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        navigation: './templates/common/navigation.hbs',
                        postDetails: './templates/details/postDetails.hbs',
                        comment: './templates/details/comment.hbs',
                    }).then(function () {
                        this.partial('./templates/details/postDetailsPage.hbs');
                    });
                });
        });

        //CREATE_COMMENT
        this.post('#/create/comment', function (ctx) {
            let author = sessionStorage.getItem('username');
            let content = ctx.params.content;
            let postId = ctx.params.postId;

            if (content === '') {
                notify.showError('Can not add empty comment!');
                return;
            }

            comments.createComment(postId, content, author)
                .then(() => {
                    notify.showInfo('Added new comment.');
                    ctx.redirect(`#/details/${postId}`);
                }).catch(notify.handleError)
        });

        //DELETE_COMMENT
        this.get('#/comment/delete/:commentId/post/:postId', function (ctx) {
            let commentId = ctx.params.commentId;
            let postId = ctx.params.postId;

            comments.deleteComment(commentId)
                .then(() => {
                    notify.showInfo('Comment deleted.');
                    // ctx.redirect(`#/delete/${postId}`);
                    window.history.go(-1);
                }).catch(notify.handleError);
        });


        function getWelcomePage(ctx) {
            if (!auth.isAuth()) {
                ctx.loadPartials({
                    header: './templates/common/header.hbs',
                    footer: './templates/common/footer.hbs',
                    loginForm: './templates/forms/loginForm.hbs',
                    registerForm: './templates/forms/registerForm.hbs',
                }).then(function () {
                    this.partial('./templates/welcome-anonymus.hbs');
                })
            } else {
                ctx.redirect('#/catalog');
            }
        }

        function calcTime(dateIsoFormat) {
            let diff = new Date - (new Date(dateIsoFormat));
            diff = Math.floor(diff / 60000);
            if (diff < 1) return 'less than a minute';
            if (diff < 60) return diff + ' minute' + pluralize(diff);
            diff = Math.floor(diff / 60);
            if (diff < 24) return diff + ' hour' + pluralize(diff);
            diff = Math.floor(diff / 24);
            if (diff < 30) return diff + ' day' + pluralize(diff);
            diff = Math.floor(diff / 30);
            if (diff < 12) return diff + ' month' + pluralize(diff);
            diff = Math.floor(diff / 12);
            return diff + ' year' + pluralize(diff);
            function pluralize(value) {
                if (value !== 1) return 's';
                else return '';
            }
        }
    });


    app.run();
});