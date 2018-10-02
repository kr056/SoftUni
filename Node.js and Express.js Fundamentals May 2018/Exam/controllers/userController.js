const User = require('../models/User');
const encryption = require('../utilities/encryption');

module.exports.registerGet = (req, res) => {
    res.render('users/register');
}

module.exports.registerPost = (req, res) => {
    let user = {
        username: req.body.username,
        password: req.body.password,
        confirmedPassword: req.body.confirmedPassword
    }

    if (user.password && user.password !== user.confirmedPassword) {
        res.render('users/register', { error: 'Passwords do not match.' });

        return;
    }

    let salt = encryption.generateSalt();
    user.salt = salt;

    if (user.password) {
        let hashedPassword = encryption.generateHashedPassword(salt, user.password);
        user.password = hashedPassword;
    }

    User.create(user).then(user => {
        req.logIn(user, (error, user) => {
            if (error) {
                res.render('users/register', { error: 'Authentication not working!' });

                return;
            }

            res.redirect('/');
        })
    }).catch(error => {
        res.render('users/register', { error: error.message });
    })
}

module.exports.loginGet = (req, res) => {
    res.render('users/login');
}

module.exports.loginPost = (req, res) => {
    let userToLogin = {
        username: req.body.username,
        password: req.body.password
    };

    User.findOne({ username: userToLogin.username }).then(user => {
        if (!user || !user.authenticate(userToLogin.password)) {
            res.render('users/login', { error: 'Invalid credentials!' });
        } else {
            req.logIn(user, (error, user) => {
                if (error) {
                    res.render('users/login', { error: 'Authentication not working!' });
                    return;
                }

                res.redirect('/');
            })
        }
    })
}

module.exports.logout = (req, res) => {
    req.logout();
    res.redirect('/');
}

