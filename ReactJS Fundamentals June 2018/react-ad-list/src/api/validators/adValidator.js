import observer from '../observer'

function validateAd(data) {

    if (data.title === undefined || data.title === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Ad Title is required!' })
        return false
    }
    if (data.category === undefined || data.category === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Category for your ad is required!' })
        return false
    }
    if (data.condition === undefined || data.condition === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Product Condition is required!' })
        return false
    }
    if (data.price === undefined || data.price === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Product Price is required!' })
        return false
    }
    if (data.image === undefined || data.image === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Product Image is required!' })
        return false
    }
    if (data.authorName === undefined || data.authorName === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Author Name is required!' })
        return false
    }
    if (data.authorCity === undefined || data.authorCity === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Author City is required!' })
        return false
    }
    if (data.authorPhone === undefined || data.authorPhone === '') {
        observer.trigger(observer.events.notification, { type: 'error', message: 'Author Phone is required!' })
        return false
    }
    return true
}

export default {
    validateAd
}