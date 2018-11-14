import observer from '../observer'

function validateRegister(userData) {
    if(userData.username===''){
        observer.trigger(observer.events.notification, { type: 'error', message: 'Username is required!' })
        return false
    }
    if(userData.password===''){
        observer.trigger(observer.events.notification, { type: 'error', message: 'Password is required!' })
        return false
    }
    if(userData.password!==userData.confirmedPassword){
        observer.trigger(observer.events.notification, { type: 'error', message: 'Passwords do not match!' })
        return false
    }
    return true
}

function validateLogin(userData) {
    if(userData.username===''){
        observer.trigger(observer.events.notification, { type: 'error', message: 'Username is required!' })
        return false
    }
    if(userData.password===''){
        observer.trigger(observer.events.notification, { type: 'error', message: 'Password is required!' })
        return false
    }
    return true
}

export default {
    validateLogin,
    validateRegister,
}