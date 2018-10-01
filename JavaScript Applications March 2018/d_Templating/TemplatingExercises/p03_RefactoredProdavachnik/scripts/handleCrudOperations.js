/**
 * Created by BooM on 2.4.2018 г..
 */
const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HkEZ11ejG';
const APP_SECRET = '8589123654ce413c8f101ed41a250acc';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};

function registerUser() {
    let username = $('#formRegister').find('input[name=username]').val();
    let password = $('#formRegister').find('input[name=passwd]').val();
    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '/',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        signInUser(res, 'Registration successful');
    }).catch(handleAjaxError)
}

function loginUser() {
    let username = $('#formLogin').find('input[name=username]').val();
    let password = $('#formLogin').find('input[name=passwd]').val();
    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '/login',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        signInUser(res, 'Login successful');
    }).catch(handleAjaxError);
}

function listAds() {
    $.ajax({
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function (adsArr) {
       showAdsView(adsArr);
    }).catch(handleAjaxError)
}

function createAd() {
    let title = $('#formCreateAd').find('input[name=title]').val();
    let publisher = sessionStorage.getItem('username');
    let description = $('#formCreateAd').find('textarea[name=description]').val();
    let date = $('#formCreateAd').find('input[name=datePublished]').val();
    let price = $('#formCreateAd').find('input[name=price]').val();
    $.ajax({
        method: 'POST',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
        data: {publisher, price, date, description, title}
    }).then(function () {
        showInfo('Ad created.');
        listAds();
    }).catch(handleAjaxError);
}

function deleteAd(id) {
    $.ajax({
        method: 'DELETE',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + id,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
    }).then(function () {
        showInfo('Ad deleted.');
        listAds();
    }).catch(handleAjaxError);
}

function loadAdForEdit(id) {
    $.ajax({
        method: 'GET',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + id,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
    }).then(function (ad) {
        showView('viewEditAd');
        $('#formEditAd').find('input[name=id]').val(ad._id);
        $('#formEditAd').find('input[name=title]').val(ad.title);
        $('#formEditAd').find('textarea[name=description]').val(ad.description);
        $('#formEditAd').find('input[name=datePublished]').val(ad.date);
        $('#formEditAd').find('input[name=price]').val(ad.price);
    });
}

function editAd() {
    let id = $('#formEditAd').find('input[name=id]').val();
    let title = $('#formEditAd').find('input[name=title]').val();
    let description = $('#formEditAd').find('textarea[name=description]').val();
    let date = $('#formEditAd').find('input[name=datePublished]').val();
    let price = $('#formEditAd').find('input[name=price]').val();
    let publisher = sessionStorage.getItem('username');
    $.ajax({
        method: 'PUT',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + id,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')},
        data: {publisher: publisher, price: price, date: date, description: description, title: title}
    }).then(function () {
        showInfo('Ad edited.');
        listAds();
    })
}

function logoutUser() {
    sessionStorage.clear();

    showHideMenuLinks();
    showHomeView();
    showInfo('Logout successful.')
}

function signInUser(res, message) {
    sessionStorage.setItem('username', res.username);
    sessionStorage.setItem('authToken', res._kmd.authtoken);
    sessionStorage.setItem('userId', res._id);
    showHomeView();
    showHideMenuLinks();
    showInfo(message);
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response);
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error.";
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description;
    showError(errorMsg)
}