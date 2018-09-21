function monkeyPatcher(action) {
    let post = this;

    let obj = (() => {
        function upvote() {
            post.upvotes++;
        }

        function downvote() {
            post.downvotes++;
        }

        function score() {
            let score = post.upvotes - post.downvotes;
            let toAdd = Math.ceil(Math.max(post.upvotes, post.downvotes) * 0.25);
            let repUp = post.upvotes;
            let repDown = post.downvotes;

            if (post.upvotes + post.downvotes > 50) {
                repUp = post.upvotes + toAdd;
                repDown = post.downvotes + toAdd;
            }

            let rating = '';

            if (post.upvotes + post.downvotes < 10) {
                rating = 'new';
            } else if (post.upvotes > (post.upvotes + post.downvotes) * 0.66) {
                rating = 'hot';
            } else if (score >= 0 && (post.upvotes > 100 || post.downvotes > 100)) {
                rating = 'controversial';
            } else if (score < 0) {
                rating = 'unpopular';
            } else {
                rating = 'new';
            }

            return [repUp, repDown, score, rating];

        }

        return { upvote, downvote, score };
    })();
    
    return obj[action]();
}

let input = {
    id: '1',
    author: 'pesho',
    content: 'hi guys',
    upvotes: 0,
    downvotes: 0
}
monkeyPatcher.call(input, 'upvote');
console.log(monkeyPatcher.call(input, 'score'));
