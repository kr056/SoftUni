/**
 * Created by BooM on 2.4.2018 г..
 */
function showView(viewName) {
    $('main > section').hide();
    $('#' + viewName).show();
}

async function showHideMenuLinks() {
    let authtoken = sessionStorage.getItem('authToken');
    let headers = window.headers.basicHeaders;

    if (authtoken) {
        headers = window.headers.loggedInHeaders;
    }

    let source = await $.get('./templates/header-template.hbs');
    let compiled = Handlebars.compile(source);
    let template = compiled({
        headers
    });

    let menu = $('#menu');
    $(menu).empty();
    $(menu).append(template);

    attachAllEvents();
}


function showInfo(message) {
    let infoBox = $('#infoBox');
    infoBox.text(message);
    infoBox.show();
    setTimeout(function () {
        $('#infoBox').fadeOut();
    }, 3000)
}

function showError(errorMsg) {
    let errorBox = $('#errorBox')
    errorBox.text("Error: " + errorMsg)
    errorBox.show()
}

function showHomeView() {
    showView('viewHome')
}

async function showAdsView(adsArr) {
    showView('viewAds');
    $('#viewAds').empty();

    adsArr.forEach(el => {
        if (el._acl.creator === sessionStorage.getItem('userId')) {
            el.isAuthor = true;
        }
    });
    adsArr.map(el => {
        el.price = Number(el.price);
    });

    let source = await $.get('./templates/view-ads-template.hbs');
    let compiled = Handlebars.compile(source);
    let template = compiled({adsArr: adsArr});
    $('#viewAds').append(template);

    $('#btnDeleteAd').on('click', function () {
        let id = $(this).parent().parent().attr('id');
        deleteAd(id);
    });
    $('#btnEditAd').on('click', function () {
        let id = $(this).parent().parent().attr('id');
        showEditAdView();
        loadAdForEdit(id);
    })

}

function showLoginView() {
    showView('viewLogin');
    $('#formLogin').trigger('reset');

    appendLoginSection();

    async function appendLoginSection() {
        let loginSection = window.userOperations.loginSection;

        let source = await $.get('./templates/user-operations-template.hbs');
        let compiled = Handlebars.compile(source);
        let template = compiled(loginSection);
        $('#viewLogin').empty();
        $('#viewLogin').append(template);

        $('#buttonLoginUser').on('click', loginUser);
    }
}

function showRegisterView() {
    $('#formRegister').trigger('reset');
    showView('viewRegister');
    appendRegisterSection();

    async function appendRegisterSection() {
        let registerSection = window.userOperations.registerSection;

        let source = await $.get('./templates/user-operations-template.hbs');
        let compiled = Handlebars.compile(source);
        let template = compiled(registerSection);
        $('#viewRegister').empty();
        $('#viewRegister').append(template);

        $('#buttonRegisterUser').on('click', registerUser);
    }

}

function showCreateAdView() {
    $('#formCreateAd').trigger('reset');
    showView('viewCreateAd');
    appendCreateAdSection();

    async function appendCreateAdSection() {
        let isCreateForm = true;
        let source = await $.get('./templates/edit-create-ad-template.hbs');
        let compiled = Handlebars.compile(source);
        let context = {isCreateForm: isCreateForm};
        let template = compiled(context);
        $('#viewCreateAd').empty();
        $('#viewCreateAd').append(template);

        $('#buttonCreateAd').on('click', createAd);
    }
}

function showEditAdView() {
    showView('viewEditAd');
    appendEditAdSection();

    async function appendEditAdSection() {
        let isCreateForm = false;
        let source = await $.get('./templates/edit-create-ad-template.hbs');
        let compiled = Handlebars.compile(source);
        let context = {isCreateForm: isCreateForm};
        let template = compiled(context);
        $('#viewEditAd').empty();
        $('#viewEditAd').append(template);

        $('#buttonEditAd').on('click', editAd);
    }
}