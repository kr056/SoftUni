import observer from '../observer'

function validateCategory(data) {
    if (data.categoryName === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Category is required!' })
        return false
    }
    
    return true
}

export default {
    validateCategory
}