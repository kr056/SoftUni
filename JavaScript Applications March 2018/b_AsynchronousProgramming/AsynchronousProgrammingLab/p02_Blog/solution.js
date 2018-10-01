function attachEvents() {
    const kinveyAppId = 'kid_HJrMbOUqM';
    const serviceUrl = 'https://baas.kinvey.com/appdata/' + kinveyAppId;
    const kinveyUsername = 'peter';
    const kinveyPassword = 'p';
    const base64auth = btoa(kinveyUsername + ':' + kinveyPassword);
    const authHeaders = {"Authorization": 'Basic ' + base64auth};

    $('#btnLoadPosts').on('click', loadPosts)
    $('#btnViewPost').on('click', viewPost)

    function displayError(err) {

        let errorDiv = $('<div>').text(`Error: ${err.status} (${err.statusText})`);
        $(document.body).prepend(errorDiv);

        setTimeout(function () {
            $(errorDiv).fadeOut(function () {
                $(errorDiv).remove();
            })
        }, 3000);
    }

    function loadPosts() {
        let loadPostsRequest = {
            url: serviceUrl + '/posts',
            headers: authHeaders,
        };

        $.ajax(loadPostsRequest)
            .then(displayPosts)
            .catch(displayError)

        function displayPosts(posts) {
            $('#posts').empty();

            for (let post of posts) {
                let option = $('<option>')
                    .text(post.title)
                    .val(post._id);

                $('#posts').append(option);
            }
        }

    }

    function viewPost() {
        let selectedPostId = $('#posts').val();

        let requestedPost = $.ajax({
            url: serviceUrl + '/posts/' + selectedPostId,
            headers: authHeaders
        });

        let requestedComments = $.ajax({
            url: serviceUrl + `/comments/?query={"post_id":"${selectedPostId}"}`,
            headers: authHeaders
        });

        Promise.all([requestedPost, requestedComments])
            .then(displayPostWithComments)
            .catch(displayError);

        function displayPostWithComments([post, comments]) {
            $('#post-title').text(post.title);
            $('#post-body').text(post.body);
            $('#post-comments').empty();

            for (let comment of comments) {
                $("#post-comments").append($('<li>').text(comment.text));
            }
        }
    }

}