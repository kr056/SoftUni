import requester from '../requester'

function login(userData) {
    return requester.post('user', 'login', 'basic', userData)
}

function guestLogin() {
    return requester.post('user', 'login', 'basic', { username: 'guest', password: 'guest' })
}

function getUser(userId) {
    return requester.get('user', userId, 'kinvey')
}

function register(userData) {
    return requester.post('user', '', 'basic', userData)
}

function logout() {
    return requester.post('user', '_logout', 'kinvey')
}

export default {
    login,
    guestLogin,
    register,
    getUser,
    logout
}