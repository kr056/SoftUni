import requester from '../requester'

function createAd(data) {
    return requester.post('appdata', 'ads', 'kinvey', data)
}

function editAd(adId, data) {
    return requester.update('appdata', 'ads/' + adId, 'kinvey', data)
}

function deleteAd(adId) {
    return requester.remove('appdata', 'ads/' + adId, 'kinvey')
}

function getAds() {
    return requester.get('appdata', 'ads', 'kinvey')
}

function getUserAds(data) {
    return requester.get('appdata', 'ads', 'kinvey', data)
}

function getAdDetails(data) {
    return requester.get('appdata', 'ads', 'kinvey', data)
}

function getAdsByCategory(data) {
    return requester.get('appdata', 'ads', 'kinvey', {category:data})
}

function getAdForOperations(adId) {
    return requester.get('appdata', 'ads/'+adId, 'kinvey')
}


export default {
    createAd,
    getAds,
    getAdsByCategory,
    editAd,
    deleteAd,
    getAdForOperations,
    getUserAds,
    getAdDetails
}