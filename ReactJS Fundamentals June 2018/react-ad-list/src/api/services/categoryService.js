import requester from '../requester'

function createCategory(data) {
    return requester.post('appdata', 'categories', 'kinvey', data)
}

function editCategory(categoryId, data) {
    return requester.update('appdata', 'categories/' + categoryId, 'kinvey', data)
}

function deleteCategory(categoryId) {
    return requester.remove('appdata', 'categories/' + categoryId, 'kinvey')
}


function getCategories() {
    return requester.get('appdata', 'categories', 'kinvey')
}

export default {
    createCategory,
    editCategory,
    deleteCategory,
    getCategories
}